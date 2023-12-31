package com.orders.demo.services.Order;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Customer;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.Status;
import com.orders.demo.models.Order.OrderRequest.OrderRequest;
import com.orders.demo.services.Customer.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private final IDB database;
    @Autowired
    private final ICustomerService customerService;

    public OrderService(ICustomerService customerService, IDB database) {
        this.database = database;
        this.customerService = customerService;
    }

    @Override
    public boolean createOrder(OrderRequest orderRequest) {
        if (customerService.getCustomer(orderRequest.getName()) == null)
            return false;
        Order order = orderRequest.createOrder(database.getOrders().size());
        if (order == null)
            return false;

        database.addOrder(order);
        return true;
    }

    @Override
    public Boolean placeOrder(int orderID) {

        Order order = getOrder(orderID);
        if (order == null || order.getStatus() != Status.PENDING)
            return false;

        for (Order o : order.getCompositeOrders()) {
            Customer customer = customerService.getCustomer(o.getCustomerUsername());
            if (customer == null)
                return false;

            if (o.getDetails().getTotalPrice() > customer.getBalance())
                return false;
        }

        for (Order o : order.getCompositeOrders()) {
            Customer customer = customerService.getCustomer(o.getCustomerUsername());
            customer.setBalance(customer.getBalance() - o.getDetails().getTotalPrice());
        }
        order.setStatus(Status.PLACED);
        return true;
    }

    @Override
    public Boolean shipOrder(int orderID) {
        Order order = getOrder(orderID);
        if (order == null || order.getStatus() != Status.PLACED)
            return false;

        for (Order o : order.getCompositeOrders()) {
            Customer customer = customerService.getCustomer(o.getCustomerUsername());
            if (customer == null)
                return false;

            if (o.getDetails().getDeliveryFee() > customer.getBalance())
                return false;
        }

        for (Order o : order.getCompositeOrders()) {
            Customer customer = customerService.getCustomer(o.getCustomerUsername());
            customer.setBalance(customer.getBalance() - o.getDetails().getDeliveryFee());
        }
        order.setStatus(Status.SHIPPED);
        return true;
    }

    @Override
    public Boolean cancelShipping(int orderID) {
        return null;
    }

    @Override
    public Boolean cancelPlacement(int orderID) {
        return null;
    }

    @Override
    public Order getOrder(int orderID) {
        return database.getOrder(orderID);
    }
}

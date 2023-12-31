package com.orders.demo.services.Order;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Customer;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.SimpleOrder;
import com.orders.demo.models.Order.Status;
import com.orders.demo.models.Order.OrderRequest.OrderRequest;
import com.orders.demo.services.Customer.ICustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Order> getOrders() {
        return database.getOrders();
    }

    @Override
    public boolean createOrder(OrderRequest orderRequest) {
        Order order = orderRequest.createOrder(database.getOrders().size());
        if (order == null)
            return false;

        database.addOrder(order);
        return true;
    }

    @Override
    public Boolean placeOrder(int orderID) {
        return false;
        // Order order = database.getOrder(orderID);
        // Customer customer = customerService.getCustomer(order.getCustomerUsername());
        // List<SimpleOrder> orders = order.getCompositeOrders();
        // for (Order o : orders) {
        // if (o.getDetails())
        // }

        // order.setStatus(Status.PLACED);

    }

    @Override
    public Boolean cancelPlacement(int orderID) {
        return null;
    }

    @Override
    public Boolean shipOrder(int orderID) {
        return null;
    }

    @Override
    public Boolean cancelShipping(int orderID) {
        return null;
    }

    @Override
    public Order getOrder(int orderID) {
        return null;
    }
}

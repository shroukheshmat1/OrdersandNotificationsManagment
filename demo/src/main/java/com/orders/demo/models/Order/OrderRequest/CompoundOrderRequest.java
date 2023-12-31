package com.orders.demo.models.Order.OrderRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.orders.demo.DB.DB;
import com.orders.demo.DB.IDB;
import com.orders.demo.models.Product;
import com.orders.demo.models.Order.CompoundOrder;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.OrderDetails;
import com.orders.demo.models.Order.OrderItem;
import com.orders.demo.models.Order.SimpleOrder;

public class CompoundOrderRequest extends OrderRequest {
    private List<Integer> orderIds;

    public CompoundOrderRequest(String name, String location, List<OrderItem> items, List<Integer> orderIds) {
        super(name, location, items);
        this.orderIds = orderIds;
    }

    @Override
    public Order createOrder(int orderID) {
        double totalPrice = 0;
        IDB db = new DB();
        for (OrderItem item : items) {
            Product p = db.getProduct(item.getSerialNo());
            if (p == null)
                return null;

            totalPrice += p.getPrice() * item.getQuantity();
        }

        OrderDetails details = new OrderDetails(totalPrice, location, new Date());
        Order mainOrder = new SimpleOrder(orderID, name, details, items);

        if (orderIds == null)
            return null;

        List<Order> orders = new ArrayList<>();
        orders.add(mainOrder);
        for (Integer subOrderID : orderIds) {
            Order o = db.getOrder(subOrderID);
            if (o == null)
                return null;
            if (o.getStatus() != mainOrder.getStatus())
                return null;
            orders.add(o);
        }

        double compoudPrice = 0;
        for (Order o : orders)
            compoudPrice += o.getDetails().getTotalPrice();

        OrderDetails compoundDetails = new OrderDetails(compoudPrice, details.getOrderLocation(),
                details.getPlacementDate());
        return new CompoundOrder(orderID, name, compoundDetails, orders);
    }
}

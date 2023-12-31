package com.orders.demo.models.Order;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order {
    private List<OrderItem> items;

    public SimpleOrder(int orderID, String customerUsername, OrderDetails orderDetails, List<OrderItem> items) {
        super(orderID, customerUsername, orderDetails);
        this.items = items;
    }

    public List<OrderItem> getOrderItems() {
        return items;
    }

    @Override
    public List<Order> getCompositeOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(this);
        return orders;
    };
}

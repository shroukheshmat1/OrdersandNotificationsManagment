package com.orders.demo.models.Order;

import java.util.List;

public class CompoundOrder extends Order{
    private List<Order> compositeOrders;

    public CompoundOrder(int orderID, String customerUsername, List<Order> orders) {
        super(orderID, customerUsername);
        compositeOrders = orders;
    }

    public List<Order> getCompositeOrders() {
        return compositeOrders;
    }
}

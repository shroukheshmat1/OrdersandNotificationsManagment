package com.orders.demo.models.Order;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SimpleOrder extends Order {
    private List<OrderItem> items;

    public SimpleOrder(int orderID, String customerUsername, OrderDetails orderDetails, List<OrderItem> items) {
        super(orderID, customerUsername, orderDetails);
        this.items = items;
    }

    public List<OrderItem> getOrderItems() {
        return items;
    }

    @JsonIgnore
    @Override
    public List<Order> getCompositeOrders() {
        Order tempOrder = this;
        return new ArrayList<>() {
            {
                add(tempOrder);
            }
        };
    }
}

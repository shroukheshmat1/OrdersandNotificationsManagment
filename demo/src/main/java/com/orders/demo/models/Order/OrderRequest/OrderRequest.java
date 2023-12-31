package com.orders.demo.models.Order.OrderRequest;

import java.util.List;

import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.OrderItem;

public abstract class OrderRequest {
    protected String name;
    protected String location;
    protected List<OrderItem> items;

    public OrderRequest(String name, String location, List<OrderItem> items) {
        this.name = name;
        this.location = location;
        this.items = items;
    }

    public abstract Order createOrder(int orderID);

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}

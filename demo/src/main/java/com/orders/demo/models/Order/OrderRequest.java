package com.orders.demo.models.Order;

public interface OrderRequest {
    public Order createOrder(int orderID, String customerUsername);
}

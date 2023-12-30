package com.orders.demo.models.Response;

public class OrderResponse extends Response {
    private int orderID;

    public OrderResponse(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }
}

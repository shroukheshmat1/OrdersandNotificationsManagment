package com.orders.demo.dto.Response;

public class OrderResponse extends Response {
    private int orderID;

    public OrderResponse(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }
}

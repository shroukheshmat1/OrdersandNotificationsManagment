package com.orders.demo.models.Response;

public class OrderResponse extends Response {
    private int orderID;

    public OrderResponse(boolean status) {
        super(status);
    }

    public OrderResponse(boolean status, String message) {
        super(status, message);
    }

    public OrderResponse(boolean status, String message, int orderID) {
        super(status, message);
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }
}

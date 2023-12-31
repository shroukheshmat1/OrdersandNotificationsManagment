package com.orders.demo.models.Order;

public class OrderItem {
    private String serialNo;
    private int quantity;

    public OrderItem(String serialNo, int quantity) {
        this.serialNo = serialNo;
        this.quantity = quantity;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public int getQuantity() {
        return quantity;
    }
}

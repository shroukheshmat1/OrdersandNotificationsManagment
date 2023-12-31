package com.orders.demo.models.Order;

public class OrderItem {
    private String name;
    private String serialNo;
    private int quantity;

    public OrderItem(String name, String serialNo, int quantity) {
        this.name = name;
        this.serialNo = serialNo;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public int getQuantity() {
        return quantity;
    }
}

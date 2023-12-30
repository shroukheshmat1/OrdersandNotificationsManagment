package com.orders.demo.models.Order;

import static com.orders.demo.models.Order.Status.PENDING;

public abstract class Order {
    private int orderID;
    private String customerUsername;
    private Status status;

    public Order(int orderID, String customerUsername) {
        this.orderID = orderID;
        this.customerUsername = customerUsername;
        this.status = PENDING;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }
}

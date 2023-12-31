package com.orders.demo.models.Order;

import static com.orders.demo.models.Order.Status.PENDING;

import java.util.List;

public abstract class Order {
    protected int orderID;
    protected String customerUsername;
    protected Status status;
    protected OrderDetails orderDetails;

    public Order(int orderID, String customerUsername, OrderDetails orderDetails) {
        this.orderID = orderID;
        this.customerUsername = customerUsername;
        this.orderDetails = orderDetails;
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

    public OrderDetails getDetails() {
        return orderDetails;
    }

    public abstract List<Order> getCompositeOrders();
};

package com.orders.demo.models.Order;

public class SimpleOrder extends Order{
    private OrderDetails orderDetails;


    public SimpleOrder(int orderID, String customerUsername, OrderDetails orderDetails) {
        super(orderID, customerUsername);
        this.orderDetails = orderDetails;
    }
    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}

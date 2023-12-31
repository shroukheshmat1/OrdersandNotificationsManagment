package com.orders.demo.models.Order;

import java.util.Date;

public class OrderDetails {
    private double totalPrice;
    private String orderLocation;
    private Date placementDate;

    public OrderDetails(double totalPrice, String orderLocation, Date placementDate) {
        this.totalPrice = totalPrice;
        this.orderLocation = orderLocation;
        this.placementDate = placementDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public Date getPlacementDate() {
        return placementDate;
    }
}

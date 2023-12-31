package com.orders.demo.models.Order;

import java.util.Date;

public class OrderDetails {
    private double totalPrice;
    private double deliveryFee;
    private String orderLocation;
    private Date placementDate;

    public OrderDetails(double totalPrice, double deliveryFee, String orderLocation, Date placementDate) {
        this.totalPrice = totalPrice;
        this.deliveryFee = deliveryFee;
        this.orderLocation = orderLocation;
        this.placementDate = placementDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public Date getPlacementDate() {
        return placementDate;
    }
}

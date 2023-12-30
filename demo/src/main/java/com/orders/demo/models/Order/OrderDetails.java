package com.orders.demo.models.Order;

import com.orders.demo.models.Product;

import java.util.Date;
import java.util.List;

public class OrderDetails {
    private List<Product> products;
    private double totalPrice;
    private String orderLocation;
    private Date placementDate;

    public OrderDetails(List<Product> products, double totalPrice, String orderLocation, Date placementDate) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.orderLocation = orderLocation;
        this.placementDate = placementDate;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }
}

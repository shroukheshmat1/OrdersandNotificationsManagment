package com.orders.demo.models;

public class Product {
    private String serialNumber;
    private String name;
    private String vendor;
    private String categoryName;
    private double price;
    private int stock;


    public Product(String serialNumber, String name, String vendor, String categoryName, double price, int stock) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.vendor = vendor;
        this.categoryName = categoryName;
        this.price = price;
        this.stock = stock;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

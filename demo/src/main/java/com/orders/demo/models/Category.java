package com.orders.demo.models;

import java.util.List;

public class Category {
    List<Product> products;
    String CategoryName;

    public Category(String categoryName, List<Product> products) {
        this.products = products;
        CategoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getCategoryName() {
        return CategoryName;
    }
}

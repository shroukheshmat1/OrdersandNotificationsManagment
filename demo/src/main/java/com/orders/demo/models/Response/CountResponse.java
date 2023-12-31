package com.orders.demo.models.Response;

import com.orders.demo.models.Product;
import java.util.List;


public class CountResponse extends Response {

    private int productCount;
    private List<Product> products;


    public CountResponse(boolean status, String message, List<Product> products, int productCount) {
        super(status, message);
        this.products = products;
        this.productCount = productCount;
    }
    public List<Product> getProducts() {
        return products;
    }

    public int getProductCount() {
        return productCount;
    }

}
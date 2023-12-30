package com.orders.demo.models.Response;

public class CountResponse extends Response {

    private int productCount;

    public CountResponse(int productCount) {
        this.productCount = productCount;
    }

    public int getProductCount() {
        return productCount;
    }

}
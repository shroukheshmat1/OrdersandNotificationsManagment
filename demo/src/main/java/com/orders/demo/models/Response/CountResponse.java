package com.orders.demo.models.Response;

public class CountResponse extends Response {

    private int productCount;

    public CountResponse(boolean status) {
        super(status);
    }

    public CountResponse(boolean status, String message) {
        super(status, message);
    }

    public int getProductCount() {
        return productCount;
    }

}
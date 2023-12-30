package com.orders.demo.models.Response;

public class LoginResponse extends Response {

    private String customerUsername;

    public LoginResponse(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

}

package com.orders.demo.models.Response;

public class LoginResponse extends Response {

    private String customerUsername;

    public LoginResponse(boolean status) {
        super(status);
    }

    public LoginResponse(boolean status, String message) {
        super(status, message);
    }

    public LoginResponse(boolean status, String message, String customerUsername) {
        super(status, message);
        this.customerUsername = customerUsername;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

}

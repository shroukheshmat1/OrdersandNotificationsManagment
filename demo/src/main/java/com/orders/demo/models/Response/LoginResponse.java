package com.orders.demo.models.Response;

public class LoginResponse extends Response {

    private int customerID;

    public LoginResponse(boolean status) {
        super(status);
    }

    public LoginResponse(boolean status, String message) {
        super(status, message);
    }

    public LoginResponse(boolean status, String message, int customerID) {
        super(status, message);
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

}

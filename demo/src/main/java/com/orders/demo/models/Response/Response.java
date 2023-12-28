package com.orders.demo.models.Response;

public class Response {
    private boolean status;
    private String message;

    public Response(boolean status) {
        this.status = status;
    }

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

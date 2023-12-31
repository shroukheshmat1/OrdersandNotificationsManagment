package com.orders.demo.dto.Response;

public class Response {
    private boolean status;
    private String message;

    public Response() {
        this.status = true;
    }

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

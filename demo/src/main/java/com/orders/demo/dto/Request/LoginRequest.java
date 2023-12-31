package com.orders.demo.dto.Request;

public class LoginRequest {
    String name;
    String password;

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

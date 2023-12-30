package com.orders.demo.models;

public class Customer {
    private String name;
    private double balance;
    private String email;
    private String password;

    public Customer(String name, String password, String email, double balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;

    }
}

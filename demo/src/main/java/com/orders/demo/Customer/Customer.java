package com.orders.demo.Customer;

public class Customer {
    private String name;
    private double balance;
    private int customerId;
    private String Email;
    private String password;

    public Customer(String name, String password, String email, double balance) {
        this.name=name;
        this.Email=email;
        this.password=password;
        this.balance=balance;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return password;

    }
}

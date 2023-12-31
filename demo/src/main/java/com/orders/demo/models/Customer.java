package com.orders.demo.models;

import com.orders.demo.models.Template.Language;

public class Customer {
    private String name;
    private double balance;
    private String email;
    private String phoneNumber;

    private String password;
    private Language preferredLanguge;

    public Customer(String name, String email, String phoneNumber, String password, double balance,
            Language preferredLanguage) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.balance = balance;
        this.preferredLanguge = preferredLanguage;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;

    }

    public Language getPreferredLanguage() {
        return preferredLanguge;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

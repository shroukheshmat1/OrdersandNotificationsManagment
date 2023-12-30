package com.orders.demo.services.Customer;

import com.orders.demo.models.Customer;

public interface ICustomerService {
    Customer login(String email, String password);
    // boolean signup(String email, String password, double balance);

    boolean signup(String name, String email, String password, double balance);
}
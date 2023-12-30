package com.orders.demo.Customer;

public interface ICustomerService {
    Customer login(String email, String password);
//    boolean signup(String email, String password, double balance);

    boolean signup(String name, String email, String password, double balance);
}
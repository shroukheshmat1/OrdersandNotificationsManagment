package com.orders.demo.services.Customer;

import java.util.List;

import com.orders.demo.models.Customer;
import com.orders.demo.models.Order.Order;

public interface ICustomerService {
    Customer login(String email, String password);
    // boolean signup(String email, String password, double balance);

    boolean signup(String name, String email, String password, double balance);

    Customer getCustomer(String name);

    List<Order> getCustomerOrders(String name);

}
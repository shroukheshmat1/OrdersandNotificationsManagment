package com.orders.demo.DB;

import org.springframework.stereotype.Component;

import com.orders.demo.models.Customer;

import java.util.List;

@Component
public interface IDB {
    List<Customer> getCustomers();

    void addCustomer(Customer customer);
}

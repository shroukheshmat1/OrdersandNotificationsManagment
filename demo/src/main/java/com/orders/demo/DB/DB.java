package com.orders.demo.DB;

import org.springframework.stereotype.Service;

import com.orders.demo.models.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class DB implements IDB {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}

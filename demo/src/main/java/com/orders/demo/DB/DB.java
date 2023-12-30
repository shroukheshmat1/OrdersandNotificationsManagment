package com.orders.demo.DB;

import com.orders.demo.Customer.Customer; // Import the Customer class
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DB implements IDB {
    private List<Customer> customers;

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}

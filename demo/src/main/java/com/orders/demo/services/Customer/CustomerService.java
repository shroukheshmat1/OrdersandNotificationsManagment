package com.orders.demo.services.Customer;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final IDB db;

    public CustomerService(IDB db) {
        this.db = db;
    }

    @Override
    public Customer login(String email, String password) {
        // Implement logic to check if the user exists in the database
        return db.getCustomers().stream()
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean signup(String name, String email, String password, double balance) {
        // Implement logic to check if the user already exists
        if (db.getCustomers().stream().anyMatch(c -> c.getName().equals(name))) {
            return false; // User already exists
        }

        Customer newCustomer = new Customer(name, email, password, balance);
        db.addCustomer(newCustomer);
        return true;
    }
}

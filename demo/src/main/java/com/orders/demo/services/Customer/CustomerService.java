package com.orders.demo.services.Customer;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Customer;
import com.orders.demo.models.Order.Order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final IDB database;

    public CustomerService(IDB database) {
        this.database = database;
    }

    @Override
    public Customer login(String email, String password) {
        // Implement logic to check if the user exists in the database
        return database.getCustomers().stream()
                .filter(c -> c.getEmail().equals(email) && c.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean signup(String name, String email, String password, double balance) {
        // Implement logic to check if the user already exists
        if (database.getCustomers().stream().anyMatch(c -> c.getName().equals(name))) {
            return false; // User already exists
        }

        Customer newCustomer = new Customer(name, email, password, balance);
        database.addCustomer(newCustomer);
        return true;
    }

    @Override
    public List<Order> getCustomerOrders(String name) {
        List<Order> orders = new ArrayList<>();
        for (Order order : database.getOrders()) {
            if (order.getCustomerUsername().equals(name))
                orders.add(order);
        }
        return orders;
    }

    @Override
    public Customer getCustomer(String name) {
        return database.getCustomer(name);
    }
}

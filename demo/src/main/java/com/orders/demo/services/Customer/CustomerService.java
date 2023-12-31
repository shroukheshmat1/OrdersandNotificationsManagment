package com.orders.demo.services.Customer;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Customer;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Template.Language;

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
    public Customer login(String name, String password) {
        // Implement logic to check if the user exists in the database
        return database.getCustomers().stream()
                .filter(c -> c.getName().equals(name) && c.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean signup(Customer customer) {
        // Implement logic to check if the user already exists
        if (database.getCustomers().stream().anyMatch(c -> c.getName().equals(customer.getName()))) {
            return false; // User already exists
        }
        database.addCustomer(customer);
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

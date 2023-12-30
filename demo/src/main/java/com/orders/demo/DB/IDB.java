package com.orders.demo.DB;
import com.orders.demo.Customer.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IDB {
    List<Customer> getCustomers();
    void addCustomer(Customer customer);
}

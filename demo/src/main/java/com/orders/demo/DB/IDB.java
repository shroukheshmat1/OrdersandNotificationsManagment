package com.orders.demo.DB;

import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import org.springframework.stereotype.Component;

import com.orders.demo.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDB {
    List<Customer> getCustomers();

    Category getCategory(String categoryName);
    List<Category> getCategories();
    List<Product> getProducts();

    List<Product> getCategoryProducts(String categoryName);
    Product getProduct(String productSerialNo);


    void addCustomer(Customer customer);
}

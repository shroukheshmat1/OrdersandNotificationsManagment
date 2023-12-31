package com.orders.demo.DB;

import java.util.List;
import java.util.Queue;

import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Customer;

public interface IDB {
    List<Customer> getCustomers();

    Category getCategory(String categoryName);

    List<Category> getCategories();

    List<Product> getProducts();

    List<Product> getCategoryProducts(String categoryName);

    Product getProduct(String productSerialNo);

    void addCustomer(Customer customer);

    Queue<Notifcation> getNotifications();

    void addNotifcation(Notifcation notifcation);
}

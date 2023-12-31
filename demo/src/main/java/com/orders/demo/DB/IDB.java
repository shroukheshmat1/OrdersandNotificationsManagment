package com.orders.demo.DB;

import java.util.Date;
import java.util.List;
import java.util.Queue;

import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Customer;

public interface IDB {
    Customer getCustomer(String name);

    List<Customer> getCustomers();

    Category getCategory(String categoryName);

    List<Category> getCategories();

    List<Product> getProducts();

    List<Product> getCategoryProducts(String categoryName);

    Product getProduct(String productSerialNo);

    void addCustomer(Customer customer);

    Queue<Notifcation> getNotifications();

    void addNotifcation(Notifcation notifcation);

    Order getOrder(int orderID);

    List<Order> getOrders();

    void addOrder(Order order);

    double getDeliveryFee();

    Integer maxCancellationPeriod();

    Date getPlacementTime(int orderId);

    Date getShippingTime(int orderId);

    void addPlacementTime(int orderId, Date date);

    void addShippingTime(int orderId, Date date);

}

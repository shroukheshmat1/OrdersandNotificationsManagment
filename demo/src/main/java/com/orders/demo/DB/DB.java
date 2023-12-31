package com.orders.demo.DB;

import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import com.orders.demo.models.Notification.Notifcation;

import org.springframework.stereotype.Service;

import com.orders.demo.models.Customer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

@Service
public class DB implements IDB {
    private static List<Customer> customers = new ArrayList<>();
    private static List<Category> category = new ArrayList<>() {
        {
            add(
                    new Category("Electronics", new ArrayList<>() {
                        {
                            add(new Product("SN001", "Laptop", "Dell", "Electronics", 1000.0, 30));
                        }
                        {
                            add(new Product("SN002", "Smart Phone", "Apple", "Electronics", 500.0, 50));
                        }
                        {
                            add(new Product("SN003", "Camera", "Canon", "Electronics", 750.0, 20));
                        }
                    }));
            add(
                    new Category("Sports and Outdoors", new ArrayList<>() {
                        {
                            add(new Product("SN004", "Running Shoes", "Nike", "Sports and Outdoors", 250.0, 30));
                        }
                        {
                            add(new Product("SN005", "Backpack", "The North Face", "Sports and Outdoors", 160.0, 35));
                        }
                    }));
            add(
                    new Category("Fashion", new ArrayList<>() {
                        {
                            add(new Product("SN006", "T-Shirt", "Adidas", "Fashion", 75.0, 100));
                        }
                        {
                            add(new Product("SN007", "Jeans", "Levi's", "Fashion", 120.0, 80));
                        }
                        {
                            add(new Product("SN008", "Dress", "H&M", "Fashion", 180.0, 65));
                        }
                    }));
            add(
                    new Category("Home and Kitchen", new ArrayList<>() {
                        {
                            add(new Product("SN009", "Coffee Maker", "Keurig", "Home and Kitchen", 129.99, 30));
                        }
                        {
                            add(new Product("SN010", "Throw Pillow", "IKEA", "Home and Kitchen", 19.99, 50));
                        }
                    }));
        }
    };

    private static Queue<Notifcation> notificationQueue = new ArrayDeque<>();

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Category getCategory(String categoryName) {
        for (Category category1 : category) {
            if (Objects.equals(category1.getCategoryName(), categoryName)) {
                return category1;
            }
        }
        return null;
    }

    @Override
    public List<Category> getCategories() {
        return category;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (Category category1 : category) {
            products.addAll(category1.getProducts());
        }
        return products;
    }

    @Override
    public List<Product> getCategoryProducts(String categoryName) {
        List<Product> products = new ArrayList<>();
        for (Category category1 : category) {
            if (Objects.equals(category1.getCategoryName(), categoryName)) {
                products.addAll(category1.getProducts());
            }
        }
        return products;
    }

    @Override
    public Product getProduct(String productSerialNo) {
        for (Category category1 : category) {
            for (Product product : category1.getProducts()) {
                if (Objects.equals(product.getSerialNumber(), productSerialNo)) {
                    return product;
                }
            }
        }
        return null;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Queue<Notifcation> getNotifications() {
        return notificationQueue;
    }

    @Override
    public void addNotifcation(Notifcation notifcation) {
        notificationQueue.add(notifcation);
    }
}

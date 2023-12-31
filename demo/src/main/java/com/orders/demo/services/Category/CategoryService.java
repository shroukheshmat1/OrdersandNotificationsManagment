package com.orders.demo.services.Category;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private final IDB database;

    public CategoryService(IDB database) {
        this.database = database;
    }

    @Override
    public List<Category> getCategories() {
        return database.getCategories();
    }

    @Override
    public List<Product> getAllProducts() {
        return database.getProducts();
    }

    @Override
    public List<Product> getCategoryProducts(String categoryName) {
        return database.getCategoryProducts(categoryName);
    }

    @Override
    public int getProductCount(String categoryName) {
        int counter = 0;
        Category category = database.getCategory(categoryName);
        List<Product> products = category.getProducts();
        for (Product product : products) {
            counter += product.getStock();
        }
        return counter;
    }
}

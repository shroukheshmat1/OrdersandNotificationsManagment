package com.orders.demo.services.Category;

import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import java.util.List;

public interface ICategoryService {
    List<Category> getCategories();
    List<Product> getAllProducts();
    List<Product> getCategoryProducts(String categoryName);

    int getProductCount(String categoryName);

}

package com.orders.demo.controllers;

import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import com.orders.demo.models.Response.CountResponse;
import com.orders.demo.models.Response.Response;
import com.orders.demo.services.Category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/products")
    List<Product> getProducts() {
        return categoryService.getAllProducts();
    }

    @GetMapping("/categories/{categoryName}")
    Response getProductCount(@PathVariable String categoryName) {
        List<Product> products = categoryService.getCategoryProducts(categoryName);
        int count = categoryService.getProductCount(categoryName);
        return new CountResponse(products, count);
    }
}

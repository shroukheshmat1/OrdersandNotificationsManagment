package com.orders.demo.controllers;

import com.orders.demo.dto.Response.CountResponse;
import com.orders.demo.dto.Response.Response;
import com.orders.demo.models.Category;
import com.orders.demo.models.Product;
import com.orders.demo.services.Category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/products")
    List<Product> getProducts() {
        return categoryService.getAllProducts();
    }

    @GetMapping("/{categoryName}")
    Response getProductCount(@PathVariable String categoryName) {
        List<Product> products = categoryService.getCategoryProducts(categoryName);
        if (products.isEmpty()){
            return new Response(false, "There is no category with the name: " + categoryName);
        }
        int count = categoryService.getProductCount(categoryName);
        return new CountResponse(true, "Category is found.", products, count);
    }
}

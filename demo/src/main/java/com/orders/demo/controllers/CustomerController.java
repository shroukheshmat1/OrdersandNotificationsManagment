package com.orders.demo.controllers;

import com.orders.demo.dto.Request.LoginRequest;
import com.orders.demo.dto.Response.LoginResponse;
import com.orders.demo.dto.Response.Response;
import com.orders.demo.models.Customer;
import com.orders.demo.models.Order.Order;
import com.orders.demo.dto.Response.LoginResponse;
import com.orders.demo.dto.Response.Response;
import com.orders.demo.services.Customer.ICustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/check")
    public Response checkUser(@RequestBody LoginRequest request) {
        // Perform login
        String name = customerService.login(request.getName(), request.getPassword()).getName();
        if (!name.isEmpty())
            return new LoginResponse(name);
        return new Response(false, "Invalid credentials");
    }

    @PostMapping("/signup")
    public Response signup(@RequestBody Customer customer) {
        // Perform signup
        boolean success = customerService.signup(customer);
        if (success)
            return new Response(true, "Signup successful");
        return new Response(false, "Something Went Wrong");
    }

    @PostMapping("/changeLanguage/{name}/{language}")
    public Response changeLanguge(@PathVariable String name, @PathVariable String language) {
        if (customerService.changeLanguge(name, language))
            return new Response(true, "Language Changed");
        return new Response(false, "Check Customer Name");
    }

    @GetMapping("/{name}/orders")
    public List<Order> getOrders(@PathVariable String name) {
        return customerService.getCustomerOrders(name);
    }

    @GetMapping("/{name}")
    public Customer getCustomer(@PathVariable String name) {
        return customerService.getCustomer(name);
    }
}

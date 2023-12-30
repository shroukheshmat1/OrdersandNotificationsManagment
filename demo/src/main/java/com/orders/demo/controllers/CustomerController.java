package com.orders.demo.controllers;

import com.orders.demo.models.Customer;
import com.orders.demo.models.Response.LoginResponse;
import com.orders.demo.models.Response.Response;
import com.orders.demo.services.Customer.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/check")
    public Response checkUser(@RequestParam String email, @RequestParam String password) {
        // Perform login
        String name = customerService.login(email, password).getName();
        if (!name.isEmpty()) {
            return new LoginResponse(name);
        }
        return new Response(false, "Invalid credentials");
    }

    @PostMapping("/signup")
    public Response signup(@RequestBody Customer customer) {
        // Perform signup
        boolean success = customerService.signup(customer.getName(),
                customer.getEmail(), customer.getPassword(), customer.getBalance());
        if (success) {
            return new Response(true, "Signup successful");
        }
        return new Response(false, "User already exists");
    }
}

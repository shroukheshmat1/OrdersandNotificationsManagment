package com.orders.demo.controllers;

import com.orders.demo.dto.Request.LoginRequest;
import com.orders.demo.dto.Response.LoginResponse;
import com.orders.demo.dto.Response.Response;
import com.orders.demo.models.Customer;
import com.orders.demo.services.Customer.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/check")
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
        boolean success = customerService.signup(customer.getName(),
                customer.getEmail(), customer.getPassword(), customer.getBalance());
        if (success)
            return new Response(true, "Signup successful");
        return new Response(false, "User already exists");
    }
}

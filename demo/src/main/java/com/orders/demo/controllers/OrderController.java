package com.orders.demo.controllers;

import com.orders.demo.models.Order.OrderItem;
import com.orders.demo.models.Order.SimpleOrderRequest;
import com.orders.demo.models.Response.Response;
import com.orders.demo.services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/simple")
    Response createOrder(@PathVariable String customerName, @PathVariable List<OrderItem> orderItems, @PathVariable String Location){
//        Boolean result = orderService.createOrder(customerName, orderItems, Location);

        return null;
    }
}

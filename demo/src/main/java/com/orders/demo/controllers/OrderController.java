package com.orders.demo.controllers;

import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.OrderRequest.CompoundOrderRequest;
import com.orders.demo.models.Order.OrderRequest.SimpleOrderRequest;
import com.orders.demo.models.Response.Response;
import com.orders.demo.services.Order.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/simple")
    Response createOrder(@RequestBody SimpleOrderRequest orderRequest) {
        if (!orderService.createOrder(orderRequest))
            return new Response(false, "Failed To Create Order");
        return new Response();
    }

    @PostMapping("/compound")
    Response createOrder(@RequestBody CompoundOrderRequest orderRequest) {
        if (!orderService.createOrder(orderRequest))
            return new Response(false, "Failed To Create Order");
        return new Response();
    }

    @PostMapping("/place/{id}")
    Response placeOrder(@PathVariable int id) {
        if (!orderService.placeOrder(id))
            return new Response(false, "Failed To Place Order");
        return new Response();
    }

    @PostMapping("/ship/{id}")
    Response shipOrder(@PathVariable int id) {
        if (!orderService.shipOrder(id))
            return new Response(false, "Failed To Ship Order");
        return new Response();
    }

    @PostMapping("/cancelShipping/{id}")
    Response cancelShipping(@PathVariable int id) {
        if (!orderService.cancelShipping(id))
            return new Response(false, "Failed To Ship Order");
        return new Response();
    }

    @PostMapping("/cancelPlacement/{id}")
    Response cancelPlacement(@PathVariable int id) {
        if (!orderService.cancelPlacement(id))
            return new Response(false, "Failed To Ship Order");
        return new Response();
    }
}

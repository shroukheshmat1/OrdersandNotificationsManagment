package com.orders.demo.services.Order;

import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.SimpleOrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{

    @Override
    public Order createOrder(String OrderRequest) {
        if (OrderRequest == "SimpleOrder"){
            return new SimpleOrderRequest();
        }
        return null;
    }

    @Override
    public Boolean placeOrder(int orderID) {
        return null;
    }

    @Override
    public Boolean cancelPlacement(int orderID) {
        return null;
    }

    @Override
    public Boolean shipOrder(int orderID) {
        return null;
    }

    @Override
    public Boolean cancelShipping(int orderID) {
        return null;
    }

    @Override
    public Order getOrder(int orderID) {
        return null;
    }
}

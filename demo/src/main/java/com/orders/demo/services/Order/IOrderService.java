package com.orders.demo.services.Order;

import java.util.List;

import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.OrderRequest.OrderRequest;

public interface IOrderService {
    public boolean createOrder(OrderRequest orderRequest);

    Boolean placeOrder(int orderID);

    Boolean cancelPlacement(int orderID);

    Boolean shipOrder(int orderID);

    Boolean cancelShipping(int orderID);

    Order getOrder(int orderID);
}

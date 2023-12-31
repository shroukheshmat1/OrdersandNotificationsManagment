package com.orders.demo.services.Order;

import com.orders.demo.models.Order.Order;

public interface IOrderService {
    Boolean createOrder();
    Boolean placeOrder(int orderID);
    Boolean cancelPlacement(int orderID);
    Boolean shipOrder(int orderID);
    Boolean cancelShipping(int orderID);
    Order getOrder(int orderID);
}

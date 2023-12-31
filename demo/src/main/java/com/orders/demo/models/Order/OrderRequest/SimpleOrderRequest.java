package com.orders.demo.models.Order.OrderRequest;

import java.util.Date;
import java.util.List;

import com.orders.demo.DB.DB;
import com.orders.demo.DB.IDB;
import com.orders.demo.models.Product;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.OrderDetails;
import com.orders.demo.models.Order.OrderItem;
import com.orders.demo.models.Order.SimpleOrder;

public class SimpleOrderRequest extends OrderRequest {
    public SimpleOrderRequest(String name, String location, List<OrderItem> items) {
        super(name, location, items);
    }

    @Override
    public Order createOrder(int orderID) {
        double totalPrice = 0;
        IDB database = new DB();
        for (OrderItem item : items) {
            Product p = database.getProduct(item.getSerialNo());
            if (p == null)
                return null;

            totalPrice += p.getPrice() * item.getQuantity();
        }
        OrderDetails details = new OrderDetails(totalPrice, database.getDeliveryFee(), location, new Date());
        return new SimpleOrder(orderID, name, details, items);
    }
}

package com.orders.demo.models.Order;

import java.util.List;

public class CompoundOrder extends Order {
    private List<Order> compositeOrders;

    public CompoundOrder(int orderID, String customerUsername, OrderDetails orderDetails, List<Order> orders) {
        super(orderID, customerUsername, orderDetails);
        compositeOrders = orders;
    }

    @Override
    public void setStatus(Status status) {
        super.setStatus(status);
        for (Order order : compositeOrders)
            order.setStatus(status);
    }

    public List<Order> getCompositeOrders() {
        return compositeOrders;
    }
}

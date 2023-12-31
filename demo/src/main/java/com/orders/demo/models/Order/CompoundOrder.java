package com.orders.demo.models.Order;

import java.util.ArrayList;
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

    @Override
    public List<Integer> getCompositeOrdersIds() {
        List<Integer> orderIds = new ArrayList<>();
        for (Order o : compositeOrders) {
            orderIds.add(o.getOrderID());
        }
        return orderIds;
    }
}

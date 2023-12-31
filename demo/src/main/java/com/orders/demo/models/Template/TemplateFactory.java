package com.orders.demo.models.Template;

import org.springframework.beans.factory.annotation.Autowired;

import com.orders.demo.DB.DB;
import com.orders.demo.DB.IDB;
import com.orders.demo.models.Order.Order;
import com.orders.demo.models.Order.Status;

// SIMPLE FACTORY PATTERN
public class TemplateFactory {
    public static Template createTemplate(int orderID) {
        IDB database = new DB();
        Order o = database.getOrder(orderID);
        String name = database.getCustomer(o.getCustomerUsername()).getName();
        Language preferredLanguage = database.getCustomer(o.getCustomerUsername()).getPreferredLanguage();

        if (o.getStatus() == Status.PLACED) {
            return new PlacementTemplate(preferredLanguage, name, o.getDetails().getTotalPrice());
        } else {
            String location = o.getDetails().getOrderLocation();
            return new ShippingTemplate(preferredLanguage, name, o.getDetails().getDeliveryFee(), location);
        }
    }
}

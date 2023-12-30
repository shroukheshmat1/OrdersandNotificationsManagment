package com.orders.demo.models.Template;

// SIMPLE FACTORY PATTERN
public class TemplateFactory {
    public static Template createTemplate(int orderID) {
        // data from orders

        return new ShippingTemplate(Language.FRENCH, "Youssef", 20.0, "Maadi");
    }
}

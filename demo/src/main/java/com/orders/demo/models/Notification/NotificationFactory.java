package com.orders.demo.models.Notification;

import com.orders.demo.models.Customer;
import com.orders.demo.models.Template.Template;

// SIMPLE FACTORY PATTERN
public class NotificationFactory {
    public static Notifcation createNotifcation(NotificationType type, Customer customer, Template template) {
        if (type == NotificationType.EMAIL)
            return new EmailNotification(template, customer.getEmail(), "Order Shipment");
        else if (type == NotificationType.SMS)
            return new SMSNotification(template, customer.getPhoneNumber());
        else
            return null;
    }
}

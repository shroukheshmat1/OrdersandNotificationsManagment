package com.orders.demo.models.Notification;

import com.orders.demo.models.Template.Template;

// SIMPLE FACTORY PATTERN
public class NotificationFactory {
    public static Notifcation createNotifcation(NotificationType type, Template template) {
        if (type == NotificationType.EMAIL)
            return new EmailNotification(template, "usf", "Order Shipment");
        else if (type == NotificationType.SMS)
            return new SMSNotification(template, "010");
        else
            return null;
    }
}

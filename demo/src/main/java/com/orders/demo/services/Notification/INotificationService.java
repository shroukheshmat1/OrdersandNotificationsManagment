package com.orders.demo.services.Notification;

import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Service;

import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationType;

public interface INotificationService {
    boolean createNotification(int OrderID, NotificationType type);

    Queue<Notifcation> getNotifications();
    boolean queueNotification(Notifcation notifcation);

    void scheduledSendingTask();

    Map<String, String> getStats();
}

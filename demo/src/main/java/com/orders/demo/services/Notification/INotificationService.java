package com.orders.demo.services.Notification;

import java.util.Queue;

import org.springframework.stereotype.Service;

import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationType;

@Service
public interface INotificationService {
    boolean createNotification(int OrderID, NotificationType type);

    Queue<Notifcation> getNotifications();

    void scheduledSendingTask();
}

package com.orders.demo.services.Notification;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationType;

@Service
public interface INotificationService {
    Notifcation createNotification(int OrderID, NotificationType type);

    List<Notifcation> getNotifications();

    boolean queueNotification(Notifcation notifcation);

    boolean scheduledSendingTask();
}

package com.orders.demo.services.Notification;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationFactory;
import com.orders.demo.models.Notification.NotificationType;
import com.orders.demo.models.Template.TemplateFactory;

@Service
public class NotifcationService implements INotificationService {

    @Autowired
    private final IDB database;

    public NotifcationService(IDB database) {
        this.database = database;
    }

    @Override
    public boolean createNotification(int OrderID, NotificationType type) {
        return queueNotification(NotificationFactory.createNotifcation(type, TemplateFactory.createTemplate(OrderID)));
    }

    @Override
    public Queue<Notifcation> getNotifications() {
        return database.getNotifications();
    }

    private boolean queueNotification(Notifcation notifcation) {
        database.addNotifcation(notifcation);
        return true;
    }

    @Override
    @Scheduled(fixedRate = 5000) // Run every 5 seconds
    public void scheduledSendingTask() {
        System.out.println("5 seconds passed => Scheduled task executed!");
        if (!database.getNotifications().isEmpty())
            database.getNotifications().remove().send();
    }

}
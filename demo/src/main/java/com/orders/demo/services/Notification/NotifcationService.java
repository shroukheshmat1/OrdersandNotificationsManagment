package com.orders.demo.services.Notification;

import java.util.List;

import org.springframework.stereotype.Service;

import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationFactory;
import com.orders.demo.models.Notification.NotificationType;
import com.orders.demo.models.Template.TemplateFactory;

@Service
public class NotifcationService implements INotificationService {

    @Override
    public Notifcation createNotification(int OrderID, NotificationType type) {
        return NotificationFactory.createNotifcation(type, TemplateFactory.createTemplate(OrderID));
    }

    @Override
    public List<Notifcation> getNotifications() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNotifications'");
    }

    @Override
    public boolean queueNotification(Notifcation notifcation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queueNotification'");
    }

    @Override
    public boolean scheduledSendingTask() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'scheduledSendingTask'");
    }

}
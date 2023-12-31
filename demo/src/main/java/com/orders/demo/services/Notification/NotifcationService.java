package com.orders.demo.services.Notification;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.orders.demo.DB.IDB;
import com.orders.demo.models.Customer;
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
        Customer customer = database.getCustomer(database.getOrder(OrderID).getCustomerUsername());
        Notifcation notification = NotificationFactory.createNotifcation(type, customer,
                TemplateFactory.createTemplate(OrderID));

        Map<String, Integer> templateCounter = database.getTemplateCounter();
        String templateString = notification.getTemplate().getUsedTemplate();
        templateCounter.putIfAbsent(templateString, 0);
        database.getTemplateCounter().put(templateString, templateCounter.get(templateString) + 1);

        Map<String, Integer> contactCounter = database.getContactCounter();
        String contact = notification.getContact();
        contactCounter.putIfAbsent(contact, 0);
        database.getContactCounter().put(contact, contactCounter.get(contact) + 1);
        return queueNotification(notification);
    }

    @Override
    public Queue<Notifcation> getNotifications() {
        return database.getNotifications();
    }

    @Override
    public Map<String, String> getStats() {
        Map.Entry<String, Integer> maxContact = null;
        for (Map.Entry<String, Integer> entry : database.getContactCounter().entrySet()) {
            if (maxContact == null)
                maxContact = entry;
            else if (entry.getValue() > maxContact.getValue())
                maxContact = entry;
        }

        Map.Entry<String, Integer> maxTemplate = null;
        for (Map.Entry<String, Integer> entry : database.getTemplateCounter().entrySet()) {
            if (maxTemplate == null)
                maxTemplate = entry;
            else if (entry.getValue() > maxTemplate.getValue())
                maxTemplate = entry;
        }
        if (maxContact == null || maxTemplate == null)
            return new HashMap<>();

        Map<String, String> result = new HashMap<>();
        result.put("topContact", maxContact.getKey());
        result.put("topTemplate", maxTemplate.getKey());
        return result;
    }

    @Override
    public boolean queueNotification(Notifcation notifcation) {
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
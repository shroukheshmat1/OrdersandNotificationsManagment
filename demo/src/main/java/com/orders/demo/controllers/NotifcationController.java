package com.orders.demo.controllers;

import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.services.Notification.INotificationService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/notifications")
public class NotifcationController {

    @Autowired
    private final INotificationService notificationService;

    NotifcationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public Queue<Notifcation> getNotifcations() {
        return notificationService.getNotifications();
    }

    @GetMapping("/stats")
    public Map<String, String> getNotifcationsStatistics() {
        return notificationService.getStats();
    }
}

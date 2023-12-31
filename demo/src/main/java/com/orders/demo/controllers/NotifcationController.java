package com.orders.demo.controllers;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationType;
import com.orders.demo.models.Response.Response;
import com.orders.demo.services.Notification.INotificationService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/notifcation")
public class NotifcationController {

    private final INotificationService notificationService;

    NotifcationController(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/get")
    public Queue<Notifcation> getNotifcations() {
        return notificationService.getNotifications();
    }

    @GetMapping("/add")
    public Response addNotifcation() {
        boolean status = notificationService.createNotification(0, NotificationType.EMAIL);
        if (status)
            return new Response(status, "Success");
        else
            return new Response(status, "Failed to create notifaction");
    }
}
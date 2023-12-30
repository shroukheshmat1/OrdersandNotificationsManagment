package com.orders.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.orders.demo.models.Notification.EmailNotification;
import com.orders.demo.models.Notification.Notifcation;
import com.orders.demo.models.Notification.NotificationType;
import com.orders.demo.services.Notification.INotificationService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class DemoApplication {

	@Autowired
	INotificationService notificationService;

	@GetMapping("/test")
	public String templateTest() {
		return notificationService.createNotification(0, NotificationType.EMAIL).getContent();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

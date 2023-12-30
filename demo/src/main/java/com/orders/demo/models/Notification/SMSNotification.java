package com.orders.demo.models.Notification;

import com.orders.demo.models.Template.Template;

public class SMSNotification extends Notifcation {

    private String phoneNumber;

    public SMSNotification(Template template, String phoneNumber) {
        super(template);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean send() {
        return true;
    }

    @Override
    public String getContact() {
        return phoneNumber;
    }

    @Override
    public String getContent() {
        return template.toString();
    }

}
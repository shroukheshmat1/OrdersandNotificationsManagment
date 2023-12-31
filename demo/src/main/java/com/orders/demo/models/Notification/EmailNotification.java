package com.orders.demo.models.Notification;

import com.orders.demo.models.Template.Template;

public class EmailNotification extends Notifcation {

    private String email;
    private String subject;

    public EmailNotification(Template template, String email, String subject) {
        super(template);
        this.email = email;
        this.subject = subject;
    }

    @Override
    public boolean send() {
        return true;
    }

    @Override
    public String getContact() {
        return email;
    }

    @Override
    public String getContent() {
        String result = "Subject: " + subject + "\n" + template.toString();
        return result;
    }

}
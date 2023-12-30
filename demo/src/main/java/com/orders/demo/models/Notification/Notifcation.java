package com.orders.demo.models.Notification;

import com.orders.demo.models.Template.Template;

public abstract class Notifcation {
    Template template;

    public Notifcation(Template template) {
        this.template = template;
    }

    public abstract boolean send();

    public abstract String getContact();

    public abstract String getContent();
}

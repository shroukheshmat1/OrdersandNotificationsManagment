package com.orders.demo.models.Response;

public class StatsResponse extends Response {

    private String topContact;
    private String topTemplate;

    public StatsResponse(boolean status) {
        super(status);
    }

    public StatsResponse(boolean status, String message) {
        super(status, message);
    }

    public StatsResponse(boolean status, String message, String topContact, String topTemplate) {
        super(status, message);
        this.topContact = topContact;
        this.topTemplate = topTemplate;
    }

    public String getTopContact() {
        return topContact;
    }

    public String getTopTemplate() {
        return topTemplate;
    }

}

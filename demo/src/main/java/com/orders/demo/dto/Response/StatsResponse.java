package com.orders.demo.dto.Response;

public class StatsResponse extends Response {

    private String topContact;
    private String topTemplate;

    public StatsResponse(String topContact, String topTemplate) {
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

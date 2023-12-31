package com.orders.demo.models.Template;

public class PlacementTemplate extends Template {
    private String customerName;
    private double totalPrice;

    public PlacementTemplate(Language language, String customerName, double totalPrice) {
        super(language);
        textLanguages.put(Language.ENGLISH,
                "Dear %s, your booking of total price %f is confirmed. Thanks for using our store :)");
        textLanguages.put(Language.FRENCH,
                "Cher %s, votre réservation d'un prix total %f est confirmée. Merci d'utiliser notre magasin :)");
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format(textLanguages.get(language), customerName, totalPrice);
    }

    @Override
    public String getUsedTemplate() {
        return textLanguages.get(language);
    }
}

package com.orders.demo.models.Template;

public class ShippingTemplate extends Template {
    public String customerName;
    public Double deliveryFee;
    public String location;

    public ShippingTemplate(Language language, String Name, Double Fee, String Loc) {
        super(language);
        textLanguages.put(Language.ENGLISH,
                "Dear %s , your order at %s is being shipped with %f delivery fees. Thanks for using our store :)");
        textLanguages.put(Language.FRENCH,
                "Cher %s, votre commande chez %s est expédiée avec %f frais de livraison. Merci d'utiliser notre magasin :)");
        this.customerName = Name;
        this.deliveryFee = Fee;
        this.location = Loc;
    }

    @Override
    public String toString() {
        return String.format(textLanguages.get(language), customerName, location, deliveryFee);
    }

    @Override
    public String getUsedTemplate() {
        return textLanguages.get(language);
    }

}
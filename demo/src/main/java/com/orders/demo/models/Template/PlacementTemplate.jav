package com.orders.demo.models.Template;


import java.util.Map;


public class PlacementTemplate extends Template {
    private String customerName;
    private String products;

    public PlacementTemplate(Language language, String Name,String Product)
    {
        super(language)
        textLanguages.put(Language.ENGLISH,"Dear %s, your booking of the products %s is confirmed. Thanks for using our store :)");
        textLanguages.put(Language.FRENCH,"Cher %s, votre réservation des produits %s est confirmée. Merci d'utiliser notre boutique :)");
        this.customerName = Name;
        this.products = Product;
    }

    @Override
    public String toString() {
        return String.format(textLanguages.get(language), customerName, products);
    }
}

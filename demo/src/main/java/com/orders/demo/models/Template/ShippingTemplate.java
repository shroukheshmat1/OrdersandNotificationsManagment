package com.orders.demo.models.Template;

public class ShippingTemplate extends Template {
    public String customerName;
    public Double deliveryFee;
    public String location;

    public ShippingTemplate(Language language, String Name, Double Fee, String Loc) {
        super(language);
        textLanguages.put(Language.ENGLISH,
                "Dear %s , your order is being shipped with %f delivery fees at %s. Thanks for using our store :)");
        textLanguages.put(Language.ARABIC,
                "مرحباً %s ، تم شحن %s إلى %s و الرسوم المالية هي %f. شكراً لإستخدامك موقعنا :(");
        this.customerName = Name;
        this.deliveryFee = Fee;
        this.location = Loc;
    }

    @Override
    public String toString() {
        return String.format(textLanguages.get(language), customerName, deliveryFee, location);
    }

}
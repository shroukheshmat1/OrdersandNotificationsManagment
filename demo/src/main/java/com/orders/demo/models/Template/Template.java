package com.orders.demo.models.Template;

import java.util.HashMap;
import java.util.Map;

public abstract class Template {
    Map<Language, String> textLanguages;
    Language language;

    public Template(Language language) {
        this.language = language;
        textLanguages = new HashMap<>();
    }

    public Template(Language language, Map<Language, String> textLanguages) {
        this.language = language;
        this.textLanguages = textLanguages;
    }

    public abstract String toString();

    public abstract String getUsedTemplate();
}
package com.market.categories.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class CategorieName {
    private final String value;

    public CategorieName(String value) {
        Validate.notNull(value,"Categorie Name  can be not null");
        Validate.isTrue(value.length()<=20,"Categorie Name  can be that 20 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

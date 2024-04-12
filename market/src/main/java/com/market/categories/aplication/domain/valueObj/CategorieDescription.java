package com.market.categories.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class CategorieDescription{
    private final String value;

    public CategorieDescription(String value) {
        Validate.notNull(value,"Categorie Description  can be not null");
        Validate.isTrue(value.length() >=20,"Categorie Description  can be that 40 characters");
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

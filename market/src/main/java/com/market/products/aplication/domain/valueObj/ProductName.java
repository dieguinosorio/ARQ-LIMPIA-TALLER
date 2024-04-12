package com.market.products.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class ProductName {
    private final String value;

    public ProductName(String value) {
        Validate.notNull(value,"Product name can be not null");
        Validate.isTrue(value.length()<=40,"Product name can not be longer that 40 characters.");
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

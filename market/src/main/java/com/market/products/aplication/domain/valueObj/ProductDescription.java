package com.market.products.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class ProductDescription {
    private final String value;

    public ProductDescription(String value) {
        Validate.notNull(value,"Product Description can be not null");
        Validate.isTrue(value.length()<=40,"Product Description can be that 40 characters");
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

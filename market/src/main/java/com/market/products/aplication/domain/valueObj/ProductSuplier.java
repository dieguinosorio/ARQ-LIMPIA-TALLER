package com.market.products.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class ProductSuplier {
    private final String value;

    public ProductSuplier(String value) {
        Validate.notNull(value,"Product Suplier can be not null");
        Validate.isTrue(value.length()<=20,"Product Suplier can be that 20 characters");
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

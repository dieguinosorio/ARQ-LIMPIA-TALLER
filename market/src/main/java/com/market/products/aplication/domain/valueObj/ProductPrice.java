package com.market.products.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class ProductPrice {
    private final Long value;

    public ProductPrice(Long value) {
        Validate.notNull(value,"Product price can be not null");
        Validate.isTrue(value.toString().length() <= 8, "Product price can be longer than 8 characters");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

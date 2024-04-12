package com.market.products.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class ProductId  {
    private final Long value;

    public ProductId(Long value) {
        Validate.notNull(value,"Product Id can be not null");
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

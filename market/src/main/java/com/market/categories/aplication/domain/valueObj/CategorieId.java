package com.market.categories.aplication.domain.valueObj;

import org.apache.commons.lang3.Validate;

public class CategorieId {
    private final Long value;

    public CategorieId(Long value) {
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

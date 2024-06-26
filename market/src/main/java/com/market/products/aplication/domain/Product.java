package com.market.products.aplication.domain;


import com.market.products.aplication.domain.valueObj.*;

public class Product {
    private final ProductId id;
    private final ProductName name;
    private final ProductPrice price;
    private final ProductDescription description;

    public Product(ProductId id, ProductName name, ProductPrice price, ProductDescription description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductId getId() {
        return id;
    }

    public ProductName getName() {
        return name;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public ProductDescription getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", description=" + description +
                '}';
    }
}

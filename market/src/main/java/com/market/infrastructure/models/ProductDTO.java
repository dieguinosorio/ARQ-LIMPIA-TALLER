package com.market.infrastructure.models;

import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.*;

public class ProductDTO {
    private Long productId;
    private String name;
    private Long price;
    private String description;

    public ProductDTO(Long productId, String name, Long price, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product toDomain(){
        return new Product(
            new ProductId(productId),
            new ProductName(name),
            new ProductPrice(price),
            new ProductDescription(description)
        );
    }

    public static ProductDTO fromDomain(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getId().getValue());
        productDTO.setName(product.getName().getValue());
        productDTO.setPrice(product.getPrice().getValue());
        productDTO.setDescription(product.getDescription().getValue());
        return productDTO;
    }

    public ProductDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

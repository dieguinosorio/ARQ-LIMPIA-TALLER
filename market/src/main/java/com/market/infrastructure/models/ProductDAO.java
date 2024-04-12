package com.market.infrastructure.models;

import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductDescription;
import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.domain.valueObj.ProductName;
import com.market.products.aplication.domain.valueObj.ProductPrice;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {
    private Long id;
    private String name;
    private Long price;
    private String description;

    public ProductDAO(Long id, String name, Long price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public ProductDAO() {
    }

    public Product toDomain(){
        return new Product(
                new ProductId(id),
                new ProductName(name),
                new ProductPrice(price),
                new ProductDescription(description)
        );
    }

    public static ProductDAO fromToDomain(Product product){
        ProductDAO productDAO  = new ProductDAO(
          product.getId().getValue(),
          product.getName().getValue(),
          product.getPrice().getValue(),
          product.getDescription().getValue()
        );
        return productDAO;
    }

    public static ProductDAO fromResulSet(ResultSet resultSet) throws SQLException{
        ProductDAO productDAO = new ProductDAO();
        productDAO.setId(resultSet.getLong("id"));
        productDAO.setName(resultSet.getString("name"));
        productDAO.setPrice(resultSet.getLong("price"));
        productDAO.setDescription(resultSet.getString("description"));
        return productDAO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

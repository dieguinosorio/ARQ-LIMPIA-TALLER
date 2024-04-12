package com.market.products.aplication.ports.output;

import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductId;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void store(Product product);

    Optional<Product> get(ProductId productId);

    List<ProductDTO> queryAll();

    void update(Product product);

    Boolean delete (ProductId productId);

}

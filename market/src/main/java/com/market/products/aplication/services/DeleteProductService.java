package com.market.products.aplication.services;

import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.ports.input.DeleteProductUseCase;
import com.market.products.aplication.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements DeleteProductUseCase {
    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Integer execute(Integer productId) {
        productRepository.delete(new ProductId(productId.longValue()));
        return productId;
    }
}

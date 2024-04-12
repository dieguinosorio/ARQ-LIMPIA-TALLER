package com.market.products.aplication.services;

import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.ports.input.QueryProductByIdUseCase;
import com.market.products.aplication.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueryProductById implements QueryProductByIdUseCase {

    private final ProductRepository productRepository;

    public QueryProductById(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductDTO> execute(ProductId productId) {
        Optional<Product> product = productRepository.get(productId);
        if(product.isPresent()){
            Optional<ProductDTO> productDTO = Optional.of(new ProductDTO(
                    product.get().getId().getValue(),
                    product.get().getName().getValue(),
                    product.get().getPrice().getValue(),
                    product.get().getDescription().getValue()
            ));
            return productDTO;
        }

        Optional<ProductDTO> productDTO = Optional.of(null);
        return productDTO;
    }
}

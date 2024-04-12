package com.market.products.aplication.services;

import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductDescription;
import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.domain.valueObj.ProductName;
import com.market.products.aplication.domain.valueObj.ProductPrice;
import com.market.products.aplication.ports.input.UpdateProductosUseCase;
import com.market.products.aplication.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements UpdateProductosUseCase {
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO execute(ProductDTO productDTO) {
        //Auth validations
        //Validation of domain
        //Bussines rules
        Optional<Product> prodExist = productRepository.get(new ProductId(productDTO.getProductId().longValue()));
        if(prodExist.isPresent()) {
            Product product = new Product(
                    new ProductId(productDTO.getProductId()),
                    new ProductName(productDTO.getName()),
                    new ProductPrice(productDTO.getPrice()),
                    new ProductDescription(productDTO.getDescription()));
            productRepository.update(product);
        }
        return productDTO;
    }
}

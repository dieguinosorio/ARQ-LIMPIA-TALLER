package com.market.products.aplication.services;

import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductDescription;
import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.domain.valueObj.ProductName;
import com.market.products.aplication.domain.valueObj.ProductPrice;
import com.market.products.aplication.ports.input.CreateProductsUseCase;
import com.market.products.aplication.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductsUseCase {
    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO execute(ProductDTO productDTO) {
        //Auth validations
        //Validation of domain
        //Bussines rules
        Product product = new Product(
                null,
                new ProductName(productDTO.getName().trim()),
                new ProductPrice(productDTO.getPrice()),
                new ProductDescription(productDTO.getDescription().trim()));
        System.out.println(product);
        productRepository.store(product);
        return productDTO;
    }
}

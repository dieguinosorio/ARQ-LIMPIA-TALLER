package com.market.products.aplication.services;

import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.ports.input.QueryProductAllUseCase;
import com.market.products.aplication.ports.output.ProductRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QueryProductAllService implements QueryProductAllUseCase {
    private final ProductRepository productRepository;

    public QueryProductAllService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> execute(Integer integer) {
        List<ProductDTO> products = productRepository.queryAll();
        return products;
    }
}

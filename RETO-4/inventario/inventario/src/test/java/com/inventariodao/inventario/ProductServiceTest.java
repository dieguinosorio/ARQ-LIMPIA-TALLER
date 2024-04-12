package com.inventariodao.inventario;
import com.inventariodao.inventario.domain.Product;
import com.inventariodao.inventario.domain.usecase.ProductService;
import com.inventariodao.inventario.domain.usecase.ProductServiceImpl;
import com.inventariodao.inventario.infraestructure.drivenadapters.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductServiceTest {

    @Test
    void testApplyDiscountWhenPriceGreaterThan100() {
        // Arrange
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(150.0); // Precio mayor a $100

        ProductRepository mockRepository = Mockito.mock(ProductRepository.class);
        Mockito.when(mockRepository.save(ArgumentMatchers.any(Product.class))).thenAnswer(invocation -> {
            Product savedProduct = invocation.getArgument(0);
            savedProduct.setPrice(savedProduct.getPrice() * 0.9); // Aplicar descuento del 10%
            return savedProduct;
        });

        ProductService productService = new ProductServiceImpl(mockRepository);

        // Act
        Product result = productService.createProduct(product);

        // Assert
        double expectedPrice = 135.0; // Precio con descuento del 10%
        assertEquals(expectedPrice, result.getPrice());
    }
}
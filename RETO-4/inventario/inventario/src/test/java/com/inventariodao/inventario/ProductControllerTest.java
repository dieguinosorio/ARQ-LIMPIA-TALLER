package com.inventariodao.inventario;
import com.inventariodao.inventario.domain.Product;
import com.inventariodao.inventario.domain.usecase.ProductService;
import com.inventariodao.inventario.infraestructure.entrypoints.ProductController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("Product 1");
        product1.setPrice(10.0);

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Product 2");
        product2.setPrice(20.0);

        List<Product> productList = Arrays.asList(product1, product2);
        when(productService.getAllProducts()).thenReturn(productList);

        List<Product> result = productController.getAllProducts();
        assertEquals(2, result.size());
    }
}

package com.market.infrastructure.controllers;

import com.market.infrastructure.models.ApplicationError;
import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.valueObj.ProductId;
import com.market.products.aplication.ports.input.CreateProductsUseCase;
import com.market.products.aplication.ports.input.DeleteProductUseCase;
import com.market.products.aplication.ports.input.QueryProductByIdUseCase;
import com.market.products.aplication.ports.input.UpdateProductosUseCase;
import com.market.products.aplication.services.QueryProductAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductController {
    private final CreateProductsUseCase createProductsUseCase;
    private final UpdateProductosUseCase updateProductosUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final QueryProductByIdUseCase queryProductByIdUseCase;

    private final QueryProductAllService queryProductAllService;

    public ProductController(CreateProductsUseCase createProductsUseCase, UpdateProductosUseCase updateProductosUseCase, DeleteProductUseCase deleteProductUseCase, QueryProductByIdUseCase queryProductByIdUseCase, QueryProductAllService queryProductAllService) {
        this.createProductsUseCase = createProductsUseCase;
        this.updateProductosUseCase = updateProductosUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.queryProductByIdUseCase = queryProductByIdUseCase;
        this.queryProductAllService = queryProductAllService;
    }

    @RequestMapping(value="/products",method = RequestMethod.POST)
    public ResponseEntity<?> createdProduct(@RequestBody ProductDTO productDTO){
        try{
            ProductDTO productDTOOutput = createProductsUseCase.execute(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(productDTOOutput);
        }
        catch(IllegalArgumentException | NullPointerException ex){
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", ex.getMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }
        catch (Exception e){
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of("error",e.getMessage()));
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
        try{
            Optional<ProductDTO> productDTOOutput = queryProductByIdUseCase.execute(new ProductId(productId.longValue()));
            return ResponseEntity.ok(productDTOOutput);
        }
        catch(IllegalArgumentException | NullPointerException ex){
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", ex.getMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }
        catch (Exception e){
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<?> getProducts(){
        Map<String,Object> response = new HashMap<>();
        try{
            List<ProductDTO> listProductsDTO = queryProductAllService.execute(1);
            response.put("products",listProductsDTO);
            return ResponseEntity.ok(listProductsDTO);
            //return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        catch(IllegalArgumentException | NullPointerException ex){
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", ex.getMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }
        catch (Exception e){
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/products",method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO){
        try{
            ProductDTO productDTOOutput = updateProductosUseCase.execute(productDTO);
            return ResponseEntity.ok(productDTOOutput);
        }
        catch(IllegalArgumentException | NullPointerException ex){
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", ex.getMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }
        catch (Exception e){
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/products/{productId}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        try{
            deleteProductUseCase.execute(productId);
            return ResponseEntity.ok(productId);
        }
        catch(IllegalArgumentException | NullPointerException ex){
            ApplicationError applicationError = new ApplicationError(
                    "InputDataValidationError",
                    "Bad input data",
                    Map.of("error", ex.getMessage()));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }
        catch (Exception e){
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}

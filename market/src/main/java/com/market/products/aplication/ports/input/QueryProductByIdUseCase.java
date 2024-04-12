package com.market.products.aplication.ports.input;

import com.market.commons.UseCase;
import com.market.infrastructure.models.ProductDTO;
import com.market.products.aplication.domain.Product;
import com.market.products.aplication.domain.valueObj.ProductId;

import java.util.Optional;

public interface QueryProductByIdUseCase  extends UseCase<ProductId,Optional<ProductDTO>> {

}

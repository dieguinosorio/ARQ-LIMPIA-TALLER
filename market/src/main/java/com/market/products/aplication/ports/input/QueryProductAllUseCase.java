package com.market.products.aplication.ports.input;

import com.market.commons.UseCase;
import com.market.infrastructure.models.ProductDTO;

import java.util.List;

public interface QueryProductAllUseCase extends UseCase<Integer, List<ProductDTO>> {
}

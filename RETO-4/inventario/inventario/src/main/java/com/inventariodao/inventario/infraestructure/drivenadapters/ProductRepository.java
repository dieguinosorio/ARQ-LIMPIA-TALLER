package com.inventariodao.inventario.infraestructure.drivenadapters;

import com.inventariodao.inventario.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
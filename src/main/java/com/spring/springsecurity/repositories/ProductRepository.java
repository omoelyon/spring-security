package com.spring.springsecurity.repositories;

import com.spring.springsecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

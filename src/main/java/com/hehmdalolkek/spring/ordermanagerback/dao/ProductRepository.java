package com.hehmdalolkek.spring.ordermanagerback.dao;

import com.hehmdalolkek.spring.ordermanagerback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

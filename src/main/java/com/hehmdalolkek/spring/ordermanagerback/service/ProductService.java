package com.hehmdalolkek.spring.ordermanagerback.service;

import com.hehmdalolkek.spring.ordermanagerback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface ProductService {

    public List<Product> getAllProducts();

}

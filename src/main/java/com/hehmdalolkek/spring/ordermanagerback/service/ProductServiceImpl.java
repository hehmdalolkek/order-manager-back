package com.hehmdalolkek.spring.ordermanagerback.service;

import com.hehmdalolkek.spring.ordermanagerback.dao.ProductRepository;
import com.hehmdalolkek.spring.ordermanagerback.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}

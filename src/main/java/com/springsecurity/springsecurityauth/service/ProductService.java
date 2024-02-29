package com.springsecurity.springsecurityauth.service;

import com.springsecurity.springsecurityauth.model.Product;


import com.springsecurity.springsecurityauth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    // Your code goes here
    @Autowired
    ProductRepository productRepository;
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }
}

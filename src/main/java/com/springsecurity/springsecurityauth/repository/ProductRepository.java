package com.springsecurity.springsecurityauth.repository;

import com.springsecurity.springsecurityauth.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    // Your code goes here
    //fetch all data
    public List<Product> findAll();
    //find by id
    public Optional<Product> findById(long id);
}

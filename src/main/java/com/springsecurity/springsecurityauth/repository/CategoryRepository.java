package com.springsecurity.springsecurityauth.repository;

import com.springsecurity.springsecurityauth.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    // Your code goes here
    //fetch all data
    public List<Category> findAll();
    //find by id
    public Optional<Category> findById(long id);
}

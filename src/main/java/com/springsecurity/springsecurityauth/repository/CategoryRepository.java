package com.springsecurity.springsecurityauth.repository;

import com.springsecurity.springsecurityauth.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    // Your code goes here
    //fetch all data
    public List<Category> findAll();
    //find by id
    public Optional<Category> findById(long id);

    List<Category> findByName(String standard);

    List<Category> findByProductsName(String assuranceTousRisques);
}

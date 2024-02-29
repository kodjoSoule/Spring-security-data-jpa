package com.springsecurity.springsecurityauth.service;

import com.springsecurity.springsecurityauth.model.Category;
import com.springsecurity.springsecurityauth.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    // Your code goes here
    public Optional<Category> getCategoryById(long id){
        return categoryRepository.findById(id);
    }
}

package com.springsecurity.springsecurityauth.service;

import com.springsecurity.springsecurityauth.model.Category;
import com.springsecurity.springsecurityauth.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    // Your code goes here
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
    public Optional<Category> getCategoryById(long id){
        return categoryRepository.findById(id);
    }
    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }

    public Category addCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }


    public List<Category> getCategoryByName(String standard) {
        return categoryRepository.findByName(standard);
    }

    public List<Category> getCategoriesByProductName(String assuranceTousRisques) {
        return categoryRepository.findByProductsName(assuranceTousRisques);
    }
}

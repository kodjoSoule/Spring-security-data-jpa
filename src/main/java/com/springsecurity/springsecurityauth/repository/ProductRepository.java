package com.springsecurity.springsecurityauth.repository;

import com.springsecurity.springsecurityauth.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

    //find by name
    public List<Product> findByName(String name);
    //find by category name
    public List<Product> findByCategoriesName(String name);

    @Query("FROM Product WHERE name = ?1")
    public Iterable<Product> findByNameJPQL(String name);

    @Query(value = "SELECT * FROM produit WHERE cout = :cout", nativeQuery = true)
    public Iterable<Product> findByCostNative(@Param("cout") Integer cost);
    //find by cost less than
    public List<Product> findByCostLessThan(Integer cost);
}

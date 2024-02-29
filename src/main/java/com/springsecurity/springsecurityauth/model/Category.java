package com.springsecurity.springsecurityauth.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_category")
public class Category {

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categorie_id")
    private int categoryId;

    @Column(name="nom")
    private String name;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "categorie_produit",
            joinColumns = @JoinColumn(name = "categorie_id"),
            inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    private List<Product> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addProduct(Product product) {
        products.add(product);
        product.getCategories().add(this);
    }

    public void removeProduit(Product product) {
        products.remove(product);
        product.getCategories().remove(this);
    }

}

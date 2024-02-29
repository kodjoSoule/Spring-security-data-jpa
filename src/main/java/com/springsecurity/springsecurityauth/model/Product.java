package com.springsecurity.springsecurityauth.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produit_id")
    private int id;

    @Column(name = "nom")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cout")
    private int cost;


    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "produit_id")
    List<Comment> comments = new ArrayList<>();

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @ManyToMany(
            mappedBy = "products",
            cascade = CascadeType.ALL
    )
    private List<Category> categories = new ArrayList<>();


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    //add comment


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setProduct(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setProduct(null);
    }

}

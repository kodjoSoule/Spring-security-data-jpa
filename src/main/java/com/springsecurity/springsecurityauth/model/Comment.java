package com.springsecurity.springsecurityauth.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "commentaire")
    private String content;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name="produit_id")
    private Product product;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String comment) {
        this.content = comment;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

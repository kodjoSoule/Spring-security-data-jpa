package com.springsecurity.springsecurityauth;

import com.springsecurity.springsecurityauth.model.Category;
import com.springsecurity.springsecurityauth.model.Comment;
import com.springsecurity.springsecurityauth.model.Product;
import com.springsecurity.springsecurityauth.service.CategoryService;
import com.springsecurity.springsecurityauth.service.CommentService;
import com.springsecurity.springsecurityauth.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringSecurityAuthApplication implements CommandLineRunner {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentService commentService;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringSecurityAuthApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("----------------------------------------------------------");
        System.out.println("Application started");
        Optional<Category> optCategory = categoryService.getCategoryById(1);
        Category categoryId1 = optCategory.get();

        Optional<Product> product1 = productService.getProductById(1);
        if(product1.isPresent()) {
            categoryId1.addProduct(product1.get());
        }else{
            System.out.println("Product not found");
        }


        System.out.println(categoryId1.getName());
        if(categoryId1.getProducts().size() == 0) {
            System.out.println("No products found");
            return; // No products found
        }
        // Print the products
        System.out.println("-------------------");
        System.out.println("Products in category " + categoryId1.getName() + ":");
        categoryId1.getProducts().forEach(
                product -> System.out.println("Product : " + product.getName()));

//

        categoryService.getCategories().forEach(
                category -> System.out.println(category.getName()));

        Category newCategory = new Category();
        newCategory.setName("Promotion");
        // Add the new category [1]
        newCategory = categoryService.addCategory(newCategory);
        // Print the categories
        System.out.println("-------------------");
        System.out.println("Categories : ");
        categoryService.getCategories().forEach(
                category -> System.out.println(category.getName()));

        Product newProduct = new Product();
        newProduct.setName("AssuranceTousRisques");
        newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
        newProduct.setCost(1100);
        // Add the new product [2]
        newCategory.addProduct(newProduct);
        newProduct = productService.addProduct(newProduct);
        productService.getProducts().forEach(
                product -> System.out.println(product.getName()));

        newProduct.getCategories().forEach(
                category -> System.out.println(category.getName()));

        //Update the cost of the product
        Product existingProduct = productService.getProductById(1).get();
        System.out.println("Actual Cost : "+existingProduct.getCost());
        existingProduct.setCost(3000);
        productService.addProduct(existingProduct);
        existingProduct = productService.getProductById(1).get();
        System.out.println("Updated Product(Cost) : "+ existingProduct.getCost());
        //Show comments of the product 2
        //get the product 2
        Product product2 = productService.getProductById(2).get();
        //create comments
        Comment comment1 = new Comment(
                "This is a good product"
        );
        //add the comments to the product 2
        product2.addComment(comment1);
        commentService.saveComment(comment1);
        Comment comment2 = new Comment(
                "This is a very good product"
        );
        product2.addComment(comment2);
        commentService.saveComment(comment2);
        Comment comment3 = new Comment(
                "This is a bad product"
        );
        //get the comments of the product 2
        System.out.println("Comments of the product 2");
        product2.getComments().forEach(
                comment -> System.out.println("Comment : " +
                        comment.getContent()));

        System.out.println("Deleting comment 2 from product 2");
        Comment commentToDelete = commentService.getCommentById(comment2.getId()).orElse(null);
        if (commentToDelete != null) {
            // Remove the comment from the product
            product2.removeComment(commentToDelete);
            // Remove the comment from the database
            commentService.deleteComment(commentToDelete);
        }
        //show all products
        System.out.println("All products : ");
        productService.getProducts().forEach(
                product -> System.out.println(product.getName()));
        //show product 2
        if (productService.getProductById(2).isPresent()) {
            System.out.println("Product 2 : ");
            Product product = productService.getProductById(2).get();
            System.out.println("Product : " + product.getName());
            System.out.println("Comments of the product 2");
            product.getComments().forEach(
                    comment -> System.out.println("Comment : " +
                            comment.getContent()));
        }else{
            System.out.println("Product 2 not found");
        }

        //search product

        List<Product> searchResults = productService.getProductByName("AssuranceTousRisques");
        if(searchResults.size() == 0) {
            System.out.println("No products found");
        }else{
            System.out.println("Products found : ");
            searchResults.forEach(
                    product -> System.out.println("Product : " + product.getName()));
        }


    }
    }


package com.springsecurity.springsecurityauth;

import com.springsecurity.springsecurityauth.model.Category;
import com.springsecurity.springsecurityauth.model.Product;
import com.springsecurity.springsecurityauth.service.CategoryService;
import com.springsecurity.springsecurityauth.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SpringSecurityAuthApplication implements CommandLineRunner {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

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
        newProduct.setName("AssuranceAuTiersFidelite");
        newProduct.setDescription("Les garanties de l'assurance au tiers à un prix moindre grâce à votre fidélité!");
        newProduct.setCost(1100);
        // Add the new product [2]
        newCategory.addProduct(newProduct);
        newProduct = productService.addProduct(newProduct);
        productService.getProducts().forEach(
                product -> System.out.println(product.getName()));

        newProduct.getCategories().forEach(
                category -> System.out.println(category.getName()));
    }
    }


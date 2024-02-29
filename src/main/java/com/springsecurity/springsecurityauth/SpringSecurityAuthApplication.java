package com.springsecurity.springsecurityauth;

import com.springsecurity.springsecurityauth.model.Product;
import com.springsecurity.springsecurityauth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class SpringSecurityAuthApplication implements CommandLineRunner {

    @Autowired
    ProductService productService;

    public static void main(String[] args)
    {
        SpringApplication.run(SpringSecurityAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("----------------------------------------------------------");
        System.out.println("Application started");
        Iterable<Product> products = productService.getProducts();
        if (products != null) {
            products.forEach(
                    product -> System.out.println("Product name : "+ product.getName())
            );
        }
        System.out.println("----------------------------------------------------------");
        Optional<Product> optProduct = productService.getProductById(1);
        if(optProduct.isEmpty())
        {
            System.out.println("Product not found");
            return;
        }
        Product productId1 = optProduct.get();
        System.out.println(productId1.getName());
    }
}

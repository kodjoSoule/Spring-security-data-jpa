package com.springsecurity.springsecurityauth;

import com.springsecurity.springsecurityauth.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityAuthApplication implements CommandLineRunner {
    @Autowired
    @Qualifier("EtudiantB")
    Student student;
    public static void main(String[] args)
    {
        SpringApplication.run(SpringSecurityAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello Spring Security");
        System.out.println(student);
    }
}

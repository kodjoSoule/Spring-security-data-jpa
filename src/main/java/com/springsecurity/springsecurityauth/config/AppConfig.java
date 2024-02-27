package com.springsecurity.springsecurityauth.config;

import com.springsecurity.springsecurityauth.bean.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // Your code goes here
    @Bean
    @Qualifier("EtudiantA")
    public Student student()
    {
        return new Student(1, "Ramesh Etudiant A", "Java");
    }
    @Bean
    @Qualifier("EtudiantB")
    public Student student1()
    {
        return new Student(2, "Suresh- Etudiant B", "Spring");
    }
}

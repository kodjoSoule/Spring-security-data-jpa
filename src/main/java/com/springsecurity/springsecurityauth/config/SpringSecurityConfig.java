package com.springsecurity.springsecurityauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> {
            //pour permettre à l'administrateur d'accéder à cette URL
            auth.requestMatchers("/admin").hasRole("ADMIN");
            auth.requestMatchers("/user").hasRole("USER");
            //pour permettre à tout le monde d'accéder à cette URL
            auth.requestMatchers("/test").permitAll();
            auth.anyRequest().authenticated();
        }).formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public UserDetailsService users() {
        // créer un utilisateur "user" et un utilisateur "admin"
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user"))
                // ajouter un rôle à l'utilisateur "user"
                .roles("USER").build();
        // créer un utilisateur "admin" et un utilisateur "admin"
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                // ajouter un rôle à l'utilisateur "user" et "admin"
                .roles("USER", "ADMIN").build();
        // retourner une liste d'utilisateurs
        return new InMemoryUserDetailsManager(user, admin);
    }

@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
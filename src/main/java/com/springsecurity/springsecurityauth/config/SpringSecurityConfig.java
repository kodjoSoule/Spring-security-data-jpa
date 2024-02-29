package com.springsecurity.springsecurityauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                .requestMatchers("/test").permitAll()
                //pour permettre à tout le monde d'accéder à h2 console
                .requestMatchers("/h2-console/**").permitAll()
                //pour permettre à l'administrateur d'accéder à cette URL
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/user").hasRole("USER")
                .requestMatchers("/manager").hasRole("MANAGER")
                //pour permettre à tout le monde d'accéder à cette URL
                .anyRequest().authenticated()
        ).formLogin(Customizer.withDefaults());

        return http.build();

    }

    //par openclassrooms
    @Bean
    public UserDetailsService users() {
        // créer un utilisateur "user" et un utilisateur "admin"
        UserDetails user = User
                .builder()
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
        // créer un utilisateur "manager" et un utilisateur "manager"
        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder().encode("manager"))
                // ajouter un rôle à l'utilisateur "user" et "admin"
                .roles("MANAGER").build();
        // retourner une liste d'utilisateurs
        return new InMemoryUserDetailsManager(user, admin, manager);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

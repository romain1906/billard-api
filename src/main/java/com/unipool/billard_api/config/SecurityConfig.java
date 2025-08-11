package com.unipool.billard_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()  // Désactive CORS et CSRF
                .authorizeRequests()
                .requestMatchers("/**").permitAll()  // Permet l'accès à toutes les routes sans authentification
                .anyRequest().permitAll();         // Requiert aucune authentification pour toutes les autres routes
        return http.build();
    }
}

package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
            .authorizeHttpRequests(auth ->{
                auth.requestMatchers("/", "/login", "/signup").permitAll(); 
                auth.anyRequest().authenticated();
            })
            .oauth2Login(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .logout(logout -> logout
                .permitAll()
            )
            .build();
    }
}

package com.example.springbackend.configs;

import com.example.springbackend.services.myUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Make class spring managed bean
@EnableWebSecurity // Make config class be able to handle http authentication
/**
 * Config class to setup custom authentication to various endpoints
 * and create beans
 */
public class SecurityConfig {

    private final myUserDetailsService myUserDetailsService;

    public SecurityConfig(myUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }


    /**
     * Method to assign roles to different endpoints
     * @param httpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/register").permitAll() // allow all to /register
                        .requestMatchers("/admin").hasAnyRole("ADMIN","MANAGER") // allow admin and manager to /adin
                        .requestMatchers("/manager").hasRole("MANAGER") // allow manager to /manager
                        .anyRequest().authenticated()); // allow any other endpoint to anyone who is authenticated


                httpSecurity.userDetailsService(myUserDetailsService); // use Custom detailsService
                httpSecurity.logout(Customizer.withDefaults()); // use springs login form
                httpSecurity.formLogin(Customizer.withDefaults()); // use springs logout form


        return httpSecurity.build();
    }

    /**
     * Method to create a spring bean for password-encoder
     * @return BCryptPasswordEncoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }








}




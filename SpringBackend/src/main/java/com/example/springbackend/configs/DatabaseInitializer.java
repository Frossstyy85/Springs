package com.example.springbackend.configs;

import com.example.springbackend.entities.ApplicationUser;
import com.example.springbackend.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;


/**
 * Class to initialize mock users for database
 */
@Component // Make class spring  bean
public class DatabaseInitializer {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DatabaseInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Method to manually add users to database
     */
    @PostConstruct // Annotation to make method run after construction
    private void userInitializer() {


        // Place all pre-configured users in a fixed list
        List<ApplicationUser> userList = Arrays.asList(
                new ApplicationUser("admin",null,"ADMIN"),
                new ApplicationUser("manager",null,"MANAGER"),
                new ApplicationUser("user",null,"USER")
        );

        // Go through list
        for (ApplicationUser user : userList){

            // Check if user already exists
            if (userRepository.findByUsername(user.getUsername()) == null) {

                // set and hash user password
                user.setPassword(passwordEncoder.encode("password"));
                userRepository.save(user); // Save user to database with repository
            }
        }



    }
}

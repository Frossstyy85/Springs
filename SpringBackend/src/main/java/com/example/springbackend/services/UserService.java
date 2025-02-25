package com.example.springbackend.services;


import com.example.springbackend.entities.ApplicationUser;
import com.example.springbackend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service // Make class spring managed bean
/**
 * Service class for communication between repository and controller
 */
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    UserService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    /**
     * Class to add user to database with repo
     * @param user
     */
    public void addUser(ApplicationUser user){

        // Hash the users selected password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Give all new accounts USER role by default
        user.setRole("USER");
        userRepository.save(user);  // Save user to repository
    }

}

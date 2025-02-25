package com.example.springbackend.services;

import com.example.springbackend.entities.ApplicationUser;
import com.example.springbackend.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service // Make class spring managed bean
/**
 * custom UserDetailsService class to have our securityFilterChain work together with the database
 */
public class myUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public myUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Class to handle login with database
     * @param username
     * @return userdetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        ApplicationUser applicationUser = userRepository.findByUsername(username); // fetch user by name

        // return user-details of the current user and let spring check if user is allowed to x endpoint
        return new org.springframework.security.core.userdetails.User(
                applicationUser.getUsername(),
                applicationUser.getPassword(),
                true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + applicationUser.getRole())
        ));


    }
}

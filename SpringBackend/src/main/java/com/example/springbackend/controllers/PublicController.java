package com.example.springbackend.controllers;

import com.example.springbackend.entities.ApplicationUser;
import com.example.springbackend.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Controller endpoint with low authority
 */
@Controller // Tell spring this class has controller endpoints
public class PublicController {

    private final UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Method to display welcome page at root path
     * @return welcome page
     */
    @GetMapping("/")
    public String basePath(){
        return "welcome";
    }

    /**
     * Page to display current users name on a webpage.
     * @param model
     * @return
     */
    @GetMapping("/user")
    public String displayUser(Model model){
        // Get authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get the name of the authentication
        model.addAttribute("username",username); // add username to the model
        return "userinfo"; // return user page with the model
    }

    /**
     * Page to show register form
     * @return register form
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * Post endpoint for adding user to database
     * @param user mapped from form in html page
     * @return redirect to /user endpoint
     */
    @PostMapping("/register")
    public String registerUser(ApplicationUser user){
        userService.addUser(user);
        return "redirect:/user";
    }





}
package com.example.springbackend.entities;

import jakarta.persistence.*;


@Entity // Tell spring this class has a matching table in a database
/**
 * User model class that represents a table in the database
 */
public class ApplicationUser {

    @Id @GeneratedValue // Key for each instance of ApplicationUser in database
    private Long id;

    public ApplicationUser(){}

    private String username;
    private String password;
    private String role;


    public ApplicationUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




}

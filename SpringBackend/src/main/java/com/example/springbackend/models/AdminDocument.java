package com.example.springbackend.models;

/**
 * Model for admindocuments
 */
public class AdminDocument {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AdminDocument(String title, String description) {
        this.title = title;
        this.description = description;
    }

    private String title;
    private String description;

}

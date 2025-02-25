package com.example.springbackend.controllers;

import com.example.springbackend.components.AdminComponent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // Tell spring this class has controller endpoints
@RequestMapping("/admin") // set path for the endpoints

/**
 * Controller for admin endpoints
 */
public class AdminController {

    private final AdminComponent adminDocumentComponent;

    AdminController(AdminComponent adminDocumentComponent){
        this.adminDocumentComponent = adminDocumentComponent;
    }

    /**
     * End point to view admin documents page
     * @param model
     * @return admin-documents.html
     */
    @GetMapping
    public String displayAdminDocuments(Model model){
        model.addAttribute("documents",adminDocumentComponent.getAdminDocuments());
        return "admin-documents";
    }


}

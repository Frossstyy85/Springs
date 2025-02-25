package com.example.springbackend.controllers;

import com.example.springbackend.components.ManagerComponent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Tell spring this class has controller endpoints
@RequestMapping("/manager") // set path on the endpoints
/**
 * Controller for manager endpoints
 */
public class ManagerController {

    private final ManagerComponent managerInfoComponent;

    ManagerController(ManagerComponent managerInfoComponent){
        this.managerInfoComponent = managerInfoComponent;
    }

    /**
     * Method that returns manager info page with managerinfo list
     * @param model
     * @return manager-info.html
     */
    @GetMapping
    public String getManagerInfo(Model model){
        model.addAttribute("info",managerInfoComponent.getManagerInfo());
        return "manager-info";
    }

}

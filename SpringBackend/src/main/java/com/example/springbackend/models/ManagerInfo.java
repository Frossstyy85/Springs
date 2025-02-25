package com.example.springbackend.models;


/**
 * model for managerinfo
 */
public class ManagerInfo {


    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ManagerInfo(String title, String infoText) {
        this.title = title;
        this.infoText = infoText;
    }

    private String title;
    private String infoText;



}

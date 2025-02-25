package com.example.springbackend.components;


import com.example.springbackend.models.AdminDocument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * * Class with single method to create list for admin-documents.html
 */
@Component // Make class a spring bean
public class AdminComponent {

    /**
     * Method to create a list of AdminDocument objects
     *
     * @return
     */
    public List<AdminDocument> getAdminDocuments(){
        ArrayList<AdminDocument> list  = new ArrayList<>();
        list.add(new AdminDocument("Title 1","description 1"));
        list.add(new AdminDocument("Title 2","description 2"));
        list.add(new AdminDocument("Title 3","description 3"));
        return list;
    }


}

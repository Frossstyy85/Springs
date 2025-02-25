package com.example.springbackend.components;

import com.example.springbackend.models.ManagerInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with single method to create list for manager-info.html
 */
@Component // Make class spring bean
public class ManagerComponent {

    /**
     * Method to create a list of ManagerInfo objects
     * @return List<ManagerInfo>
     */
    public List<ManagerInfo> getManagerInfo(){
        ArrayList<ManagerInfo> list  = new ArrayList<>();
        list.add(new ManagerInfo("Title 1","infoText 1"));
        list.add(new ManagerInfo("Title 2","infoText 2"));
        list.add(new ManagerInfo("Title 3","infoText 3"));
        return list;
    }


}

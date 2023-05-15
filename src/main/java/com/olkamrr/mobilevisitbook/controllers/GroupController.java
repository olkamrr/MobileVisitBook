package com.olkamrr.mobilevisitbook.controllers;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping("/{userId}")
    public Group getGroup(@PathVariable(value = "userId") int id) {
        return groupService.findByUser(id);
    }
}

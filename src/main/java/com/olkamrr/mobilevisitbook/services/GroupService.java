package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.models.User;
import com.olkamrr.mobilevisitbook.repositories.GroupRepository;
import com.olkamrr.mobilevisitbook.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    private GroupRepository repository;
    private StudentRepository studentRepository;
    private UserService userService;

    @Autowired
    public GroupService(GroupRepository repository, StudentRepository studentRepository, UserService userService){
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.userService = userService;
    }

    public Group findOne(int id) {
        Group foundGroup = repository.findById(id);
        return foundGroup;
    }

    public Group findByUser(int id) {
        User user = userService.findOne(id);
        Group group = repository.findByUser(user);
        return group;
    }

    public User findUser(int id) {
        Group foundGroup = repository.findById(id);
        User user = foundGroup.getUser();
        return user;
    }

}


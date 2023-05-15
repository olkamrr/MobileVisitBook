package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Teacher;
import com.olkamrr.mobilevisitbook.models.User;
import com.olkamrr.mobilevisitbook.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private TeacherRepository teacherRepository;
    private UserService userService;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, UserService userService){
        this.teacherRepository = teacherRepository;
        this.userService = userService;
    }

    public Teacher findOne(int id) {
        Teacher foundTeacher = teacherRepository.findById(id);
        return foundTeacher;
    }

    public User findUser(int id) {
        Teacher foundTeacher = teacherRepository.findById(id);
        User user = foundTeacher.getUser();
        return user;
    }
}

package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Teacher;
import com.olkamrr.mobilevisitbook.models.User;
import com.olkamrr.mobilevisitbook.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Teacher> getAllTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        Streamable.of(teacherRepository.findAll())
                .forEach(teachers::add);
        return teachers;
    }

    public Teacher findByUser(int id) {
        User user = userService.findOne(id);
        Teacher teacher = teacherRepository.findByUser(user);
        return teacher;
    }

    public User findUser(int id) {
        Teacher foundTeacher = teacherRepository.findById(id);
        User user = foundTeacher.getUser();
        return user;
    }
}

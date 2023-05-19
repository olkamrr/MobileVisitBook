package com.olkamrr.mobilevisitbook.controllers;

import com.olkamrr.mobilevisitbook.models.Teacher;
import com.olkamrr.mobilevisitbook.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<Teacher> getAll() {
        return teacherService.getAllTeacher();
    }
}

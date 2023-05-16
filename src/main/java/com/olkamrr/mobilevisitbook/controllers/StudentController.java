package com.olkamrr.mobilevisitbook.controllers;

import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.services.GroupService;
import com.olkamrr.mobilevisitbook.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService){
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/{groupId}")
    public List<Student> studentByGroup(@PathVariable(value = "groupId") int groupId){
        List<Student> students = studentService.studentByGroupOrderByLastNameAsc(groupId);
        return students;
    }

    @GetMapping("/elder/{groupId}")
    public Student findElder(@PathVariable(value = "groupId") int groupId) {
        Student student = studentService.findElder(groupId);
        return student;
    }
}

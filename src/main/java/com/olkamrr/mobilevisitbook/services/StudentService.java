package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private GroupService groupService;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupService groupService){
        this.studentRepository = studentRepository;
        this.groupService = groupService;
    }

    public Student findOne(int id) {
        Student foundStudent = studentRepository.findById(id);
        return foundStudent;
    }

    public Group findGroup(int id){
        Student foundStudent = studentRepository.findById(id);
        Group group = foundStudent.getGroupId();
        return group;
    }

    public List<Student> studentByGroupOrderByLastNameAsc(int groupId){
        List<Student> students = studentRepository.findStudentsByGroupIdOrderByLastNameAsc(groupService.findOne(groupId));
        return students;
    }
}

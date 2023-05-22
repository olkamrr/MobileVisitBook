package com.olkamrr.mobilevisitbook.controllers;

import com.olkamrr.mobilevisitbook.models.Schedule;
import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.models.Visit;
import com.olkamrr.mobilevisitbook.services.ScheduleService;
import com.olkamrr.mobilevisitbook.services.StudentService;
import com.olkamrr.mobilevisitbook.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/visit")
public class VisitController {
    private VisitService visitService;
    private StudentService studentService;
    private ScheduleService scheduleService;

    @Autowired
    public VisitController(VisitService visitService, StudentService studentService, ScheduleService scheduleService){
        this.visitService = visitService;
        this.studentService = studentService;
        this.scheduleService = scheduleService;
    }

    @PostMapping("/save/{lessonId}/{studentId}")
    public Visit save(@RequestBody Visit visit, @PathVariable("lessonId") int lessonId, @PathVariable("studentId") int studentId){
        return visitService.save(visit, lessonId, studentId);
    }

    @PostMapping("/update/{id}")
    public Visit update(@PathVariable(value = "id") int id, @RequestBody Visit visit){
        Student student = visitService.findStudent(id);
        Schedule lesson = visitService.findSchedule(id);
        return visitService.update(id, visit, lesson, student);
    }

    @GetMapping("/find/{lessonId}/{studentId}")
    public List<Visit> findVisit(@PathVariable(value = "lessonId") int lessonId, @PathVariable(value = "studentId") int studentId) {
        return visitService.findVisit(lessonId, studentId);
    }

    @GetMapping("/find/{lessonId}/{studentId}/{data}")
    public Visit findVisitLesson(@PathVariable(value = "lessonId") int lessonId, @PathVariable(value = "studentId") int studentId, @PathVariable(value = "data") String data) {
        return visitService.findVisitLesson(lessonId, studentId, data);
    }

}

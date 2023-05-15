package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Schedule;
import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.models.Visit;
import com.olkamrr.mobilevisitbook.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {
    private VisitRepository visitRepository;
    private StudentService studentService;
    private ScheduleService scheduleService;

    @Autowired
    public VisitService(VisitRepository visitRepository, StudentService studentService, ScheduleService scheduleService){
        this.visitRepository = visitRepository;
        this.studentService = studentService;
        this.scheduleService = scheduleService;
    }

    public Student findStudent(int id){
        Visit foundVisit = visitRepository.findById(id);
        Student student = foundVisit.getStudentId();
        return student;
    }

    public Schedule findSchedule(int id){
        Visit foundVisit = visitRepository.findById(id);
        Schedule lesson = foundVisit.getLessonId();
        return lesson;
    }

    public Visit save(Visit visit, int lessonId, int studentId){
        visit.setLessonId(scheduleService.findOne(lessonId));
        visit.setStudentId(studentService.findOne(studentId));
        return visitRepository.save(visit);
    }

    public Visit update(int id, Visit visit, Schedule lesson, Student student){
        visit.setId(id);
        visit.setLessonId(lesson);
        visit.setStudentId(student);
        return visitRepository.save(visit);
    }
}

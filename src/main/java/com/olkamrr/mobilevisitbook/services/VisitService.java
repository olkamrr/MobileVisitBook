package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Schedule;
import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.models.Teacher;
import com.olkamrr.mobilevisitbook.models.Visit;
import com.olkamrr.mobilevisitbook.repositories.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Visit> findVisit(int lessonId, int studentId) {
        Schedule schedule = scheduleService.findOne(lessonId);
        Student student = studentService.findOne(studentId);
        List<Visit> visits = visitRepository.findVisitsByLessonIdAndStudentId(schedule, student);
        return visits;
    }

    public Visit findVisitLesson(int lessonId, int studentId, String date) {
        Schedule schedule = scheduleService.findOne(lessonId);
        Student student = studentService.findOne(studentId);
        List<Visit> visits = visitRepository.findVisitsByLessonIdAndStudentId(schedule, student);
        Visit visit = new Visit();
        for (Visit visit1: visits) {
            Date dateVisit = visit1.getDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String visitDate = dateFormat.format(dateVisit);
            if (visitDate.equals(date)){
                visit = visit1;
            }
        }
        return visit;
    }
}

package com.olkamrr.mobilevisitbook.services;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Schedule;
import com.olkamrr.mobilevisitbook.models.Teacher;
import com.olkamrr.mobilevisitbook.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private GroupService groupService;
    private TeacherService teacherService;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, GroupService groupService, TeacherService teacherService){
        this.scheduleRepository = scheduleRepository;
        this.groupService = groupService;
        this.teacherService = teacherService;
    }

    public Schedule findOne(int id) {
        Schedule foundLesson = scheduleRepository.findById(id);
        return foundLesson;
    }

    public Group findGroup(int id){
        Schedule foundLesson = scheduleRepository.findById(id);
        Group group = foundLesson.getGroupId();
        return group;
    }

    public Schedule save(Schedule lesson, int id){
        lesson.setGroupId(groupService.findOne(id));
        return scheduleRepository.save(lesson);
    }

    public Schedule update(int id, Schedule lesson, Group group){
        lesson.setId(id);
        lesson.setGroupId(group);
        return scheduleRepository.save(lesson);
    }

    public Schedule delete(int id){
        scheduleRepository.deleteById(id);
        return null;
    }

    public List<Schedule> schedulesByGroup(int groupId){
        List<Schedule> lesson = scheduleRepository.findSchedulesByGroupId(groupService.findOne(groupId));
        return lesson;
    }

    public List<Schedule> schedulesByGroupAndSemester(int groupId, int semester){
        List<Schedule> lesson = scheduleRepository.findSchedulesByGroupIdAndSemester(groupService.findOne(groupId), semester);
        return lesson;
    }
    public List<Schedule> schedulesByGroupAndSemesterAndWeekday(int groupId, int semester, String weekday){
        List<Schedule> lesson = scheduleRepository.findSchedulesByGroupIdAndSemesterAndWeekday(groupService.findOne(groupId), semester, weekday);
        return lesson;
    }
    public List<Schedule> schedulesByGroupAndSemesterAndWeekdayAndWeek(int groupId, int semester, String weekday, String week){
        List<Schedule> lesson1 = scheduleRepository.findSchedulesByGroupIdAndSemesterAndWeekdayAndWeek(groupService.findOne(groupId), semester, weekday, week);
        List<Schedule> lesson2 = scheduleRepository.findSchedulesByGroupIdAndSemesterAndWeekdayAndWeek(groupService.findOne(groupId), semester, weekday, "Каждую неделю");
        List<Schedule> lesson = new ArrayList<>();
        lesson.addAll(lesson1);
        lesson.addAll(lesson2);
        return lesson;
    }

    public List<Schedule> findSchedulesByTeacher(int teacherId, String weekday) {
        Teacher teacher = teacherService.findOne(teacherId);
        List<Schedule> lessons = scheduleRepository.findSchedulesByTeacherAndWeekday(teacher, weekday);
        return lessons;
    }
}

package com.olkamrr.mobilevisitbook.controllers;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Schedule;
import com.olkamrr.mobilevisitbook.services.GroupService;
import com.olkamrr.mobilevisitbook.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;
    private GroupService groupService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, GroupService groupService){
        this.scheduleService = scheduleService;
        this.groupService = groupService;
    }

    @PostMapping("/save/{groupId}")
    public Schedule save(@RequestBody Schedule lesson, @PathVariable("groupId") int groupId){
        return scheduleService.save(lesson, groupId);
    }

    @PostMapping("/update/{id}")
    public Schedule update(@PathVariable(value = "id") int id, @RequestBody Schedule lesson){
        Group group = scheduleService.findGroup(id);
        return scheduleService.update(id, lesson, group);
    }

    @GetMapping("/edit/{id}")
    public Schedule edit(@PathVariable(value = "id") int id){
        Schedule schedule = scheduleService.findOne(id);
        return schedule;
    }

    @GetMapping("/delete/{id}")
    public Schedule delete(@PathVariable(value = "id") int id){
        return scheduleService.delete(id);
    }

    @GetMapping("/{groupId}")
    public List<Schedule> schedulesByGroup(@PathVariable(value = "groupId") int groupId){
        List<Schedule> lessons = scheduleService.schedulesByGroup(groupId);
        return lessons;
    }

    @GetMapping("/{groupId}/{semester}")
    public List<Schedule> schedulesByGroupAndSemester(@PathVariable(value = "groupId") int groupId, @PathVariable(value = "semester") int semester){
        List<Schedule> lessons = scheduleService.schedulesByGroupAndSemester(groupId, semester);
        return lessons;
    }

    @GetMapping("/{groupId}/{semester}/{weekday}")
    public List<Schedule> schedulesByGroupAndSemester(@PathVariable(value = "groupId") int groupId, @PathVariable(value = "semester") int semester, @PathVariable(value = "weekday") String weekday){
        List<Schedule> lessons = scheduleService.schedulesByGroupAndSemesterAndWeekday(groupId, semester, weekday);
        return lessons;
    }
}

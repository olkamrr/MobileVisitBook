package com.olkamrr.mobilevisitbook.repositories;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findById(int id);
    List<Schedule> findSchedulesByGroupId(Group group);
    List<Schedule> findSchedulesByGroupIdAndSemester(Group group, int semester);
    List<Schedule> findSchedulesByGroupIdAndSemesterAndWeekday(Group group, int semester, String weekday);
}

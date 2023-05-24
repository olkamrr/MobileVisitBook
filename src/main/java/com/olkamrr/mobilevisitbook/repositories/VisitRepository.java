package com.olkamrr.mobilevisitbook.repositories;

import com.olkamrr.mobilevisitbook.models.Schedule;
import com.olkamrr.mobilevisitbook.models.Student;
import com.olkamrr.mobilevisitbook.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Visit findById(int id);
    List<Visit> findVisitsByLessonIdAndStudentId(Schedule lessonId, Student studentId);
    @Query("SELECT DISTINCT visit.date FROM Visit visit WHERE visit.lessonId = :lessonId")
    List<Date> findDistinctDate(Schedule lessonId);
    List<Visit> findVisitsByLessonIdAndDate(Schedule schedule, Date date);
}

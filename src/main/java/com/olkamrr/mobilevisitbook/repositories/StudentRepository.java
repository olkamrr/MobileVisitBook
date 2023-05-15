package com.olkamrr.mobilevisitbook.repositories;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findById(int id);
    List<Student> findStudentsByGroupId(Group group);
    List<Student> findStudentsByGroupIdOrderByLastNameAsc(Group group);
}

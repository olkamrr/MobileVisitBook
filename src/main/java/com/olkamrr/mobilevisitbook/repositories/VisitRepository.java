package com.olkamrr.mobilevisitbook.repositories;

import com.olkamrr.mobilevisitbook.models.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    Visit findById(int id);
}

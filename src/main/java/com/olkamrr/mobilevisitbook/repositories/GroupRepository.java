package com.olkamrr.mobilevisitbook.repositories;

import com.olkamrr.mobilevisitbook.models.Group;
import com.olkamrr.mobilevisitbook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findById(int id);
    Group findByUser(User user);
}

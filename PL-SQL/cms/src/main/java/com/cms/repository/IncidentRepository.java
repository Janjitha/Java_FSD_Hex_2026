package com.cms.repository;

import com.cms.enums.IncidentType;
import com.cms.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {
    /*
    IncidentRepository now has
    - findAll
    - findById
    - save
    - delete
    * */

    List<Incident> findByIncidentType(IncidentType type);
    /* findBy : select * from Incident where incidentType=? */
}
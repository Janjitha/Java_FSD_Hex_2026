package com.cms.service;

import com.cms.dto.IncidentDto;
import com.cms.dto.IncidentRespDto;
import com.cms.exception.ResourceNotFoundException;
import com.cms.mapper.IncidentMapper;
import com.cms.model.Incident;
import com.cms.repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
To create a bean in spring boot we can use following annotations
for services class use @Service
for repositories , use @Repository
for all other classes including util use @Component
* */
@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final IncidentMapper ticketMapper;

    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }

    public void addIncident(IncidentDto dto) {
        // Map the dto to Entity
        Incident incident = ticketMapper.mapDtoToEntity(dto);
        // Save the Entity
        incidentRepository.save(incident);
    }

    public Incident getById(int id) {
        return incidentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid incident id"));
    }

    public void deleteById(int id) {
        getById(id); // validation
        incidentRepository.deleteById(id);
    }

    public void update(int id, Incident updatedIncident) {
        Incident exisitngIncident = getById(id);
        // set the new values given to existing incident
        exisitngIncident.setIncidentStatus(updatedIncident.getIncidentStatus());
        exisitngIncident.setIncidentType(updatedIncident.getIncidentType());
        exisitngIncident.setProgressDetails(updatedIncident.getProgressDetails());
        incidentRepository.save(exisitngIncident);
    }

    public IncidentRespDto getAllWithPagination(int page, int size) {
        // prepare the Pageable object using PageRequest.
        Pageable pageable =  PageRequest.of(page,size);
        Page<Incident> pages =  incidentRepository.findAll(pageable);
        return ticketMapper.mapEntityTODto(pages);
    }
}
/*
Optional<T> is a wrapper
which says,i may or may not give u T
*/
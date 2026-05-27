package com.cms.service;

import com.cms.dto.IncidentSuspectReqDto;
import com.cms.mapper.IncidentSuspectMapper;
import com.cms.model.Incident;
import com.cms.model.IncidentSuspect;
import com.cms.model.Suspect;
import com.cms.repository.IncidentSuspectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncidentSuspectService {

    private final IncidentService incidentService;
    private final SuspectService suspectService;
    private final IncidentSuspectRepository incidentSuspectRepository;

    public void add(int incidentId, int suspectId, IncidentSuspectReqDto dto) {
        // Step 1: Fetch Incident by given incidentId

        Incident incident = incidentService.getById(incidentId);
        // Step 2: Fetch Suspect by given suspectId

        Suspect suspect = suspectService.getById(suspectId);
        // Step 3: Map dto to IncidentSuspect entity

        IncidentSuspect incidentSuspect =  IncidentSuspectMapper.dtoToEntity(dto);
        // Step 4: attach incident and suspect from step 1 and 2 to IncidentSuspect entity of step 3

        incidentSuspect.setIncident(incident);
        incidentSuspect.setSuspect(suspect);
        // Step 5: save IncidentSuspect entity in DB
        incidentSuspectRepository.save(incidentSuspect);
    }
}
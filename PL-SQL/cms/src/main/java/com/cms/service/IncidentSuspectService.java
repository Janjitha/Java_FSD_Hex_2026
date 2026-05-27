package com.cms.service;

import com.cms.dto.IncidentSuspectReqDto;
import org.springframework.stereotype.Service;

@Service
public class IncidentSuspectService {
    public void add(int incidentId, int suspectId, IncidentSuspectReqDto dto) {
        // Step 1: Fetch Incident by given incidentId

        // Step 2: Fetch Suspect by given suspectId

        // Step 3: Map dto to IncidentSuspect entity

        // Step 4: attach incident and suspect from step 1 and 2 to IncidentSuspect entity of step 3

        // Step 5: save IncidentSuspect entity in DB
    }
}
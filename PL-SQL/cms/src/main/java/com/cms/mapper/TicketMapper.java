package com.cms.mapper;

import com.cms.dto.IncidentDto;
import com.cms.model.Incident;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public Incident mapDtoToEntity(IncidentDto dto){
        Incident incident = new Incident();
        incident.setIncidentType(dto.incidentType());
        incident.setIncidentStatus(dto.incidentStatus());
        incident.setProgressDetails(dto.progressDetails());
        return incident;
    }
}
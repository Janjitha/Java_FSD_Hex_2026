package com.cms.mapper;

import com.cms.dto.SuspectRespDto;
import com.cms.model.Incident;
import com.cms.model.Suspect;
import org.springframework.stereotype.Component;

@Component
public class SuspectMapper {

    public  SuspectRespDto mapEntityToDto(Suspect suspect, Incident incident){
        return new SuspectRespDto(
                incident.getIncidentType(),
                incident.getIncidentStatus(),
                incident.getProgressDetails(),
                suspect.getName(),
                suspect.getContact(),
                suspect.getId()
        );
    }
}
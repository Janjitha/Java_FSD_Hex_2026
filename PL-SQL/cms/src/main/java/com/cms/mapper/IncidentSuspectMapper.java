package com.cms.mapper;

import com.cms.dto.IncidentSuspectReqDto;
import com.cms.model.IncidentSuspect;

public record IncidentSuspectMapper() {

    public static IncidentSuspect dtoToEntity(IncidentSuspectReqDto dto) {
        IncidentSuspect incidentSuspect = new IncidentSuspect();
        incidentSuspect.setDetails(dto.details());
        return incidentSuspect;
    }
}
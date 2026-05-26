package com.cms.service;

import com.cms.dto.IncidentStationDto;
import com.cms.mapper.StationMapper;
import com.cms.model.Incident;
import com.cms.model.Officer;
import com.cms.model.Station;
import com.cms.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StationService {
    private final  IncidentService incidentService;
    private final StationRepository stationRepository;
    private final  OfficerService officerService;

    public IncidentStationDto getStationByIncidentId(int incidentId) {
        Incident incident = incidentService.getById(incidentId);
        Station station = stationRepository.getStationByIncidentId(incidentId);
        // get officer for this incident
        Officer officer = officerService.getByIncidentId(incidentId);

        // convert station to IncidentStationDto
        return StationMapper.fromEntityToDto(station, officer);

    }
}
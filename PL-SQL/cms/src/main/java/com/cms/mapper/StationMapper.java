package com.cms.mapper;

import com.cms.dto.IncidentStationDto;
import com.cms.model.Officer;
import com.cms.model.Station;
import com.cms.service.OfficerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StationMapper {

    public static IncidentStationDto  fromEntityToDto(Station station, Officer officer){

        return new IncidentStationDto(
                station.getId(),
                station.getStationTitle(),
                station.getStationHead().getName(),
                officer.getName()
        );
    }
}
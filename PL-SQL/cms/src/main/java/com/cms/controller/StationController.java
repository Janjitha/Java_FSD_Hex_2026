package com.cms.controller;

import com.cms.dto.IncidentStationDto;
import com.cms.model.Station;
import com.cms.service.StationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/station")
@AllArgsConstructor
public class StationController {

    private final StationService stationService;

    /* Response Structure
        int stationId
        String stationTitle
        String stationHeadName
        String officerName
     * */

    @GetMapping("/by-incident/{incidentId}")
    public IncidentStationDto getStationByIncidentId(@PathVariable int incidentId){
        return stationService.getStationByIncidentId(incidentId);
    }
}

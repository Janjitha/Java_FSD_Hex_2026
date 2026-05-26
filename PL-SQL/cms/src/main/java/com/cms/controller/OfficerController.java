package com.cms.controller;

import com.cms.dto.OfficerResponseDto;
import com.cms.service.OfficerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/officer")
@AllArgsConstructor
public class OfficerController {
    private final OfficerService officerService;

    @GetMapping("/by-station-head")
    public List<OfficerResponseDto> getOfficersByStationHead(@RequestParam  String stationHeadUsername){
        return officerService.getOfficersByStationHead(stationHeadUsername);
    }
}
/*
List of Officers:
    officerId
    officerName
    stationTitle
    stationHeadId
    stationHeadName
* */
package com.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class OfficerController {

    @GetMapping("/api/officer/by-station-head")
    public void getOfficersByStationHead(@RequestParam  String stationHeadUsername){

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
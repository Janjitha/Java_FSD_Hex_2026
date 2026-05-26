package com.cms.service;

import com.cms.dto.OfficerResponseDto;
import com.cms.exception.ResourceNotFoundException;
import com.cms.mapper.OfficerMapper;
import com.cms.model.Officer;
import com.cms.repository.OfficerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfficerService {

    private final OfficerRepository officerRepository;

    public Officer getById(int officerId) {
        return officerRepository.findById(officerId)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Officer ID"));
    }
    public Officer getByUsername(String officerUsername) {
        return officerRepository.findByUserUsername(officerUsername);
    }
    public List<OfficerResponseDto> getOfficersByStationHead(String stationHeadUsername) {
        List<Officer> list = officerRepository.getOfficersByStationHead(stationHeadUsername);
        return list
                .stream()
                .map(OfficerMapper::entityToDto)
                .toList();
    }
    public Officer getByIncidentId(int incidentId) {
        return officerRepository.getByIncidentId(incidentId);
    }
}
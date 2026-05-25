package com.cms.service;

import com.cms.exception.ResourceNotFoundException;
import com.cms.model.Officer;
import com.cms.repository.OfficerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfficerService {

    private final OfficerRepository officerRepository;

    public Officer getById(int officerId) {
        return officerRepository.findById(officerId)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Officer ID"));
    }
}
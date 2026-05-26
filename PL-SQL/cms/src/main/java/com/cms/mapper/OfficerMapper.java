package com.cms.mapper;

import com.cms.dto.OfficerResponseDto;
import com.cms.model.Officer;
import org.springframework.stereotype.Component;

@Component
public class OfficerMapper {

    public static OfficerResponseDto entityToDto(Officer officer){
        return new OfficerResponseDto(
                officer.getId(),
                officer.getName(),
                officer.getStation().getStationTitle(),
                officer.getStation().getStationHead().getId(),
                officer.getStation().getStationHead().getName()
        );
    }
}
package com.cms.dto;

import com.cms.enums.IncidentStatus;
import com.cms.enums.IncidentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IncidentDto(
        @NotNull(message = "This field is mandatory")
        IncidentType incidentType,
        @NotNull(message = "This field is mandatory")
        @NotBlank(message = "This field is mandatory")
        String progressDetails,
        @NotNull
        IncidentStatus incidentStatus
) {
}
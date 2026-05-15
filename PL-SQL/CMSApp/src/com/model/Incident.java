package com.model;

import com.enums.IncidentStatus;
import com.enums.IncidentType;

public class Incident {
    private int id;
    private IncidentType incidentType;
    private String progressDetails;
    private IncidentStatus incidentStatus;

    private Officer officer; //Officer injected in Incident
    // private int officer_id; //<-- wrong..


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public String getProgressDetails() {
        return progressDetails;
    }

    public void setProgressDetails(String progressDetails) {
        this.progressDetails = progressDetails;
    }

    public IncidentStatus getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(IncidentStatus incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", incidentType=" + incidentType +
                ", progressDetails='" + progressDetails + '\'' +
                ", incidentStatus=" + incidentStatus +
                ", officer=" + officer +
                '}';
    }
}

package com.cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "incident_suspect")
@Setter
@Getter
public class IncidentSuspect { //is
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Incident incident; //List<IncidentSuspect> list =  findByIncidentId(incident id)

    @ManyToOne
    private Suspect suspect;

    @Column(length = 500)
    private String details;

    @CreationTimestamp
    private Instant createdAt;
}
package com.intratracker.backend.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busId;
    private double latitude;
    private double longitude;
    @Column(nullable = false)
    private Instant timestamp;
    public Location(String busId, double latitude, double longitude) {}
    public Location(){}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    @PrePersist
    public void prePersist() {
        this.timestamp = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
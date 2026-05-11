package com.intratracker.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime timestamp;
    public Location(String busId, double latitude, double longitude, LocalDateTime timestamp) {}
    public Location(){}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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
        this.timestamp = LocalDateTime.now().withNano(0);
    }
}
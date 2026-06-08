package com.intratracker.backend.dto.request;

import java.time.Instant;
import java.time.LocalDateTime;

public class CreateLocationRequestDTO {

    private String busId;
    private double latitude;
    private double longitude;
    private Instant timestamp;

    public CreateLocationRequestDTO(String busId, double latitude, double longitude, Instant timestamp) {
        this.busId = busId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }
}
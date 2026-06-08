package com.intratracker.backend.dto.response;

import java.time.Instant;

public class LocationResponseDTO {

    private String busId;
    private double latitude;
    private double longitude;
    private Instant timestamp;

    public LocationResponseDTO(String busId, double latitude, double longitude, Instant timestamp) {
        this.busId = busId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }
    public LocationResponseDTO() {
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}


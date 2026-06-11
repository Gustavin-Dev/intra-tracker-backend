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
    private Double latitude;
    private Double longitude;
    private Double velocidade;
    private Integer satelites;
    @Column(name = "gps_Fix")
    private Boolean gpsFix;
    private Double hdop;
    @Column(nullable = false, name = "created_at")
    private Instant createdAt;

    public Location(String busId, double latitude, double longitude) {}
    public Location(){}

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Instant getCreated_at() {
        return createdAt;
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

    public Boolean getGps_fix() {
        return gpsFix;
    }

    public void setGps_fix(Boolean gps_fix) {
        this.gpsFix = gps_fix;
    }

    public Double getHdop() {
        return hdop;
    }

    public void setHdop(Double hdop) {
        this.hdop = hdop;
    }

    public Integer getSatelites() {
        return satelites;
    }

    public void setSatelites(Integer satelites) {
        this.satelites = satelites;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
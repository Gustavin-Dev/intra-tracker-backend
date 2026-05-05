package com.intratracker.backend.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class LocationResponseDTO {

    private String busId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
    public LocationResponseDTO(double latitude, double longitude, LocalDateTime timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

}


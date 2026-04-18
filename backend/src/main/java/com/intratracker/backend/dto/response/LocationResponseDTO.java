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
}
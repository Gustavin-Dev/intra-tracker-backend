package com.intratracker.backend.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateLocationRequestDTO {

    private String busId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
}
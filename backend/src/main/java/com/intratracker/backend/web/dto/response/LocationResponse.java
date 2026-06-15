package com.intratracker.backend.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record LocationResponse(

        Long id,
        Double latitude,
        Double longitude,

        @JsonProperty("created_at")
        Instant createdAt

) {
}

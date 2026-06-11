package com.intratracker.backend.dto.response;

import java.time.Instant;

public record LocationResponse(

        String busId,
        Double latitude,
        Double longitude,
        Instant createdAt

) {
}

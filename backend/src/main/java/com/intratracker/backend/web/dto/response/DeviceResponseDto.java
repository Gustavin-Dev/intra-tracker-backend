package com.intratracker.backend.web.dto.response;

public record DeviceResponseDto(
        Long id,
        Boolean active,
        String DeviceId
) {
}

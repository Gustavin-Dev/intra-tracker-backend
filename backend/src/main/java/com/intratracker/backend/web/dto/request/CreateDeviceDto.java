package com.intratracker.backend.web.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateDeviceDto(

        @NotBlank(message = "Device ID is required")
        @Size(max = 100, message = "Device ID must have at most 100 characters")
        String deviceId,

        @NotBlank(message = "API Key is required")
        @Size(min = 32, max = 255, message = "API Key must be between 32 and 255 characters")
        String apiKey,

        @NotNull(message = "Active status is required")
        Boolean active
) {
}
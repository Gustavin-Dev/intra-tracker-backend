package com.intratracker.backend.exception;

import java.time.Instant;
import java.util.Map;

public record ValidationError(
        int status,
        String error,
        String message,
        Instant timestamp,
        Map<String, String> fieldErrors
) {}

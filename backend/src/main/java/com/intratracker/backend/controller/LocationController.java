package com.intratracker.backend.controller;

import com.intratracker.backend.dto.response.LocationResponseDTO;
import com.intratracker.backend.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/last")
    public ResponseEntity<LocationResponseDTO> getLastLocation() {
        return ResponseEntity.ok(locationService.getLastLocation());
    }
}

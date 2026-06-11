package com.intratracker.backend.controller;

import com.intratracker.backend.dto.request.CreateLocation;
import com.intratracker.backend.dto.response.LocationResponse;
import com.intratracker.backend.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/save")
    public ResponseEntity<LocationResponse> saveLocation(@Valid @RequestBody CreateLocation dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(locationService.saveLocation(dto));
    }

    @GetMapping("/last")
    public ResponseEntity<LocationResponse> getLastLocation() {
        return ResponseEntity.ok(locationService.getLastLocation());
    }
}

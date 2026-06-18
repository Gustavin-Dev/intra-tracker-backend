package com.intratracker.backend.web.controller;

import com.intratracker.backend.application.useCases.LocationUseCases;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.web.dto.request.CreateLocationDto;
import com.intratracker.backend.web.dto.response.LocationResponseDto;
import com.intratracker.backend.web.mappers.LocationMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationUseCases locationService;

    public LocationController(LocationUseCases locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/save")
    public ResponseEntity<LocationResponseDto> saveLocation(@Valid @RequestBody CreateLocationDto dto) {

        Location obj = locationService.saveLocation(LocationMapper.toEntity(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(LocationMapper.toDto(obj));
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "success";
    }
}

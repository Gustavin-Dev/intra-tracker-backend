package com.intratracker.backend.service;

import com.intratracker.backend.dto.response.LocationResponseDTO;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationResponseDTO getLastLocation() {
        Location location = locationRepository
                .findTopByOrderByCreatedAtDesc()
                .orElseThrow(() -> new RuntimeException("Location not found"));

        return new LocationResponseDTO(
                location.getLatitude(),
                location.getLongitude(),
                location.getTimestamp()
        );
    }
}

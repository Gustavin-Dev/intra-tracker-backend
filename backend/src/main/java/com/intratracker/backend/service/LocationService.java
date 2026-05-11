package com.intratracker.backend.service;

import com.intratracker.backend.dto.request.CreateLocationRequestDTO;
import com.intratracker.backend.dto.response.LocationResponseDTO;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.repository.LocationRepository;
import org.springframework.stereotype.Service;


@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationResponseDTO saveLocation(CreateLocationRequestDTO dto){
        Location location = new Location();
        location.setLatitude(dto.getLatitude());
        location.setLongitude(dto.getLongitude());
        location.setTimestamp(dto.getTimestamp());
        location.setBusId(dto.getBusId());

        Location saveLocation = locationRepository.save(location);

        return new LocationResponseDTO(
                saveLocation.getBusId(),
                saveLocation.getLatitude(),
                saveLocation.getLongitude(),
                saveLocation.getTimestamp()
                );
    }

    public LocationResponseDTO getLastLocation() {
        Location location = locationRepository
                .findTopByOrderByTimestampDesc()
                .orElseThrow(() -> new RuntimeException("Location not found"));

        return new LocationResponseDTO(
                location.getBusId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getTimestamp()
                );
    }
}

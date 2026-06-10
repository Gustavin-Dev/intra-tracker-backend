package com.intratracker.backend.service;

import com.intratracker.backend.dto.request.CreateLocationRequestDTO;
import com.intratracker.backend.dto.response.LocationResponseDTO;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.exception.ResourceNotFoundException;
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
        location.setBusId("IntraCampus");

        Location savedLocation = locationRepository.save(location);

        return new LocationResponseDTO(
                savedLocation.getBusId(),
                savedLocation.getLatitude(),
                savedLocation.getLongitude(),
                savedLocation.getTimestamp()
                );
    }

    public LocationResponseDTO getLastLocation() {
        Location location = locationRepository
                .findTopByOrderByTimestampDesc()
                .orElseThrow(() -> new ResourceNotFoundException());


        return new LocationResponseDTO(
                location.getBusId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getTimestamp()
                );
    }
}

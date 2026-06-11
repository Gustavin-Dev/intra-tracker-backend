package com.intratracker.backend.service;

import com.intratracker.backend.dto.request.CreateLocation;
import com.intratracker.backend.dto.response.LocationResponse;
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

    public LocationResponse saveLocation(CreateLocation dto){
        Location location = new Location();
        location.setLatitude(dto.latitude());
        location.setLongitude(dto.longitude());
        location.setHdop(dto.hdop());
        location.setSatelites(dto.satelites());
        location.setVelocidade(dto.velocidade());
        location.setGps_fix(dto.gpsFix());
        location.setBusId("IntraCampus");

        Location savedLocation = locationRepository.save(location);

        return new LocationResponse(
                savedLocation.getBusId(),
                savedLocation.getLatitude(),
                savedLocation.getLongitude(),
                savedLocation.getCreated_at()
                );
    }

    public LocationResponse getLastLocation() {
        Location location = locationRepository
                .findTopByOrderByCreatedAtDesc()
                .orElseThrow(() -> new ResourceNotFoundException("No location found."));


        return new LocationResponse(
                location.getBusId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getCreated_at()
                );
    }
}

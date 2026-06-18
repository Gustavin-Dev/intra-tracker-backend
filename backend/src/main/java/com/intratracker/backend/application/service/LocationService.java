package com.intratracker.backend.application.service;

import com.intratracker.backend.application.useCases.LocationUseCases;
import com.intratracker.backend.entity.Device;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.repository.DeviceRepository;
import com.intratracker.backend.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class LocationService implements LocationUseCases {

    private final LocationRepository locationRepository;
    private final SimpMessagingTemplate messagingTemplate;

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.api.key}")
    private String apiKey;

    public LocationService(LocationRepository locationRepository,
                           SimpMessagingTemplate messagingTemplate) {
        this.locationRepository = locationRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @Transactional
    public Location saveLocation(Location location){
        Location savedLocation = locationRepository.save(location);
        messagingTemplate.convertAndSend("/topic/location", savedLocation);
        return savedLocation;
    }
}

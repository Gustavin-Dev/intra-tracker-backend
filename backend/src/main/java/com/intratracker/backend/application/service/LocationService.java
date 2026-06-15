package com.intratracker.backend.application.service;

import com.intratracker.backend.application.useCases.LocationUseCases;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class LocationService implements LocationUseCases {

    private final LocationRepository locationRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final SimpMessagingTemplate messagingTemplate;



    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.api.key}")
    private String apiKey;


    public LocationService(LocationRepository locationRepository, SimpMessagingTemplate messagingTemplate) {
        this.locationRepository = locationRepository;
        this.messagingTemplate = messagingTemplate;
    }

    public Location saveLocation(Location location){
        Location savedLocation = locationRepository.save(location);
        messagingTemplate.convertAndSend("/topic/location", savedLocation);
        return savedLocation;
    }
}

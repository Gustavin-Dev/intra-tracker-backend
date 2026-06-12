package com.intratracker.backend.application.service;

import com.intratracker.backend.application.useCases.LocationUseCases;
import com.intratracker.backend.web.dto.request.CreateLocation;
import com.intratracker.backend.web.dto.response.LocationResponse;
import com.intratracker.backend.entity.Location;
import com.intratracker.backend.exception.ResourceNotFoundException;
import com.intratracker.backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class LocationService implements LocationUseCases {

    private final LocationRepository locationRepository;
    private final RestTemplate restTemplate = new RestTemplate();



    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.api.key}")
    private String apiKey;


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

        // esse metodo aq n vai servir mais de porra nenhuma 
        String url = supabaseUrl +
                "/rest/v1/localizacoes" +
                "?select=*" +
                "&order=created_at.desc" +
                "&limit=2";

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", apiKey);
        headers.set("Authorization", "Bearer " + apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<LocationResponse[]> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        LocationResponse[].class
                );

        LocationResponse[] locations = response.getBody();
        System.out.println(response.getBody());

        if (locations == null || locations.length == 0) {
            throw new RuntimeException("Nenhuma localização encontrada.");
        }

        return locations[0];
    }
}

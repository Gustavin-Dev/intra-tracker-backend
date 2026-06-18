package com.intratracker.backend.web.mappers;

import com.intratracker.backend.entity.Location;
import com.intratracker.backend.web.dto.request.CreateLocationDto;
import com.intratracker.backend.web.dto.response.LocationResponseDto;

public class LocationMapper {

    private LocationMapper() {
    }

    public static Location toEntity(CreateLocationDto dto) {
        if (dto == null) {
            return null;
        }

        Location location = new Location();

        location.setLatitude(dto.latitude());
        location.setLongitude(dto.longitude());
        location.setVelocidade(dto.velocidade());
        location.setSatelites(dto.satelites());
        location.setGps_fix(dto.gpsFix());
        location.setHdop(dto.hdop());

        return location;
    }

    public static LocationResponseDto toDto(Location location) {
        if (location == null) {
            return null;
        }
        return new LocationResponseDto(
                location.getId(),
                location.getLatitude(),
                location.getLongitude(),
                location.getCreated_at()
        );
    }
}

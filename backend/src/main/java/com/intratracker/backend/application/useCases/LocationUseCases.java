package com.intratracker.backend.application.useCases;

import com.intratracker.backend.web.dto.request.CreateLocation;
import com.intratracker.backend.web.dto.response.LocationResponse;

public interface LocationUseCases {

    public LocationResponse getLastLocation();
    public LocationResponse saveLocation(CreateLocation dto);
}

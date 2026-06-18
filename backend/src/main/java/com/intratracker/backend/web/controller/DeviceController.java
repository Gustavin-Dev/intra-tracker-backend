package com.intratracker.backend.web.controller;


import com.intratracker.backend.application.useCases.DeviceUseCases;
import com.intratracker.backend.entity.Device;
import com.intratracker.backend.web.dto.request.CreateDeviceDto;
import com.intratracker.backend.web.dto.response.DeviceResponseDto;
import com.intratracker.backend.web.mappers.DeviceMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/devices")
public class DeviceController {

    private  final DeviceUseCases deviceUseCases;

    public DeviceController(DeviceUseCases deviceUseCases) {
        this.deviceUseCases = deviceUseCases;
    }

    @PostMapping("/save")
    public ResponseEntity<DeviceResponseDto> saveLocation(@Valid @RequestBody CreateDeviceDto dto) {

        Device obj = deviceUseCases.createDevice(DeviceMapper.toEntity(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(DeviceMapper.toDto(obj));
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "success";
    }
}

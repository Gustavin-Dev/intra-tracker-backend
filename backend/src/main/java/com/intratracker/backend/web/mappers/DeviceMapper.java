package com.intratracker.backend.web.mappers;

import com.intratracker.backend.entity.Device;
import com.intratracker.backend.web.dto.request.CreateDeviceDto;
import com.intratracker.backend.web.dto.response.DeviceResponseDto;

public class DeviceMapper {

    private DeviceMapper() {
    }

    public static Device toEntity(CreateDeviceDto createDeviceDto) {
        if (createDeviceDto == null) {
            return null;
        }
        Device device = new Device();
        device.setDeviceId(createDeviceDto.deviceId());
        device.setActive(createDeviceDto.active());
        device.setApiKey(createDeviceDto.apiKey());
        return device;
    }

    public static DeviceResponseDto toDto(Device device) {

        if (device == null) {
            return null;
        }
        return new DeviceResponseDto(
                device.getId(),
                device.isActive(),
                device.getDeviceId()
        );
    }
}

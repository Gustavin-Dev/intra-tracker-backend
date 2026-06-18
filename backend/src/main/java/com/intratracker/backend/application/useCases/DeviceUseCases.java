package com.intratracker.backend.application.useCases;

import com.intratracker.backend.entity.Device;

import java.util.Optional;

public interface DeviceUseCases {
    Optional<Device> findByDeviceId(String deviceId);
    Device createDevice(Device device);
}

package com.intratracker.backend.application.service;

import com.intratracker.backend.application.useCases.DeviceUseCases;
import com.intratracker.backend.entity.Device;
import com.intratracker.backend.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DeviceService implements DeviceUseCases {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    @Override
    @Transactional
    public Optional<Device> findByDeviceId(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId);
    }

    @Transactional
    @Override
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }
}

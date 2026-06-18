package com.intratracker.backend.component;

import com.intratracker.backend.entity.Device;
import com.intratracker.backend.repository.DeviceRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class DeviceAuthenticationFilter extends OncePerRequestFilter {


    private final DeviceRepository deviceRepository;

    public DeviceAuthenticationFilter(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String path = request.getRequestURI();

        if (!path.startsWith("/api/v1/locations")) {
            filterChain.doFilter(request, response);
            return;
        }

        String deviceId = request.getHeader("device-id");
        String apiKey = request.getHeader("api-key");

        if (deviceId == null || apiKey == null) {
            response.sendError(401, "Missing authentication headers");
            return;
        }

        Device device = deviceRepository
                .findByDeviceId(deviceId)
                .orElse(null);

        if (device == null) {
            response.sendError(401, "Device not found");
            return;
        }

        if (!device.isActive()) {
            response.sendError(403, "Device disabled");
            return;
        }

        if (!device.getApiKey().equals(apiKey)) {
            response.sendError(401, "Invalid API key");
            return;
        }

        Authentication authentication =
                UsernamePasswordAuthenticationToken.authenticated(
                        deviceId,
                        null,
                        List.of()
                );

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);

        System.out.println("Device autenticado: " + deviceId);
        System.out.println(
                SecurityContextHolder.getContext().getAuthentication()
        );

        filterChain.doFilter(request, response);
    }
}

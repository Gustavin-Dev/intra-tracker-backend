package com.intratracker.backend.config;

import com.intratracker.backend.component.DeviceAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final DeviceAuthenticationFilter deviceFilter;

    public SecurityConfig(DeviceAuthenticationFilter deviceFilter) {
        this.deviceFilter = deviceFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/devices/**")
                        .permitAll()

                        .requestMatchers("/api/v1/locations/**")
                        .authenticated()

                        .anyRequest()
                        .permitAll()
                )

                .addFilterBefore(
                        deviceFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }
}
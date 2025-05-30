package com.weatherapp.configs;

import com.weatherapp.repositories.ForecastRepository;
import com.weatherapp.services.impl.ForecastManagementServiceImpl;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ForecastStartup {

    private final ForecastRepository forecastRepository;
    private final ForecastManagementServiceImpl forecastService;

    public ForecastStartup(ForecastRepository forecastRepository, ForecastManagementServiceImpl forecastService) {
        this.forecastRepository = forecastRepository;
        this.forecastService = forecastService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        if (forecastRepository.findAll().isEmpty()) {
            forecastService.insertForecastsIntoDatabase();
        }
    }
}

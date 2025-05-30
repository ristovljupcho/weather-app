package com.weatherapp.configs;

import com.weatherapp.repositories.ForecastRepository;
import com.weatherapp.services.impl.ForecastManagementServiceImpl;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Component that runs logic after the application context is fully initialized.
 * <p>
 * Specifically, it checks if there are any forecasts in the database, and if none are found,
 * it triggers the population of forecast data by calling the service layer.
 */
@Component
public class ForecastStartup {

    private final ForecastRepository forecastRepository;
    private final ForecastManagementServiceImpl forecastService;

    public ForecastStartup(ForecastRepository forecastRepository, ForecastManagementServiceImpl forecastService) {
        this.forecastRepository = forecastRepository;
        this.forecastService = forecastService;
    }

    /**
     * Executes logic after the Spring Boot application has fully started.
     * <p>
     * If no forecast records exist in the database, this method will trigger the service
     * to fetch and insert forecast data into the database.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        if (forecastRepository.findAll().isEmpty()) {
            forecastService.insertForecastsIntoDatabase();
        }
    }
}

package com.weatherapp.controllers;

import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.services.ForecastManagementService;
import com.weatherapp.services.ForecastQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/forecasts")
public class ForecastRESTController {

    private final ForecastManagementService forecastManagementService;
    private final ForecastQueryService forecastQueryService;

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchAndSaveForecasts() {
        forecastManagementService.insertForecastsIntoDatabase();

        return ResponseEntity.ok("Forecasts fetched and saved successfully.");
    }

    @GetMapping("/sunny-days")
    public ResponseEntity<List<CityForecastResponseDTO>> getAllSunnyDays() {
        List<CityForecastResponseDTO> forecasts = forecastQueryService.findWarmDays();

        return ResponseEntity.ok(forecasts);
    }

    @GetMapping("/rainy-days")
    public ResponseEntity<List<CityForecastResponseDTO>> getAllRainyDays() {
        List<CityForecastResponseDTO> forecasts = forecastQueryService.findRainyDays();

        return ResponseEntity.ok(forecasts);
    }
}
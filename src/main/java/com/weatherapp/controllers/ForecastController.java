package com.weatherapp.controllers;

import com.weatherapp.dtos.CityResponseDTO;
import com.weatherapp.entities.Forecast;
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
public class ForecastController {

    private final ForecastManagementService forecastManagementService;
    private final ForecastQueryService findAllForecasts;

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchAndSaveForecasts() {
        forecastManagementService.insertForecastsIntoDatabase();
        return ResponseEntity.ok("Forecasts fetched and saved successfully.");
    }

    @GetMapping("/sunny-days")
    public ResponseEntity<List<CityResponseDTO>> getAllSunnyDays() {
        List<CityResponseDTO> forecasts = findAllForecasts.findWarmDays();
        return ResponseEntity.ok(forecasts);
    }

    @GetMapping("/rainy-days")
    public ResponseEntity<List<CityResponseDTO>> getAllRainyDays() {
        List<CityResponseDTO> forecasts = findAllForecasts.findRainyDays();
        return ResponseEntity.ok(forecasts);
    }
}
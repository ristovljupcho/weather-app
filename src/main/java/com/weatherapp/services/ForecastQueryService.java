package com.weatherapp.services;

import com.weatherapp.dtos.CityForecastResponseDTO;

import java.util.List;

public interface ForecastQueryService {
    List<CityForecastResponseDTO> findWarmDays();

    List<CityForecastResponseDTO> findRainyDays();
}

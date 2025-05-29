package com.weatherapp.services;

import com.weatherapp.dtos.CityResponseDTO;

import java.util.List;

public interface ForecastQueryService {
    List<CityResponseDTO> findWarmDays();

    List<CityResponseDTO> findRainyDays();
}

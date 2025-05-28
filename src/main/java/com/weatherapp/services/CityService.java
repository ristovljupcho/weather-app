package com.weatherapp.services;

import com.weatherapp.dtos.CityResponseDTO;

import java.util.List;

public interface CityService {
    List<CityResponseDTO> findAllCities();
}
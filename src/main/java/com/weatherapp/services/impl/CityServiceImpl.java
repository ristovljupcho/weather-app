package com.weatherapp.services.impl;

import com.weatherapp.converters.CityConverter;
import com.weatherapp.dtos.CityResponseDTO;
import com.weatherapp.repositories.CityRepository;
import com.weatherapp.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    @Override
    public List<CityResponseDTO> findAllCities() {
        return cityRepository.findAll().stream().map(cityConverter::toCityResponseDTO).toList();
    }
}
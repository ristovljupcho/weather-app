package com.weatherapp.converters;

import com.weatherapp.dtos.CityResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CityConverter {
    public CityResponseDTO toCityResponseDTO(City city, List<ForecastResponseDTO> forecasts) {
        UUID id = city.getId();
        String name = city.getName();
        double lat = city.getLat();
        double lon = city.getLon();

        return new CityResponseDTO(id, name, lat, lon, forecasts);
    }
}
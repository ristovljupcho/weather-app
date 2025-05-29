package com.weatherapp.dtos;

import java.util.List;

public record CityForecastResponseDTO(
        String cityName,
        List<ForecastResponseDTO> forecasts
) {
}
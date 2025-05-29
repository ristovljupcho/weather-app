package com.weatherapp.dtos;

import java.util.List;
import java.util.UUID;

public record CityResponseDTO(
        UUID id,
        String name,
        double lat,
        double lon,
        List<ForecastResponseDTO> forecasts
) {
}
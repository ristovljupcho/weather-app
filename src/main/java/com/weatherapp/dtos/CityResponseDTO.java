package com.weatherapp.dtos;

import java.util.UUID;

public record CityResponseDTO(
        UUID id,
        String name,
        double lat,
        double lon
) {
}
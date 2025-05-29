package com.weatherapp.dtos;

import java.time.LocalDate;

public record ForecastResponseDTO(
        LocalDate forecastDate,
        double tempMax,
        String weatherMain
) {
}

package com.weatherapp.converters;

import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.City;
import com.weatherapp.entities.Forecast;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * This class is responsible for providing conversion methods from {@link Forecast} entity to Data Transfer Objects
 * and vice versa.
 */
@Component
public class ForecastConverter {
    /**
     * Converts a {@link Forecast} entity to a {@link ForecastResponseDTO}.
     *
     * @param forecast The {@link Forecast} entity to convert
     * @return a {@link ForecastResponseDTO}
     */
    public ForecastResponseDTO toForecastResponseDTO(Forecast forecast) {
        LocalDate forecastDate = forecast.getForecastDate();
        double tempMax = forecast.getTempMax();
        String weatherMain = forecast.getWeatherMain();

        return new ForecastResponseDTO(forecastDate, tempMax, weatherMain);
    }

    /**
     * Converts a {@link City} entity and a list of {@link ForecastResponseDTO} into a {@link CityForecastResponseDTO}.
     *
     * @param cityName  Name with type {@link String} of the {@link City}
     * @param forecasts List of {@link ForecastResponseDTO} representing the weather forecasts for the city
     * @return a {@link CityForecastResponseDTO} containing city details and its associated forecasts
     */
    public CityForecastResponseDTO toCityResponseDTO(String cityName, List<ForecastResponseDTO> forecasts) {
        return new CityForecastResponseDTO(cityName, forecasts);
    }
}

package com.weatherapp.converters;

import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.City;
import com.weatherapp.entities.Forecast;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class ForecastConverter {
    public ForecastResponseDTO toForecastResponseDTO(Forecast forecast) {
        LocalDate forecastDate = forecast.getForecastDate();
        double tempMax = forecast.getTempMax();
        String weatherMain = forecast.getWeatherMain();

        return new ForecastResponseDTO(forecastDate, tempMax, weatherMain);
    }

    public CityForecastResponseDTO toCityResponseDTO(City city, List<ForecastResponseDTO> forecasts) {
        UUID id = city.getId();
        String name = city.getName();
        double lat = city.getLat();
        double lon = city.getLon();

        return new CityForecastResponseDTO(id, name, lat, lon, forecasts);
    }
}

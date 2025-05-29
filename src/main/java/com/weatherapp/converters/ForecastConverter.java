package com.weatherapp.converters;

import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.Forecast;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ForecastConverter {
    public ForecastResponseDTO toForecastResponseDTO(Forecast forecast) {
        LocalDate forecastDate = forecast.getForecastDate();
        double tempDay = forecast.getTempDay();
        String weatherMain = forecast.getWeatherMain();

        return new ForecastResponseDTO(forecastDate, tempDay, weatherMain);
    }
}

package com.weatherapp.utils;

import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.Forecast;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class ForecastTestData {
    private static final LocalDate DATE = LocalDate.now();
    private static final double TEMP_MAX = 26.50;
    private static final String WEATHER_MAIN = "Clouds";

    public static List<Forecast> getForecasts() {
        Forecast forecast1 = new Forecast(
                UUID.fromString("a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a01"),
                DATE,
                TEMP_MAX,
                WEATHER_MAIN,
                CityTestData.getCity()
        );
        Forecast forecast2 = new Forecast(
                UUID.fromString("a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a02"),
                DATE,
                TEMP_MAX,
                WEATHER_MAIN,
                CityTestData.getCity()
        );
        Forecast forecast3 = new Forecast(
                UUID.fromString("a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a03"),
                DATE,
                TEMP_MAX,
                WEATHER_MAIN,
                CityTestData.getCity()
        );

        return List.of(forecast1, forecast2, forecast3);
    }

    public static List<ForecastResponseDTO> getForecastResponseDTOs() {
        ForecastResponseDTO forecastResponseDTO1 = new ForecastResponseDTO(
                DATE,
                TEMP_MAX,
                WEATHER_MAIN
        );
        ForecastResponseDTO forecastResponseDTO2 = new ForecastResponseDTO(
                DATE,
                TEMP_MAX,
                WEATHER_MAIN
        );
        ForecastResponseDTO forecastResponseDTO3 = new ForecastResponseDTO(
                DATE,
                TEMP_MAX,
                WEATHER_MAIN
        );

        return List.of(forecastResponseDTO1, forecastResponseDTO2, forecastResponseDTO3);
    }

    public static List<CityForecastResponseDTO> getCityForecastResponseDTOs() {
        CityForecastResponseDTO cityForecastResponseDTO = new CityForecastResponseDTO(
                CityTestData.CITY_NAME,
                getForecastResponseDTOs()
        );

        return List.of(cityForecastResponseDTO);
    }

    public static CityForecastResponseDTO getCityForecastResponseDTO() {
        return getCityForecastResponseDTOs().getFirst();
    }
}

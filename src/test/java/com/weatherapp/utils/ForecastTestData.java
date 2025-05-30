package com.weatherapp.utils;

import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.Forecast;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class ForecastTestData {
    private static final LocalDate DATE = LocalDate.now();
    private static final double TEMP_MAX = 26.50;
    private static final String WEATHER_MAIN = "Clouds";

    public static List<Forecast> getForecasts() {
        Forecast forecast1 = new Forecast(
                1L,
                DATE,
                TEMP_MAX,
                WEATHER_MAIN,
                CityTestData.getCity()
        );
        Forecast forecast2 = new Forecast(
                2L,
                DATE,
                TEMP_MAX,
                WEATHER_MAIN,
                CityTestData.getCity()
        );
        Forecast forecast3 = new Forecast(
                3L,
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

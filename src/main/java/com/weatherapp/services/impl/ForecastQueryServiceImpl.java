package com.weatherapp.services.impl;

import com.weatherapp.converters.ForecastConverter;
import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.entities.City;
import com.weatherapp.entities.Forecast;
import com.weatherapp.repositories.CityRepository;
import com.weatherapp.repositories.ForecastRepository;
import com.weatherapp.services.ForecastQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link ForecastQueryService} interface that provides methods to query weather forecasts
 * for specific weather conditions such as warm or rainy days.
 */
@RequiredArgsConstructor
@Service
public class ForecastQueryServiceImpl implements ForecastQueryService {

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ForecastConverter forecastConverter;

    /**
     * Finds all warm day forecasts across cities and groups them by city.
     *
     * @return a list of {@link CityForecastResponseDTO} objects containing forecast information for warm days
     */
    @Override
    public List<CityForecastResponseDTO> findWarmDays() {
        List<Forecast> forecasts = forecastRepository.findWarmDays();
        return getCityForecastResponseDTO(forecasts);
    }

    /**
     * Finds all rainy day forecasts across cities and groups them by city.
     *
     * @return a list of {@link CityForecastResponseDTO} objects containing forecast information for rainy days
     */
    @Override
    public List<CityForecastResponseDTO> findRainyDays() {
        List<Forecast> forecasts = forecastRepository.findRainyDays();
        return getCityForecastResponseDTO(forecasts);
    }

    /**
     * Helper method that transforms a list of forecasts into a list of {@link CityForecastResponseDTO}s,
     * grouped by city.
     *
     * @param forecasts a list of {@link Forecast} entities to convert
     * @return a list of {@link CityForecastResponseDTO} grouped by their respective cities
     */
    private List<CityForecastResponseDTO> getCityForecastResponseDTO(List<Forecast> forecasts) {
        List<City> cities = cityRepository.findAll();
        List<CityForecastResponseDTO> cityForecastResponseDTOS = new ArrayList<>();

        for (City city : cities) {
            Long cityId = city.getId();
            List<Forecast> forecastForCity =
                    forecasts.stream().filter(forecast -> forecast.getCity().getId().equals(cityId)).toList();
            List<ForecastResponseDTO> forecastResponseDTOS =
                    forecastForCity.stream().map(forecastConverter::toForecastResponseDTO).toList();
            String cityName = city.getName();
            CityForecastResponseDTO cityForecastResponseDTO =
                    forecastConverter.toCityResponseDTO(cityName, forecastResponseDTOS);

            cityForecastResponseDTOS.add(cityForecastResponseDTO);
        }

        return cityForecastResponseDTOS;
    }
}
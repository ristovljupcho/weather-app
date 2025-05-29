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

@RequiredArgsConstructor
@Service
public class ForecastQueryServiceImpl implements ForecastQueryService {

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ForecastConverter forecastConverter;

    @Override
    public List<CityForecastResponseDTO> findWarmDays() {
        List<Forecast> forecasts = forecastRepository.findWarmDays();
        return getCityResponseDTOS(forecasts);
    }

    @Override
    public List<CityForecastResponseDTO> findRainyDays() {
        List<Forecast> forecasts = forecastRepository.findRainyDays();
        return getCityResponseDTOS(forecasts);
    }

    private List<CityForecastResponseDTO> getCityResponseDTOS(List<Forecast> forecasts) {
        List<City> cities = cityRepository.findAll();
        List<CityForecastResponseDTO> cityForecastResponseDTOS = new ArrayList<>();
        for (City city : cities) {
            List<Forecast> forecastForCity =
                    forecasts.stream().filter(forecast -> forecast.getCity().equals(city)).toList();
            List<ForecastResponseDTO> forecastResponseDTOS =
                    forecastForCity.stream().map(forecastConverter::toForecastResponseDTO).toList();
            CityForecastResponseDTO cityForecastResponseDTO = forecastConverter.toCityResponseDTO(city, forecastResponseDTOS);

            cityForecastResponseDTOS.add(cityForecastResponseDTO);
        }

        return cityForecastResponseDTOS;
    }
}

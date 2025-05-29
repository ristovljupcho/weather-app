package com.weatherapp.services.impl;

import com.weatherapp.converters.CityConverter;
import com.weatherapp.converters.ForecastConverter;
import com.weatherapp.dtos.CityResponseDTO;
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
    private final CityConverter cityConverter;

    //todo: Add helper method that will pair forecast with the city in DTO and send it to controller.
    @Override
    public List<CityResponseDTO> findWarmDays() {
        List<Forecast> forecasts = forecastRepository.findWarmDays();
        return getCityResponseDTOS(forecasts);
    }

    @Override
    public List<CityResponseDTO> findRainyDays() {
        List<Forecast> forecasts = forecastRepository.findRainyDays();
        return getCityResponseDTOS(forecasts);
    }

    private List<CityResponseDTO> getCityResponseDTOS(List<Forecast> forecasts) {
        List<City> cities = cityRepository.findAll();
        List<CityResponseDTO> cityResponseDTOS = new ArrayList<>();
        for (City city : cities) {
            List<Forecast> forecastForCity =
                    forecasts.stream().filter(forecast -> forecast.getCity().equals(city)).toList();
            List<ForecastResponseDTO> forecastResponseDTOS =
                    forecastForCity.stream().map(forecastConverter::toForecastResponseDTO).toList();
            CityResponseDTO cityResponseDTO = cityConverter.toCityResponseDTO(city, forecastResponseDTOS);

            cityResponseDTOS.add(cityResponseDTO);
        }

        return cityResponseDTOS;
    }
}

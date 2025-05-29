package com.weatherapp.services;

import com.weatherapp.configs.OpenWeatherConfig;
import com.weatherapp.repositories.CityRepository;
import com.weatherapp.repositories.ForecastRepository;
import com.weatherapp.services.impl.ForecastManagementServiceImpl;
import com.weatherapp.utils.CityTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ForecastManagementServiceImplTest {

    @Mock
    private ForecastRepository forecastRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private OpenWeatherConfig openWeatherConfig;

    @InjectMocks
    private ForecastManagementServiceImpl forecastManagementService;

    @Test
    void insertForecastsIntoDatabase_shouldFetchAndSaveForecasts() {
        // given
        String apiKey = System.getenv("API_KEY");
        String path = "http://api.openweathermap.org/data/2.5/forecast/daily";

        given(cityRepository.findAll()).willReturn(CityTestData.getCities());
        given(openWeatherConfig.getUrl()).willReturn(path);
        given(openWeatherConfig.getKey()).willReturn(apiKey);

        // when
        forecastManagementService.insertForecastsIntoDatabase();

        // then
        verify(forecastRepository, times(1)).deleteAll();
        verify(forecastRepository, times(1)).flush();
        verify(forecastRepository, times(1)).saveAll(any());
    }
}
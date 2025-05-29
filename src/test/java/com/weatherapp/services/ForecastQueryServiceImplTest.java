package com.weatherapp.services;

import com.weatherapp.converters.ForecastConverter;
import com.weatherapp.dtos.CityForecastResponseDTO;
import com.weatherapp.dtos.ForecastResponseDTO;
import com.weatherapp.repositories.CityRepository;
import com.weatherapp.repositories.ForecastRepository;
import com.weatherapp.services.impl.ForecastQueryServiceImpl;
import com.weatherapp.utils.CityTestData;
import com.weatherapp.utils.ForecastTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ForecastQueryServiceImplTest {
    @InjectMocks
    private ForecastQueryServiceImpl forecastQueryService;

    @Mock
    private ForecastRepository forecastRepository;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private ForecastConverter forecastConverter;

    @Test
    void findWarmDays_returnsListOfCityForecastResponseDTO() {
        // given
        List<ForecastResponseDTO> forecastResponseDTOS = ForecastTestData.getForecastResponseDTOs();

        given(forecastRepository.findWarmDays()).willReturn(ForecastTestData.getForecasts());
        given(cityRepository.findAll()).willReturn(CityTestData.getCities());
        given(forecastConverter.toForecastResponseDTO(any())).willReturn(forecastResponseDTOS.get(0),
                forecastResponseDTOS.get(1), forecastResponseDTOS.get(2));
        given(forecastConverter.toCityResponseDTO(CityTestData.CITY_NAME, forecastResponseDTOS)).willReturn(
                ForecastTestData.getCityForecastResponseDTO());

        // when
        List<CityForecastResponseDTO> actualResult = forecastQueryService.findWarmDays();

        // then
        assertThat(actualResult).isEqualTo(ForecastTestData.getCityForecastResponseDTOs());
    }

    @Test
    void findRainyDays_returnsListOfCityForecastResponseDTO() {
        // given
        List<ForecastResponseDTO> forecastResponseDTOS = ForecastTestData.getForecastResponseDTOs();

        given(forecastRepository.findRainyDays()).willReturn(ForecastTestData.getForecasts());
        given(cityRepository.findAll()).willReturn(CityTestData.getCities());
        given(forecastConverter.toForecastResponseDTO(any())).willReturn(forecastResponseDTOS.get(0),
                forecastResponseDTOS.get(1), forecastResponseDTOS.get(2));
        given(forecastConverter.toCityResponseDTO(CityTestData.CITY_NAME, forecastResponseDTOS)).willReturn(
                ForecastTestData.getCityForecastResponseDTO());

        // when
        List<CityForecastResponseDTO> actualResult = forecastQueryService.findRainyDays();

        // then
        assertThat(actualResult).isEqualTo(ForecastTestData.getCityForecastResponseDTOs());
    }
}

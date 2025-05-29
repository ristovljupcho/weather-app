package com.weatherapp.controllers;

import com.weatherapp.dtos.CityResponseDTO;
import com.weatherapp.services.ForecastQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ForecastController {

    private final ForecastQueryService forecastQueryService;

    @GetMapping("/forecasts")
    public String showWeather(Model model) {
        List<CityResponseDTO> sunny = forecastQueryService.findWarmDays();
        List<CityResponseDTO> rainy = forecastQueryService.findRainyDays();

        model.addAttribute("sunny", sunny);
        model.addAttribute("rainy", rainy);

        return "forecast-view";
    }
}
package com.weatherapp.controllers;

import com.weatherapp.dtos.CityForecastResponseDTO;
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
        List<CityForecastResponseDTO> warmDays = forecastQueryService.findWarmDays();
        List<CityForecastResponseDTO> rainyDays = forecastQueryService.findRainyDays();

        model.addAttribute("warmDays", warmDays);
        model.addAttribute("rainyDays", rainyDays);

        return "forecast-view";
    }
}
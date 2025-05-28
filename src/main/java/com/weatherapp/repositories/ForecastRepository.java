package com.weatherapp.repositories;

import com.weatherapp.entities.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ForecastRepository extends JpaRepository<Forecast, UUID> {
}

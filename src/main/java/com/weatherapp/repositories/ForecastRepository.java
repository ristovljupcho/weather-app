package com.weatherapp.repositories;

import com.weatherapp.entities.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ForecastRepository extends JpaRepository<Forecast, UUID> {
    @Query("SELECT f FROM Forecast f WHERE f.tempDay >= 25")
    List<Forecast> findWarmDays();

    @Query("SELECT f FROM Forecast f WHERE f.weatherMain IN ('Rain', 'Drizzle', 'Thunderstorm')")
    List<Forecast> findRainyDays();
}
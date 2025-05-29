package com.weatherapp.utils;

import com.weatherapp.entities.City;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@UtilityClass
public class CityTestData {
    public static final String CITY_NAME = "Skopje";

    public List<City> getCities() {
        City city1 = new City(
                UUID.fromString("a1eebc99-9c0b-4ef8-bb6d-6bb9bd380a01"),
                CITY_NAME,
                41.99810,
                21.42540,
                new HashSet<>()
        );

        return List.of(city1);
    }

    public City getCity() {
        return getCities().getFirst();
    }
}

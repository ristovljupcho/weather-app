package com.weatherapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Forecast {
    @Id
    private UUID id;

    private LocalDate forecastDate;

    private LocalDateTime sunrise;

    private LocalDateTime sunset;

    private double tempDay;

    private double tempMin;

    private double tempMax;

    private Double tempNight;

    private Double tempEve;

    private Double tempMorn;

    private Double feelsLikeDay;

    private Double feelsLikeNight;

    private Double feelsLikeEve;

    private Double feelsLikeMorn;

    private Integer pressure;

    private Integer humidity;

    private String weatherMain;

    private String weatherDescription;

    private Double windSpeed;

    private Integer windDeg;

    private Double windGust;

    private Integer clouds;

    private Double pop;

    private Double rain;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
}

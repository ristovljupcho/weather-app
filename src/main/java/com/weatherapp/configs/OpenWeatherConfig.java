package com.weatherapp.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for accessing OpenWeatherMap API properties.
 * <p>
 * This class is populated with values from application properties using the prefix {@code openweathermap.api}. It
 * includes the base URL for the API and the API key.
 */
@Configuration
@ConfigurationProperties(prefix = "openweathermap.api")
@Getter
@Setter
public class OpenWeatherConfig {
    private String url;
    private String key;
}

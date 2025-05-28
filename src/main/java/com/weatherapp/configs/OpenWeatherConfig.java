package com.weatherapp.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "openweathermap.api")
@Getter
@Setter
public class OpenWeatherConfig {
    private String url;
    private String key;
}

package com.challenge.planets.dto;

import com.challenge.planets.domain.Weather;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherDTO {
    private int day;
    private String weather;

    public static WeatherDTO from(Weather weather) {
        return new WeatherDTO(weather.getDay(), weather.getWeather().getName());
    }
}

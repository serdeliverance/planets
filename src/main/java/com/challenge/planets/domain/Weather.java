package com.challenge.planets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {
    private int day;
    private WeatherEnum weather;
}

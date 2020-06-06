package com.challenge.planets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int day;

    @Enumerated(EnumType.STRING)
    private WeatherEnum weather;

    public static Weather of(int day, WeatherEnum weatherEnum) {
        return new Weather(null, day, weatherEnum);
    }
}

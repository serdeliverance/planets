package com.challenge.planets.service;

import com.challenge.planets.domain.Weather;
import com.challenge.planets.domain.Constellation;
import com.challenge.planets.domain.Coordenate;
import com.challenge.planets.domain.Segment;
import com.challenge.planets.util.GeometricUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.challenge.planets.domain.WeatherEnum.*;

@Service
public class WeatherService {

    private static final Coordenate SUN_COORDENATE = new Coordenate(0,0);

    private double maxPerimeter = 0;
    private Optional<Integer> dayMaxRainIntensity = Optional.empty();

    // TODO: update these values in calculate weather
    private int diasSequia = 0;
    private int diasOptimos = 0;

    public Optional<Weather> get(String dia) {
        // TODO: implementar
        return Optional.empty();
    }

    public Weather calculateWeather(Constellation constellation) {
        if (areCollinear(constellation)) {
            return areCollinearWithTheSun(constellation) ? Weather.of(constellation.getDay(), DROUGHT) : Weather.of(constellation.getDay(), OPTIMUS);
        }

        if (isSunInsideTriangle(constellation)) {
            processMaxPerimeter(constellation);
            return Weather.of(constellation.getDay(), RAINING);
        }

        return Weather.of(constellation.getDay(), NORMAL);
    }

    private boolean isSunInsideTriangle(Constellation constellation) {
        Coordenate p1 = constellation.getPlanetCoordenates().get(0);
        Coordenate p2 = constellation.getPlanetCoordenates().get(1);
        Coordenate p3 = constellation.getPlanetCoordenates().get(2);

        return GeometricUtils.isPointInsideTriangle(p1, p2, p3, SUN_COORDENATE);
    }

    private boolean areCollinearWithTheSun(Constellation constellation) {
        Coordenate p1 = constellation.getPlanetCoordenates().get(0);
        Coordenate p2 = constellation.getPlanetCoordenates().get(1);

        return GeometricUtils.areCollinear(p1,p2, SUN_COORDENATE);
    }

    private boolean areCollinear(Constellation constellation) {
        Coordenate p1 = constellation.getPlanetCoordenates().get(0);
        Coordenate p2 = constellation.getPlanetCoordenates().get(1);
        Coordenate p3 = constellation.getPlanetCoordenates().get(2);

        return GeometricUtils.areCollinear(p1,p2,p3);
    }

    private void processMaxPerimeter(Constellation constellation) {
        Coordenate p1 = constellation.getPlanetCoordenates().get(0);
        Coordenate p2 = constellation.getPlanetCoordenates().get(1);
        Coordenate p3 = constellation.getPlanetCoordenates().get(2);

        double perimeter = Segment.of(p1, p2).getMagnitude() + Segment.of(p1,p3).getMagnitude() + Segment.of(p2,p3).getMagnitude();
        if (perimeter > maxPerimeter) {
            dayMaxRainIntensity = Optional.of(constellation.getDay());
            maxPerimeter = perimeter;
        }
    }
}

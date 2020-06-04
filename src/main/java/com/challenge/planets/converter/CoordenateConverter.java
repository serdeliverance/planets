package com.challenge.planets.converter;

import com.challenge.planets.domain.Coordenate;
import com.challenge.planets.domain.Planet;
import com.challenge.planets.util.Utils;

import static java.lang.Math.*;

public class CoordenateConverter {

    public static Coordenate convert(Planet planet, int day) {
        return new Coordenate(Utils.round(planet.getRadius() * cos(toRadians(day * planet.getAngularVelocity() + planet.getInitialDelta())),2),
                Utils.round(planet.getRadius() * sin(toRadians(day * planet.getAngularVelocity())),2));
    }
}

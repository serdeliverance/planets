package com.challenge.planets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Segment {
    private double x;
    private double y;

    public static Segment of(Coordenate a, Coordenate b) {
        return new Segment(b.getX() - a.getX(), b.getY() - a.getY());
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
}

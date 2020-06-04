package com.challenge.planets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planet {
    private String name;
    private double radius;
    private double angularVelocity;
    private double initialDelta;
}
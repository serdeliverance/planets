package com.challenge.planets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double radius;

    @Column(name = "angular_velocity")
    private double angularVelocity;

    @Column(name = "initial_delta")
    private double initialDelta;

    public static Planet of(String name, double radius, double angularVelocity, double initialDelta) {
        return new Planet(null, name, radius, angularVelocity, initialDelta);
    }
}
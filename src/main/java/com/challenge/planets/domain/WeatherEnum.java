package com.challenge.planets.domain;

public enum WeatherEnum {
    DROUGHT("sequia"),
    OPTIMUS("optima"),
    RAINING("lluvia"),
    NORMAL("normal");

    private String name;

    WeatherEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.challenge.planets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Constellation {
    private int day;
    private List<Coordenate> planetCoordenates;
}

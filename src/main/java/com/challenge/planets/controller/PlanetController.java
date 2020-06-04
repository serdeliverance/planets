package com.challenge.planets.controller;

import com.challenge.planets.dto.WeatherDTO;
import com.challenge.planets.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("clima")
public class PlanetController {

    private WeatherService weatherService;

    public PlanetController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<WeatherDTO> get(@RequestParam String day) {
        return weatherService.get(day).map(WeatherDTO::from)
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

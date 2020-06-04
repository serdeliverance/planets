package com.challenge.planets.generator;

import com.challenge.planets.converter.CoordenateConverter;
import com.challenge.planets.domain.Constellation;
import com.challenge.planets.domain.Planet;
import com.challenge.planets.repository.WeatherRepository;
import com.challenge.planets.service.WeatherService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Component
public class WeatherGenerator {

    private WeatherService weatherService;
    private WeatherRepository weatherRepository;

    public WeatherGenerator(WeatherService weatherService, WeatherRepository weatherRepository) {
        this.weatherService = weatherService;
        this.weatherRepository = weatherRepository;
    }

    public void calculateForecast(List<Planet> planets, int period) {
        int limit = period + 1;
        IntStream.range(1, limit)
                .mapToObj(i -> new Constellation(i, planets.stream().map(p -> CoordenateConverter.convert(p,i)).collect(toList())))
                .map(weatherService::calculateWeather)
                .forEach(System.out::println);
                // .forEach(c -> climaRepository.save(c));
    }
}

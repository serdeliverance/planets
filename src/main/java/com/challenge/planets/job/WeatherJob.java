package com.challenge.planets.job;

import com.challenge.planets.domain.Planet;
import com.challenge.planets.generator.WeatherGenerator;
import com.challenge.planets.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class WeatherJob implements CommandLineRunner {

    // TODO delete the following @Value injections when data were retrieved from db
    @Value("${ferengi.angular-velocity}")
    private double ferengAngularVelocity;

    @Value("${ferengi.radius}")
    private double ferengiRadius;

    @Value("${ferengi.initial-delta}")
    private double ferengiInitialDelta;

    @Value("${betasoide.angular-velocity}")
    private double betasoideAngularVelocity;

    @Value("${betasoide.radius}")
    private double betasoideRadius;

    @Value("${betasoide.initial-delta}")
    private double betasoideInitialDelta;

    @Value("${vulcano.angular-velocity}")
    private double vulcanoAngularVelocity;

    @Value("${vulcano.radius}")
    private double vulcanoRadius;

    @Value("${vulcano.initial-delta}")
    private double vulcanoInicialDelta;

    private int years;
    private int daysPerYear;
    private int planetsCount;

    private WeatherService weatherService;
    private WeatherGenerator weatherGenerator;

    public WeatherJob(WeatherService weatherService, WeatherGenerator weatherGenerator, @Value("${years}") int years,
                      @Value("${days-per-year}") int daysPerYear, @Value("${planets-amount}") int planetsCount) {
        this.weatherService = weatherService;
        this.weatherGenerator = weatherGenerator;
        this.years = years;
        this.daysPerYear = daysPerYear;
        this.planetsCount = planetsCount;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("calculate forecast");

        Planet ferengi = new Planet("ferengi", ferengiRadius, ferengAngularVelocity, ferengiInitialDelta);
        Planet betasoide = new Planet("betasoide", betasoideRadius, betasoideAngularVelocity, betasoideInitialDelta);
        Planet vulcano = new Planet("vulcano", vulcanoRadius, vulcanoAngularVelocity, vulcanoInicialDelta);

        log.info("years: {}\nplanets:\n{}\n{}\n{}", years, ferengi, betasoide, vulcano);

        weatherGenerator.calculateForecast(Arrays.asList(ferengi, betasoide, vulcano), years * daysPerYear);
    }
}

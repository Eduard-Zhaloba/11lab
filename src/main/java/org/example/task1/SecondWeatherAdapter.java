package org.example.task1;

public class SecondWeatherAdapter implements MeteoData {
    private SecondWeatherService service;

    public SecondWeatherAdapter(SecondWeatherService service) {
        this.service = service;
    }

    @Override
    public double getTemperatureCelsius() {
        return service.getKelvin() - 273.15;
    }

    @Override
    public double getWindSpeedMs() {
        return service.getWindKmh() / 3.6;
    }

    @Override
    public double getVisibilityMeters() {
        return service.getVisibilityKm() * 1000;
    }
}
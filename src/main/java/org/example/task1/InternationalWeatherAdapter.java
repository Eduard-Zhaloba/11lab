package org.example.task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InternationalWeatherAdapter implements MeteoData {
    private InternationalWeatherService externalService;

    public InternationalWeatherAdapter(InternationalWeatherService externalService) {
        this.externalService = externalService;
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [Адаптер Міжнародного Сервісу] %s%n", time, event);
    }

    @Override
    public double getTemperatureCelsius() {
        log("Конвертація температури: Фаренгейти -> Цельсії");
        return (externalService.fetchTempFahrenheit() - 32) * 5.0 / 9.0;
    }

    @Override
    public double getWindSpeedMs() {
        log("Конвертація вітру: вузли -> м/с");
        return externalService.fetchWindKnots() * 0.514444;
    }

    @Override
    public double getVisibilityMeters() {
        log("Конвертація видимості: милі -> метри");
        return externalService.fetchVisibilityMiles() * 1609.34;
    }
}
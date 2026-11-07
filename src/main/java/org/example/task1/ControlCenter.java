package org.example.task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ControlCenter {
    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [Центр управління] %s%n", time, event);
    }

    public void makeTakeoffDecision(MeteoData data) {
        log("Отримання даних через внутрішній інтерфейс...");
        double temp = data.getTemperatureCelsius();
        double wind = data.getWindSpeedMs();
        double visibility = data.getVisibilityMeters();

        log("Дані для зльоту: " + temp + " °C, вітер " + wind + " м/с, видимість " + visibility + " м");

        if (wind < 15.0 && visibility > 1000) {
            log("РІШЕННЯ: Зліт дозволено.");
        } else {
            log("РІШЕННЯ: Зліт заборонено (погані погодні умови).");
        }
    }
}
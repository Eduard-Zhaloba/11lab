package org.example.task1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class InternationalWeatherService {
    public double fetchTempFahrenheit() {
        log("Віддача температури у Фаренгейтах: 77.0 F");
        return 77.0;
    }

    public double fetchWindKnots() {
        log("Віддача швидкості вітру у вузлах: 20.0 вузлів");
        return 20.0;
    }

    public double fetchVisibilityMiles() {
        log("Віддача видимості у милях: 3.5 миль");
        return 3.5;
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Міжнародний Метеосервіс] " + event);
    }
}
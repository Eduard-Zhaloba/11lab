package org.example.task4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class RealFlightLog implements FlightLog {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static int loadCount = 0;

    private final String flightNumber;
    private final String telemetry;

    public RealFlightLog(String flightNumber) {
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Номер рейсу не задано");
        }
        this.flightNumber = flightNumber;
        log("Завантаження архіву рейсу " + flightNumber + " (дорога операція)...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Завантаження архіву перервано", exception);
        }
        this.telemetry = "Рейс " + flightNumber
                + ": висота 10 500 м, швидкість 820 км/год, температура зовні -48 °C";
        loadCount++;
        log("Архів рейсу " + flightNumber + " завантажено. Усього завантажень: " + loadCount);
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String getTelemetry(UserRole role) {
        log("Повернення телеметрії рейсу " + flightNumber);
        return telemetry;
    }

    public static int getLoadCount() {
        return loadCount;
    }

    private static void log(String event) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT)
                + "] [RealFlightLog] " + event);
    }
}

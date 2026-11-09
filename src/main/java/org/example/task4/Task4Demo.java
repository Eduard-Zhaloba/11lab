package org.example.task4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class Task4Demo {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void run() {
        ReportModule reports = new ReportModule(List.of(
                new FlightLogProxy("PS-101"),
                new FlightLogProxy("PS-102"),
                new FlightLogProxy("PS-103"),
                new FlightLogProxy("PS-104"),
                new FlightLogProxy("PS-105")
        ));

        log("=== Сценарій 1: перегляд п'яти рейсів ===");
        reports.showFlights();
        log("Кількість завантажень з архіву: " + RealFlightLog.getLoadCount());

        log("=== Сценарій 2: диспетчер відкриває PS-101 двічі ===");
        reports.openTelemetry("PS-101", UserRole.DISPATCHER);
        reports.openTelemetry("PS-101", UserRole.DISPATCHER);
        log("Кількість завантажень з архіву: " + RealFlightLog.getLoadCount());

        log("=== Сценарій 3: касир запитує телеметрію ===");
        reports.openTelemetry("PS-102", UserRole.CASHIER);
        log("Кількість завантажень з архіву: " + RealFlightLog.getLoadCount());
    }

    private static void log(String event) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT)
                + "] [Task4Demo] " + event);
    }

    public static void main(String[] args) {
        run();
    }
}

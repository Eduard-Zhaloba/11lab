package org.example.task4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public final class ReportModule {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final List<FlightLog> flightLogs;

    public ReportModule(List<FlightLog> flightLogs) {
        this.flightLogs = List.copyOf(Objects.requireNonNull(flightLogs, "Список рейсів не задано"));
    }

    public void showFlights() {
        log("Список рейсів (без відкриття архівів):");
        for (FlightLog flightLog : flightLogs) {
            log("Рейс " + flightLog.getFlightNumber());
        }
    }

    public void openTelemetry(String flightNumber, UserRole role) {
        for (FlightLog flightLog : flightLogs) {
            if (flightLog.getFlightNumber().equals(flightNumber)) {
                log("Відкриваємо телеметрію рейсу " + flightNumber);
                String telemetry = flightLog.getTelemetry(role);
                if (telemetry != null) {
                    log("Телеметрія: " + telemetry);
                }
                return;
            }
        }
        log("Рейс " + flightNumber + " не знайдено");
    }

    private static void log(String event) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT)
                + "] [ReportModule] " + event);
    }
}

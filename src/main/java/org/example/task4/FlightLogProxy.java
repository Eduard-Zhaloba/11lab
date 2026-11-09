package org.example.task4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class FlightLogProxy implements FlightLog {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final String flightNumber;
    private RealFlightLog realFlightLog;

    public FlightLogProxy(String flightNumber) {
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Номер рейсу не задано");
        }
        this.flightNumber = flightNumber;
        // Справжній архів поки не завантажуємо.
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String getTelemetry(UserRole role) {
        log("Запит телеметрії " + flightNumber + ", роль: " + role);

        if (role != UserRole.DISPATCHER && role != UserRole.FLIGHT_SAFETY) {
            log("Недостатньо прав для перегляду бортового журналу");
            return null;
        }

        if (realFlightLog == null) {
            log("Доступ дозволено. Перший запит: створюємо справжній журнал");
            realFlightLog = new RealFlightLog(flightNumber);
        } else {
            log("Доступ дозволено. Повторний запит: використовуємо завантажений журнал");
        }
        return realFlightLog.getTelemetry(role);
    }

    private static void log(String event) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT)
                + "] [FlightLogProxy] " + event);
    }
}

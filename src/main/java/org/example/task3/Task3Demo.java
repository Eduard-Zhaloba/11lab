package org.example.task3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class Task3Demo {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void log(String source, String event) {
        System.out.println("[" + LocalTime.now().format(TIME_FORMAT) + "] ["
                + source + "] " + event);
    }

    public static void run() {
        CheckInFacade facade = new CheckInFacade();

        log("Task3Demo", "=== Сценарій 1: реєстрація через стійку ===");
        Passenger first = new Passenger("Олена Коваль", "PS-101", "UA123456", true);
        String firstSeat = facade.checkInPassenger(first);

        log("Task3Demo", "=== Сценарій 2: реєстрація через кіоск ===");
        Passenger second = new Passenger("Іван Мельник", "PS-202", "UA654321", false);
        facade.checkInPassenger(second);

        log("Task3Demo", "=== Сценарій 3: повторний друк без реєстрації ===");
        BoardingPassService boardingPassService = new BoardingPassService();
        boardingPassService.printBoardingPass(first, firstSeat);
    }

    public static void main(String[] args) {
        run();
    }
}

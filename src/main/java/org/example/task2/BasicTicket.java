package org.example.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BasicTicket implements Ticket {
    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Базовий квиток] " + event);
    }

    @Override
    public String getDescription() {
        return "Базовий квиток";
    }

    @Override
    public double getCost() {
        log("Отримання базової вартості: 1000.0 грн");
        return 1000.0;
    }
}
package org.example.task1.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PriorityBoarding extends TicketDecorator {
    public PriorityBoarding(Ticket ticket) {
        super(ticket);
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Послуга: Пріоритетна посадка] " + event);
    }

    @Override
    public String getDescription() {
        return wrappedTicket.getDescription() + " + Пріоритетна посадка";
    }

    @Override
    public double getCost() {
        log("Додавання вартості пріоритетної посадки (400.0 грн)");
        return wrappedTicket.getCost() + 400.0;
    }
}
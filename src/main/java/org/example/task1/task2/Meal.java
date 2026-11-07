package org.example.task1.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Meal extends TicketDecorator {
    public Meal(Ticket ticket) {
        super(ticket);
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Послуга: Харчування] " + event);
    }

    @Override
    public String getDescription() {
        return wrappedTicket.getDescription() + " + Харчування";
    }

    @Override
    public double getCost() {
        log("Додавання вартості харчування (200.0 грн)");
        return wrappedTicket.getCost() + 200.0;
    }
}
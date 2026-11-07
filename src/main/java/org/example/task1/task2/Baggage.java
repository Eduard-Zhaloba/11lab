package org.example.task1.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Baggage extends TicketDecorator {
    public Baggage(Ticket ticket) {
        super(ticket);
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Послуга: Багаж] " + event);
    }

    @Override
    public String getDescription() {

        return wrappedTicket.getDescription() + " + Додатковий багаж";
    }

    @Override
    public double getCost() {
        log("Додавання вартості багажу (500.0 грн)");
        return wrappedTicket.getCost() + 500.0;
    }
}
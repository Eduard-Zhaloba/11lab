package org.example.task1.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Insurance extends TicketDecorator {
    public Insurance(Ticket ticket) {
        super(ticket);
    }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Послуга: Страхування] " + event);
    }

    @Override
    public String getDescription() {
        return wrappedTicket.getDescription() + " + Страхування";
    }

    @Override
    public double getCost() {
        log("Додавання вартості страхування (300.0 грн)");
        return wrappedTicket.getCost() + 300.0;
    }
}
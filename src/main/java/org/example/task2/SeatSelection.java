package org.example.task1.task2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SeatSelection extends TicketDecorator {
    public SeatSelection(Ticket ticket) { super(ticket); }

    private void log(String event) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("[" + time + "] [Послуга: Вибір місця] " + event);
    }

    @Override
    public String getDescription() {
        return wrappedTicket.getDescription() + " + Вибір місця";
    }

    @Override
    public double getCost() {
        log("Додавання вартості вибору місця (150.0 грн)");
        return wrappedTicket.getCost() + 150.0;
    }
}
package org.example.task1.task2;

public abstract class TicketDecorator implements Ticket {
    protected final Ticket wrappedTicket;

    public TicketDecorator(Ticket ticket) {
        this.wrappedTicket = ticket;
    }


}
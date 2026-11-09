package org.example.task2;

public abstract class TicketDecorator implements Ticket {
    protected final Ticket wrappedTicket;

    public TicketDecorator(Ticket ticket) {
        this.wrappedTicket = ticket;
    }


}
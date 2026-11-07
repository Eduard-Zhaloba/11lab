package org.example.task1.task2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== СЦЕНАРІЙ 1: Базовий квиток ===");
        Ticket basicTicket = new BasicTicket();
        System.out.println("Опис: " + basicTicket.getDescription());
        System.out.println("Підсумкова вартість: " + basicTicket.getCost() + " грн\n");

        System.out.println("=== СЦЕНАРІЙ 2: Квиток + Багаж + Страхування + Пріоритетна посадка ===");
        Ticket ticketWithServices = new BasicTicket();
        ticketWithServices = new Baggage(ticketWithServices);
        ticketWithServices = new Insurance(ticketWithServices);
        ticketWithServices = new PriorityBoarding(ticketWithServices);

        System.out.println("Опис: " + ticketWithServices.getDescription());
        System.out.println("Підсумкова вартість: " + ticketWithServices.getCost() + " грн\n");

        System.out.println("=== СЦЕНАРІЙ 3: Квиток + Харчування (двічі) + Вибір місця ===");
        Ticket anotherTicket = new BasicTicket();
        anotherTicket = new Meal(anotherTicket);
        anotherTicket = new Meal(anotherTicket);
        anotherTicket = new SeatSelection(anotherTicket);

        System.out.println("Опис: " + anotherTicket.getDescription());
        System.out.println("Підсумкова вартість: " + anotherTicket.getCost() + " грн");
    }
}
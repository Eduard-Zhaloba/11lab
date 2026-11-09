package org.example.task3;

public final class BoardingPassService {
    public void printBoardingPass(Passenger passenger, String seat) {
        if (seat == null || seat.isBlank()) {
            throw new IllegalArgumentException("Для друку талона потрібно вказати місце");
        }
        Task3Demo.log("BoardingPassService", "Надруковано посадковий талон: "
                + passenger.getFullName() + ", рейс " + passenger.getFlightNumber()
                + ", місце " + seat);
    }
}

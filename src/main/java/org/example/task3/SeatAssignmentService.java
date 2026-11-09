package org.example.task3;

public final class SeatAssignmentService {
    private int nextSeat = 1;

    public String assignSeat(Passenger passenger) {
        String seat = nextSeat++ + "A";
        Task3Demo.log("SeatAssignmentService", "Пасажиру " + passenger.getFullName()
                + " призначено місце " + seat);
        return seat;
    }
}

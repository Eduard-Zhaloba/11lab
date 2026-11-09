package org.example.task3;

import java.util.Objects;

public final class CheckInFacade {
    private final DocumentCheckService documentCheckService;
    private final SeatAssignmentService seatAssignmentService;
    private final BaggageService baggageService;
    private final BoardingPassService boardingPassService;
    private final BorderControlService borderControlService;

    public CheckInFacade() {
        documentCheckService = new DocumentCheckService();
        seatAssignmentService = new SeatAssignmentService();
        baggageService = new BaggageService();
        boardingPassService = new BoardingPassService();
        borderControlService = new BorderControlService();
    }

    public String checkInPassenger(Passenger passenger) {
        Objects.requireNonNull(passenger, "Пасажира не задано");
        Task3Demo.log("CheckInFacade", "Початок реєстрації пасажира " + passenger.getFullName());

        documentCheckService.checkDocuments(passenger);
        String seat = seatAssignmentService.assignSeat(passenger);
        baggageService.acceptBaggage(passenger);
        boardingPassService.printBoardingPass(passenger, seat);
        borderControlService.notifyBorderService(passenger);

        Task3Demo.log("CheckInFacade", "Реєстрацію завершено: " + passenger.getFullName());
        return seat;
    }
}

package org.example.task3;

public final class BorderControlService {
    public void notifyBorderService(Passenger passenger) {
        Task3Demo.log("BorderControlService", "Прикордонну службу повідомлено про "
                + "реєстрацію пасажира " + passenger.getFullName()
                + " на рейс " + passenger.getFlightNumber());
    }
}

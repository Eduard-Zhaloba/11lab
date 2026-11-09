package org.example.task3;

public final class BaggageService {
    public void acceptBaggage(Passenger passenger) {
        if (passenger.hasBaggage()) {
            Task3Demo.log("BaggageService", "Прийнято багаж пасажира " + passenger.getFullName());
        } else {
            Task3Demo.log("BaggageService", "Перевірено багаж: пасажир "
                    + passenger.getFullName() + " подорожує без багажу");
        }
    }
}

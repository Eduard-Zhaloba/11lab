package org.example.task3;

public final class Passenger {
    private final String fullName;
    private final String flightNumber;
    private final String documentNumber;
    private final boolean hasBaggage;

    public Passenger(String fullName, String flightNumber, String documentNumber, boolean hasBaggage) {
        if (fullName == null || fullName.isBlank()
                || flightNumber == null || flightNumber.isBlank()
                || documentNumber == null || documentNumber.isBlank()) {
            throw new IllegalArgumentException("Дані пасажира не можуть бути порожніми");
        }
        this.fullName = fullName;
        this.flightNumber = flightNumber;
        this.documentNumber = documentNumber;
        this.hasBaggage = hasBaggage;
    }

    public String getFullName() { return fullName; }
    public String getFlightNumber() { return flightNumber; }
    public String getDocumentNumber() { return documentNumber; }
    public boolean hasBaggage() { return hasBaggage; }
}

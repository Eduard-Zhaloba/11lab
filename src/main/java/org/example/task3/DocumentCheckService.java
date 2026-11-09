package org.example.task3;

public final class DocumentCheckService {
    public void checkDocuments(Passenger passenger) {
        Task3Demo.log("DocumentCheckService", "Перевірено документ "
                + passenger.getDocumentNumber() + " пасажира " + passenger.getFullName());
    }
}

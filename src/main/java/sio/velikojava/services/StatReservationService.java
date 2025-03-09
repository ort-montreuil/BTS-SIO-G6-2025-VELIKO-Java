package sio.velikojava.services;

import sio.velikojava.repositories.StatReservationRepository;

import java.sql.SQLException;

public class StatReservationService {
    StatReservationRepository statReservationRepository;

    public StatReservationService(){
        this.statReservationRepository = new StatReservationRepository();
    }

    public int getAllResa() throws SQLException {
        return statReservationRepository.getAllResa();
    }
}

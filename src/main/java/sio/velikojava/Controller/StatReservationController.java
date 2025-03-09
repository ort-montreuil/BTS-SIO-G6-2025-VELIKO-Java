package sio.velikojava.Controller;

import sio.velikojava.services.StatReservationService;

import java.sql.SQLException;

public class StatReservationController {
    StatReservationService statReservationService;

    public StatReservationController(){
        this.statReservationService = new StatReservationService();
    }

    public int getAllResa() throws SQLException {
        return statReservationService.getAllResa();
    }
}

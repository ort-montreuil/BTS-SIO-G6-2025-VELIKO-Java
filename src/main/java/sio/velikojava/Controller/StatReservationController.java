package sio.velikojava.Controller;

import sio.velikojava.services.StatReservationService;

import java.sql.SQLException;
import java.util.HashMap;

public class StatReservationController {
    StatReservationService statReservationService;

    public StatReservationController(){
        this.statReservationService = new StatReservationService();
    }

    public int getAllResa() throws SQLException {
        return statReservationService.getAllResa();
    }
    public HashMap<String, Integer> getTypeVeloByReservation() throws SQLException {
        return statReservationService.getTypeVeloByReservation();
    }
}

package sio.velikojava.Controller;

import sio.velikojava.services.StatUserService;

import java.sql.SQLException;
import java.util.HashMap;

public class StatUserController {
    StatUserService statUserService;
    public StatUserController() {this.statUserService = new StatUserService();}

    public HashMap<String, Integer> getNbrInscrisByAge() throws SQLException {
        return statUserService.getNbrInscrisByAge();
    }

    public HashMap<String, Integer> getTop10UsersReservations() throws SQLException {
        return statUserService.getTop10UsersReservations();
    }
    public int getAllUsers() throws SQLException {
        return statUserService.getAllUsers();
    }
}

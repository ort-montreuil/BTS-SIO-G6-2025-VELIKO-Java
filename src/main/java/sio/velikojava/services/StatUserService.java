package sio.velikojava.services;

import sio.velikojava.repositories.StatUserRepository;

import java.sql.SQLException;
import java.util.HashMap;

public class StatUserService {
    StatUserRepository statUserRepository;

    public StatUserService(){ this.statUserRepository = new StatUserRepository(); }

    public HashMap<String, Integer> getNbrInscrisByAge() throws SQLException {
        return statUserRepository.getNbrInscrisByAge();
    }

    public HashMap<String, Integer> getTop10UsersReservations() throws SQLException {
        return statUserRepository.getTop10UsersReservations();
    }
    public int getAllUsers() throws SQLException {
        return statUserRepository.getAllUsers();
    }
}

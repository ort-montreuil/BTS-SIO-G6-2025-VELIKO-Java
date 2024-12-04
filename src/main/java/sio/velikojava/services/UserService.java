package sio.velikojava.services;

import sio.velikojava.repositories.UserRepository;

import java.sql.SQLException;

public class UserService {
    private UserRepository velikoRepository;

    public UserService() {
        this.velikoRepository = new UserRepository();
    }

    public Boolean verifierIdentifiants(String email, String password) throws SQLException {
        return velikoRepository.verifierIdentifiants(email, password);
    }
}

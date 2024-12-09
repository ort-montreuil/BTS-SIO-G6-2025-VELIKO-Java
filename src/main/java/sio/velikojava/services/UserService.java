package sio.velikojava.services;

import sio.velikojava.model.User;
import sio.velikojava.repositories.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public Boolean verifierIdentifiants(String email, String password) throws SQLException {
        return userRepository.verifierIdentifiants(email, password);
    }
    public ArrayList<User> getAll() throws SQLException{
        return userRepository.getAll();
    }
    public boolean isBlocked(User user) throws SQLException {
        return userRepository.isBlocked(user);
    }
    public void updateStatusBlock(Integer id) throws SQLException {
        userRepository.updateStatusBlock(id);
    }
    public void updateStatusDeblock(Integer id) throws SQLException {
        userRepository.updateStatusDeblock(id);
    }
    public void supprimerUser(Integer id) throws SQLException {
        userRepository.supprimerUser(id);
    }
    public void renouvellerMdp(Integer id) throws SQLException {
        userRepository.renouvellerMdp(id);
    }
}

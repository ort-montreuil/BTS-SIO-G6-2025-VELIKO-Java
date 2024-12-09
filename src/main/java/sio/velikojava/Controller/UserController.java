package sio.velikojava.Controller;

import sio.velikojava.model.User;
import sio.velikojava.services.UserService;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public Boolean verifierIdentifiants(String email, String password) throws SQLException {
        return userService.verifierIdentifiants(email, password);
    }
    public ArrayList<User> getAll() throws SQLException{
        return userService.getAll();
    }

}

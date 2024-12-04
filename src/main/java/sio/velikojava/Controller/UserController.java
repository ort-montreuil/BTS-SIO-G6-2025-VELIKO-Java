package sio.velikojava.Controller;

import sio.velikojava.services.UserService;

import java.sql.SQLException;

public class UserController {
    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    public Boolean verifierIdentifiants(String email, String password) throws SQLException {
        return userService.verifierIdentifiants(email, password);
    }
}

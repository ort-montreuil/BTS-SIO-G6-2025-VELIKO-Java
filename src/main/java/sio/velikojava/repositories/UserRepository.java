package sio.velikojava.repositories;

import sio.velikojava.tools.DataSourceProvider;
import sio.velikojava.tools.MdpHasher;
import sio.velikojava.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private User user;
    private Connection cnx;

    public UserRepository()
    {
        this.connection = DataSourceProvider.getCnx();
    }

    public Boolean verifierIdentifiants(String email, String enteredPassword) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT email, password\n" +
                "FROM user\n" +
                "WHERE JSON_CONTAINS(roles, '\"ROLE_ADMIN\"') AND email = ?");;
        ps.setString(1, email);
        boolean result = false;
        ResultSet rs = ps.executeQuery();
        MdpHasher  passwordHasher = new MdpHasher();
        while (rs.next()) {
            if (passwordHasher.verifyPassword(rs.getString("password"), enteredPassword) && rs.getString("email").equals(email)) {
                result = true;
            }

        }
        ps.close();
        rs.close();
        return result;
    }
}

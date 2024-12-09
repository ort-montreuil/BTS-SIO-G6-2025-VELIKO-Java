package sio.velikojava.repositories;

import sio.velikojava.tools.DataSourceProvider;
import sio.velikojava.tools.MdpHasher;
import sio.velikojava.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository implements RepositoryInterface<User, Integer>{
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

    @Override
    public void create(User obj) throws SQLException {

    }

    @Override
    public void update(User obj) throws SQLException {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public User get(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT id, email,password, nom, prenom, ville , is_blocked, nouveau_mdp\n" +
                "FROM user\n" +
                "WHERE JSON_LENGTH(user.roles) = 0 and nom != 'anonymous_'");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            users.add(new User(rs.getInt("id"), rs.getString("email"),rs.getString("password"), rs.getString("nom"), rs.getString("prenom"), rs.getString("ville"), rs.getString("is_blocked"), rs.getString("nouveau_mdp")));
        }
        return users;
    }
}

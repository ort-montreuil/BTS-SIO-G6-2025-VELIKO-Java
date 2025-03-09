package sio.velikojava.repositories;

import sio.velikojava.model.User;
import sio.velikojava.tools.DataSourceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatsRepository implements RepositoryInterface{
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public StatsRepository() {this.connection= DataSourceProvider.getCnx();
    }


    public double tempsMoyenTrajet() throws SQLException
    {
        double tempsMoyen = 0;
        ps = connection.prepareStatement("SELECT AVG(TIMESTAMPDIFF(MINUTE, heure_debut, heure_fin)) \n" +
                "AS duree_moyenne \n" +
                "FROM reservation;");
        rs = ps.executeQuery();
        rs.next();
        tempsMoyen = rs.getDouble("duree_moyenne");

        return tempsMoyen;
    }


    public ArrayList<User> nbTrajetParUser() throws SQLException {

        ArrayList<User> nbTrajet = new ArrayList<>();

        ps = connection.prepareStatement("SELECT email_user, COUNT(*) AS nombre_trajets\n" +
                "FROM reservation\n" +
                "GROUP BY email_user\n" +
                "ORDER BY nombre_trajets DESC;");
        rs = ps.executeQuery();

        while (rs.next())
        {
            nbTrajet.add(new User(rs.getString("email_user"), rs.getInt("nombre_trajets")));

        }

        return nbTrajet;
    }


    public ArrayList<User> userAvecLePlusDeReservations() throws SQLException {

        ArrayList<User> nbReserva = new ArrayList<>();

        ps = connection.prepareStatement("SELECT email_user, COUNT(*) AS nombre_reservations\n" +
                "FROM reservation\n" +
                "GROUP BY email_user\n" +
                "HAVING COUNT(*) = (\n" +
                "    SELECT MAX(res_count)\n" +
                "    FROM (SELECT COUNT(*) AS res_count FROM reservation GROUP BY email_user) AS subquery\n" +
                ");");
        rs = ps.executeQuery();

        while (rs.next())
        {
            nbReserva.add(new User(rs.getString("email_user"), rs.getInt("nombre_reservations")));

        }

        return nbReserva;
    }
























    @Override
    public void create(Object obj) throws SQLException {

    }

    @Override
    public void update(Object obj) throws SQLException {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public ArrayList getAll() throws SQLException {
        return null;
    }
}

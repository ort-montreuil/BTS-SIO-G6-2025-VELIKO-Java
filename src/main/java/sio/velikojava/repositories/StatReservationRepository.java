package sio.velikojava.repositories;

import sio.velikojava.tools.DataSourceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class StatReservationRepository{

    private Connection connection;

    public StatReservationRepository() {this.connection= DataSourceProvider.getCnx();
    }

    public int getAllResa() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select count(*)\n" +
                "from reservation\n");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public HashMap<String, Integer> getTypeVeloByReservation() throws SQLException {
        HashMap<String, Integer> typeVeloByReservation = new HashMap<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT reservation.type_velo, COUNT(*)\n" +
                "FROM reservation\n" +
                "WHERE reservation.type_velo != ''\n" +
                "GROUP BY reservation.type_velo\n");
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            typeVeloByReservation.put(resultSet.getString(1), resultSet.getInt(2));

        }
        return typeVeloByReservation;
    }
}

package sio.velikojava.repositories;

import sio.velikojava.tools.DataSourceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}

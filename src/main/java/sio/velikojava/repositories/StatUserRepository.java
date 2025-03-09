package sio.velikojava.repositories;

import sio.velikojava.tools.DataSourceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class StatUserRepository {
    private Connection connection;

    public StatUserRepository() {this.connection= DataSourceProvider.getCnx();
    }

    public HashMap<String, Integer> getNbrInscrisByAge() throws SQLException {
        HashMap<String, Integer> nbrInscrisByAge = new HashMap<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT " +
                        "    SUM(CASE WHEN TIMESTAMPDIFF(YEAR, date_naissance, CURDATE()) BETWEEN 0 AND 17 THEN 1 ELSE 0 END) AS age_0_17, " +
                        "    SUM(CASE WHEN TIMESTAMPDIFF(YEAR, date_naissance, CURDATE()) BETWEEN 18 AND 25 THEN 1 ELSE 0 END) AS age_18_25, " +
                        "    SUM(CASE WHEN TIMESTAMPDIFF(YEAR, date_naissance, CURDATE()) BETWEEN 26 AND 35 THEN 1 ELSE 0 END) AS age_26_35, " +
                        "    SUM(CASE WHEN TIMESTAMPDIFF(YEAR, date_naissance, CURDATE()) BETWEEN 36 AND 50 THEN 1 ELSE 0 END) AS age_36_50, " +
                        "    SUM(CASE WHEN TIMESTAMPDIFF(YEAR, date_naissance, CURDATE()) >= 51 THEN 1 ELSE 0 END) AS age_51_plus " +
                        "FROM user;");
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            nbrInscrisByAge.put("0-17 ans", resultSet.getInt("age_0_17"));
            nbrInscrisByAge.put("18-25 ans", resultSet.getInt("age_18_25"));
            nbrInscrisByAge.put("26-35 ans", resultSet.getInt("age_26_35"));
            nbrInscrisByAge.put("36-50 ans", resultSet.getInt("age_36_50"));
            nbrInscrisByAge.put("51+ ans", resultSet.getInt("age_51_plus"));
        }
        return nbrInscrisByAge;
    }

    public HashMap<String, Integer> getTop10UsersReservations() throws SQLException {
        HashMap<String, Integer> topUsers = new HashMap<>();
        PreparedStatement preparedStatement = connection.prepareStatement("  SELECT user.email, COUNT(reservation.id) AS nb_reservations\n" +
                "                FROM reservation\n" +
                "                JOIN user ON reservation.email_user = user.email\n" +
                "                GROUP BY user.email\n" +
                "                ORDER BY nb_reservations DESC\n" +
                "                LIMIT 10");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
                topUsers.put(resultSet.getString("email"), resultSet.getInt("nb_reservations"));
        }
        return topUsers;
    }

    public int getAllUsers() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(*) \n" +
                "from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

}

package sio.velikojava.repositories;

import sio.velikojava.model.Station;
import sio.velikojava.tools.DataSourceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatStationRepository
{
    private Connection connection;

    public StatStationRepository()
    {
        this.connection = DataSourceProvider.getCnx();
    }


    public int getAllStations() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(*)\n" +
                "from station");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1);
    }

    public String StationLaPlusUtiliseeDepart() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT station.name, COUNT(*)\n" +
                "FROM station\n" +
                "inner join reservation ON reservation.id_station_depart = station.station_id\n" +
                "GROUP by station.name\n" +
                "having count(*)=(\n" +
                "select MAX(nb)\n" +
                "from(\n" +
                "SELECT station.name, COUNT(*) as nb\n" +
                "FROM station\n" +
                "INNER JOIN reservation ON reservation.id_station_depart= station.station_id\n" +
                "GROUP by station.name) as temp)");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }

    public String StationLaPlusUtiliseeArrivee() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT s.name\n" +
                "FROM reservation r \n" +
                "JOIN station s ON r.id_station_arrivee = s.id \n" +
                "GROUP BY s.name \n" +
                "LIMIT 1;");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }

    public ArrayList<Station> getTop10Stations() throws SQLException {
        ArrayList<Station> topStations = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT s.name, COUNT(r.id_station_depart) AS nb_depart\n" +
                "                FROM reservation r\n" +
                "                JOIN station s ON r.id_station_depart = s.id\n" +
                "                GROUP BY s.name\n" +
                "                ORDER BY nb_depart DESC\n" +
                "                LIMIT 10;");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            topStations.add(new Station(resultSet.getString("name"), resultSet.getInt("nb_depart")));
        }
        return topStations;
    }






}

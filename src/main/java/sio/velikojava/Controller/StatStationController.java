package sio.velikojava.Controller;

import sio.velikojava.model.Station;
import sio.velikojava.services.StatStationService;

import java.sql.SQLException;
import java.util.ArrayList;

public class StatStationController {

    StatStationService statStationService;

    public StatStationController()
    {
        this.statStationService = new StatStationService();
    }





    public int getAllStations() throws SQLException
    {
        return statStationService.getAllStations();
    }

    public String StationLaPlusUtilisee () throws SQLException {
        return statStationService.StationLaPlusUtilisee();
    }

    public String StationLaPlusUtiliseeArrivee() throws SQLException {
        return statStationService.StationLaPlusUtiliseeArrivee();
    }

    public ArrayList<Station> getTop10Stations() throws SQLException {
        return statStationService.getTop10Stations();
    }





}

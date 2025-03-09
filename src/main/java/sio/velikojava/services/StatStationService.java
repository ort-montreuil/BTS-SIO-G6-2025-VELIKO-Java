package sio.velikojava.services;

import sio.velikojava.model.Station;
import sio.velikojava.repositories.StatStationRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class StatStationService {

    StatStationRepository statStationRepository;

    public StatStationService()
    {
        this.statStationRepository = new StatStationRepository();
    }


    public int getAllStations() throws SQLException
    {
        return statStationRepository.getAllStations();
    }

    public String StationLaPlusUtilisee () throws SQLException {
        return statStationRepository.StationLaPlusUtiliseeDepart();
    }

    public String StationLaPlusUtiliseeArrivee() throws SQLException {
        return statStationRepository.StationLaPlusUtiliseeArrivee();
    }

    public ArrayList<Station> getTop10Stations() throws SQLException {
        return statStationRepository.getTop10Stations();
    }





}

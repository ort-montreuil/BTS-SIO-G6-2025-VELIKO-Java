package sio.velikojava.services;

import sio.velikojava.repositories.StatsRepository;

import java.sql.SQLException;

public class StatsService
{
    private StatsRepository statsRepository;
    public StatsService()
    {
        this.statsRepository = new StatsRepository();
    }

    public double tempsMoyenTraget() throws SQLException
    {
        return statsRepository.tempsMoyenTraget();
    }



}

package sio.velikojava.Controller;

import sio.velikojava.services.StatsService;

import java.sql.SQLException;

public class StatsController
{
    private StatsService statsService;

    public StatsController()
    {
        this.statsService = new StatsService();
    }

    public double tempsMoyenTrajet() throws SQLException
    {
        return statsService.tempsMoyenTrajet();
    }













}

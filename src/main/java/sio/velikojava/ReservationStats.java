package sio.velikojava;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sio.velikojava.Controller.StatReservationController;
import sio.velikojava.Controller.StatsController;
import sio.velikojava.repositories.StatsRepository;
import sio.velikojava.tools.DataSourceProvider;

import java.sql.SQLException;

public class ReservationStats {

    DataSourceProvider connexion;

    StatReservationController statReservationController;
    StatsController statsController;
    @javafx.fxml.FXML
    private Label lblNbrTotResa;
    @javafx.fxml.FXML
    private Label lblTempsMoyen;
    @javafx.fxml.FXML
    private Label lblNbrTotResa1;

    public void initialize() throws SQLException, ClassNotFoundException {
        connexion = new DataSourceProvider();
        statReservationController = new StatReservationController();
        statsController = new StatsController();



        //Graphique nombre de resa
        lblNbrTotResa.setText(String.valueOf(statReservationController.getAllResa()));

        lblTempsMoyen.setText(String.valueOf(statsController.tempsMoyenTrajet()));



    }

}

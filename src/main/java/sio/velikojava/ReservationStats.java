package sio.velikojava;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sio.velikojava.Controller.StatReservationController;
import sio.velikojava.tools.DataSourceProvider;

import java.sql.SQLException;

public class ReservationStats {

    DataSourceProvider connexion;

    StatReservationController statReservationController;
    @javafx.fxml.FXML
    private Label lblNbrTotResa;

    public void initialize() throws SQLException, ClassNotFoundException {
        connexion = new DataSourceProvider();
        statReservationController = new StatReservationController();


        //Graphique nombre de resa
        lblNbrTotResa.setText(String.valueOf(statReservationController.getAllResa()));


    }

}

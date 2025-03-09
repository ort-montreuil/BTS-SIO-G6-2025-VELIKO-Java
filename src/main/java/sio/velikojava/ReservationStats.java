package sio.velikojava;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
    private PieChart pieChartTypeVelo;

    public void initialize() throws SQLException, ClassNotFoundException {
        connexion = new DataSourceProvider();
        statReservationController = new StatReservationController();
        statsController = new StatsController();


        //Nombre de resa
        lblNbrTotResa.setText(String.valueOf(statReservationController.getAllResa()));

        //Temps moyen
        lblTempsMoyen.setText(String.valueOf(statsController.tempsMoyenTrajet()));


        //Type de velo reservé
        for (String typeVelo : statReservationController.getTypeVeloByReservation().keySet()) {
            PieChart.Data data = new PieChart.Data(typeVelo, statReservationController.getTypeVeloByReservation().get(typeVelo));
            pieChartTypeVelo.getData().add(data);
            for (PieChart.Data entry : data.getChart().getData()) {
                Tooltip t = new Tooltip(entry.getName() + " : " + entry.getPieValue() + "%");
                t.setStyle("-fx-font-weight: bold");
                Tooltip.install(entry.getNode(), t);
            }
        }
    }

}

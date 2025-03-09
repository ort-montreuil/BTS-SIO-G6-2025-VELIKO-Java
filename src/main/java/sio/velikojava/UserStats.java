package sio.velikojava;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import sio.velikojava.Controller.StatUserController;
import sio.velikojava.tools.DataSourceProvider;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserStats {
    @javafx.fxml.FXML
    private PieChart piechartAge;

    DataSourceProvider cnx;
    StatUserController statUserController;
    XYChart.Series<String, Number> seriesTop ;

    private HashMap<String, Integer> dataGraphiqueAge;
    @javafx.fxml.FXML
    private BarChart barChartTopUser;
    @javafx.fxml.FXML
    private Label lblNbrUserTot;

    public void initialize() throws SQLException, ClassNotFoundException {
        cnx = new DataSourceProvider();

        statUserController = new StatUserController();
        piechartAge.getData().clear();

        dataGraphiqueAge = statUserController.getNbrInscrisByAge();

        // Ajouter les données au PieChart
        for (Map.Entry<String, Integer> entry : dataGraphiqueAge.entrySet()) {
            piechartAge.getData().add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }


        // Top 10 Utilisateurs qui ont le plus de réservations
        seriesTop = new XYChart.Series<>();
        seriesTop.setName("Top 10 Utilisateurs");

        // Récupérer les données des top 10 utilisateurs
        HashMap<String, Integer> topUsers = statUserController.getTop10UsersReservations();
        for (Map.Entry<String, Integer> entry : topUsers.entrySet()) {
            seriesTop.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        // Ajouter la série au barChart
        barChartTopUser.getData().clear();
        barChartTopUser.getData().add(seriesTop);


        //Nombre Total Users
       lblNbrUserTot.setText(String.valueOf(statUserController.getAllUsers()));



    }
}

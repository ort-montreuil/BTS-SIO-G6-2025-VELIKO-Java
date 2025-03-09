package sio.velikojava;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sio.velikojava.Controller.StatStationController;
import sio.velikojava.tools.DataSourceProvider;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

public class StationStats implements Initializable {
    @javafx.fxml.FXML
    private Label lblNbrStationTot;

    DataSourceProvider cnx;

    StatStationController statStationController;
    @javafx.fxml.FXML
    private Label lblNbrStationTot1;
    @javafx.fxml.FXML
    private Label lblStationPlusUtil;
    @javafx.fxml.FXML
    private Label lblStationPlusUtil2;
    @javafx.fxml.FXML
    private TableView tvStations;
    @javafx.fxml.FXML
    private TableColumn tcNomStation;
    @javafx.fxml.FXML
    private TableColumn tcNvDep;

    @Deprecated
    public void btnRetourClicked(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("map-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            cnx = new DataSourceProvider();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        statStationController = new StatStationController();


        try {
            lblNbrStationTot.setText(String.valueOf(statStationController.getAllStations()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            lblStationPlusUtil.setText(statStationController.StationLaPlusUtilisee());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            lblStationPlusUtil2.setText(statStationController.StationLaPlusUtiliseeArrivee());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        tcNomStation.setCellValueFactory(new PropertyValueFactory<>("nomStation"));
        tcNvDep.setCellValueFactory(new PropertyValueFactory<>("nbDepart"));
        try {
            tvStations.setItems(FXCollections.observableArrayList(statStationController.getTop10Stations()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
}
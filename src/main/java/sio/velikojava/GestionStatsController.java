package sio.velikojava;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionStatsController
{
    @javafx.fxml.FXML
    private Button btnStatStation;
    @javafx.fxml.FXML
    private Button btnStatReservation;
    @javafx.fxml.FXML
    private Button btnStatUser;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void menuStatClicked(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == btnStatReservation) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reservationStats-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Statistique des Stations");
            stage.setScene(scene);
            stage.show();
        }

        if (actionEvent.getSource() == btnStatUser) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userStats-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Statistique des Stations");
            stage.setScene(scene);
            stage.show();
        }
        if (actionEvent.getSource() == btnStatStation) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stationStats-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Statistique des Stations");
            stage.setScene(scene);
            stage.show();
        }
    }
}
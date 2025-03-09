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
    private Button btnRetour;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void menuStatClicked(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == btnStatReservation) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gestionStats-view.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir la scène actuelle et définir le nouveau contenu
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }

        if (actionEvent.getSource() == btnStatUser) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gestionStats-view.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir la scène actuelle et définir le nouveau contenu
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        if (actionEvent.getSource() == btnStatStation) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gestionStats-view.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir la scène actuelle et définir le nouveau contenu
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
        if (actionEvent.getSource() == btnRetour) {
            // Charger le fichier FXML
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("map-view.fxml"));
            Parent root = fxmlLoader.load();

            // Obtenir la scène actuelle et définir le nouveau contenu
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
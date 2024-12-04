package sio.velikojava;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sio.velikojava.Controller.UserController;
import sio.velikojava.tools.DataSourceProvider;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    DataSourceProvider cnx;
    UserController userController;
    @javafx.fxml.FXML
    private TextField txtLogin;
    @javafx.fxml.FXML
    private Label txtErreur;
    @javafx.fxml.FXML
    private PasswordField txtMotDePasse;
    @javafx.fxml.FXML
    private Button btnConnexion;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            cnx = new DataSourceProvider();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        userController = new UserController();

    }

    @javafx.fxml.FXML
    public void btnConnexionClicked(MouseEvent mouseEvent) {
        if (txtLogin.getText().isEmpty() || txtMotDePasse.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie");
            alert.setContentText("Veuillez remplir tous les champs");
            alert.showAndWait();
        } else {
            try {
                if (userController.verifierIdentifiants(txtLogin.getText(), txtMotDePasse.getText())) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("map-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Hello");
                    stage.setScene(scene);
                    stage.show();
                    ((Stage) btnConnexion.getScene().getWindow()).close();
                    System.out.println("c'est bon");
                } else {
                    System.out.println(userController.verifierIdentifiants(txtLogin.getText(), txtMotDePasse.getText()));
                    System.out.println(txtMotDePasse);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur de connexion");
                    alert.setContentText("Pseudo ou mot de passe incorrect");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
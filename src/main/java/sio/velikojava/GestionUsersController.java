package sio.velikojava;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sio.velikojava.Controller.UserController;
import sio.velikojava.tools.DataSourceProvider;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GestionUsersController implements Initializable {
    @javafx.fxml.FXML
    private TableColumn tcStatut;
    @javafx.fxml.FXML
    private TableColumn tcPrenom;
    @javafx.fxml.FXML
    private Button btnBloquer;
    @javafx.fxml.FXML
    private TableView tvUsers;
    @javafx.fxml.FXML
    private TableColumn tcMdp;
    @javafx.fxml.FXML
    private TableColumn tcId;
    @javafx.fxml.FXML
    private TableColumn tcEmail;
    @javafx.fxml.FXML
    private TableColumn tcVille;
    @javafx.fxml.FXML
    private TableColumn tcNom;
    @javafx.fxml.FXML
    private Button btnSupprimer;
    @javafx.fxml.FXML
    private Button btnModifierMdp;

    DataSourceProvider cnx;
    UserController userController;

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

        tcId.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("emailUser"));
        tcNom.setCellValueFactory(new PropertyValueFactory<>("nomUser"));
        tcPrenom.setCellValueFactory(new PropertyValueFactory<>("prenomUser"));
        tcVille.setCellValueFactory(new PropertyValueFactory<>("villeUser"));
        tcStatut.setCellValueFactory(new PropertyValueFactory<>("statutUser"));
        tcMdp.setCellValueFactory(new PropertyValueFactory<>("renouvellerMdpUser"));

        try {
            tvUsers.setItems(FXCollections.observableList(userController.getAll()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @javafx.fxml.FXML
    public void btnBloquerClicked(Event event) {
    }

    @javafx.fxml.FXML
    public void btnSupprimerClicked(Event event) {
    }

    @javafx.fxml.FXML
    public void tvUsersClicked(Event event) {
    }

    @javafx.fxml.FXML
    public void btnModifierMdpClicked(Event event) {
    }
}

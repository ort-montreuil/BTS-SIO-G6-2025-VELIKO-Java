package sio.velikojava;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sio.velikojava.Controller.UserController;
import sio.velikojava.model.User;
import sio.velikojava.tools.DataSourceProvider;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class GestionUsersController implements Initializable {
    @javafx.fxml.FXML
    private TableColumn tcStatut;
    @javafx.fxml.FXML
    private TableColumn tcPrenom;
    @javafx.fxml.FXML
    private Button btnBloquer;
    @javafx.fxml.FXML
    private TableView<User> tvUsers;
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
    @FXML
    private ImageView imgRetour;

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
        Image image = new Image(getClass().getResource("/images/back.png").toString());

        imgRetour.setImage(image);
    }

    @javafx.fxml.FXML
    public void btnBloquerClicked(Event event) throws SQLException {
        User selectedUser = tvUsers.getSelectionModel().getSelectedItem();
        // Vérification si aucun utilisateur n'est sélectionné
        if (selectedUser == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez sélectionner un utilisateur avant de continuer.");
            alert.showAndWait();
        } else {
            int idUser = selectedUser.getIdUser();

            if (userController.isBlocked(selectedUser)) {

                userController.updateStatusDeblock(idUser);
                userController.updateStatusDeblock(idUser);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                alert.setTitle("");
                alert.setContentText("L'utilisateur a été débloqué avec succès.");
                alert.showAndWait();
            } else {

                userController.updateStatusBlock(idUser);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                alert.setTitle("");
                alert.setContentText("L'utilisateur a été bloqué avec succès.");
                alert.showAndWait();
            }
            // Mise à jour des éléments de la table après modification
            tvUsers.setItems(FXCollections.observableList(userController.getAll()));
        }
    }

    @javafx.fxml.FXML
    public void btnSupprimerClicked(Event event) throws SQLException {
        User selectedUser = tvUsers.getSelectionModel().getSelectedItem();
        if (selectedUser == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez sélectionner un utilisateur avant de continuer.");
            alert.showAndWait();
        } else {
            int selectedUserId = tvUsers.getSelectionModel().getSelectedItem().getIdUser();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Confirmation de suppression");
            alert.setContentText("Voulez-vous vraiment supprimer cet utilisateur ? Attention, cette action est irréversible !");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Exécuter l'action de suppression
                userController.supprimerUser(selectedUserId); // Exemple d'appel au contrôleur
                tvUsers.getItems().remove(tvUsers.getSelectionModel().getSelectedItem()); // Retirer de la liste observable
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                successAlert.setTitle("Succès");
                successAlert.setContentText("L'utilisateur a été supprimé avec succès.");
                successAlert.showAndWait();
            } else {
                // Annuler la suppression
                Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                cancelAlert.setTitle("Annulation");
                cancelAlert.setContentText("Suppression annulée. Aucune modification n'a été effectuée.");
                cancelAlert.showAndWait();
            }
        }
    }

    @javafx.fxml.FXML
    public void btnModifierMdpClicked(Event event) throws SQLException {
        User selectedUser = tvUsers.getSelectionModel().getSelectedItem();
        //System.out.println(selectedUser.getRenouvellerMdpUser() instanceof String);
        if (selectedUser == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("");
            alert.setTitle("Erreur");
            alert.setContentText("Veuillez sélectionner un utilisateur avant de continuer.");
            alert.showAndWait();
        }
        else if (selectedUser.getRenouvellerMdpUser().equals(String.valueOf(1))) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("");
            alert.setTitle("Erreur");
            alert.setContentText("L'utilisateur doit déjà modifier son mot de passe");
            alert.showAndWait();
        }else {
            int idUser = selectedUser.getIdUser();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("");
            alert.setTitle("Confirmation de modification");
            alert.setContentText("Voulez-vous vraiment forcer cet utilisateur à modifier son mot de passe? Attention, cette action est irréversible !");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Exécuter l'action de suppression
                userController.renouvellerMdp(idUser);

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                successAlert.setTitle("Succès");
                successAlert.setContentText("L'utilisateur doit modifié son mot de passe.");
                successAlert.showAndWait();
            } else {
                // Annuler la modification
                Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("");
                cancelAlert.setTitle("Annulation");
                cancelAlert.setContentText("Modification annulée. Aucune modification n'a été effectuée.");
                cancelAlert.showAndWait();
            }
        }
        // Mise à jour des éléments de la table après modification
        tvUsers.setItems(FXCollections.observableList(userController.getAll()));
    }

    @javafx.fxml.FXML
    public void tvUsersClicked(Event event) throws SQLException {
        User selectedUser = tvUsers.getSelectionModel().getSelectedItem();
        if (userController.isBlocked(selectedUser)) {
            btnBloquer.setText("Débloquer");
        } else {
            btnBloquer.setText("Bloquer");
        }
    }

    @FXML
    public void imgRetourClicked(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("map-view.fxml"));
        Parent root = fxmlLoader.load();

        // Obtenir la scène actuelle et définir le nouveau contenu
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

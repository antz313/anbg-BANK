package appli.view;

import appli.MainApp;
import appli.model.Person;
import dao.ConnectDB;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonModifDialog {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField rueField;
    @FXML
    private TextField telField;
    @FXML
    private TextField villeField;
    @FXML
    private TextField mailField;
    private Stage dialogStage;
    private Person person;

    private boolean okClicked = false; public MainApp getMainApp() {
        return mainApp;
    }

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */

    public PersonModifDialog() {

    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;
        nomField.setText(person.getNomClient());
        prenomField.setText(person.getPrenomClient());
        rueField.setText(person.getAdresseClient());
        mailField.setText(person.getMailClient());
        villeField.setText(person.getVilleClient());
        telField.setText(person.getTelClient());
    }


    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.

     */
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public void modifClient() {
        int idClientselect = person.getIdClient();
        String nomClientModif = nomField.getText();
        String prenomClientModif = prenomField.getText();
        String adresseClientModif = rueField.getText();
        String emailClientModif = mailField.getText();
        String telClientModif = telField.getText();
        String villeClientModif = villeField.getText();
        try {
            Connection connexion = ConnectDB.initConnection();
            PreparedStatement addClientDb = connexion.prepareStatement("UPDATE clients SET `nom_client`= ?,`prenom_client`= ?,`ville`= ?,`email`= ?,`tel`= ?,`adresse`= ? WHERE id_client = ? ");

            addClientDb.setString(1, nomClientModif);
            addClientDb.setString(2, prenomClientModif);
            addClientDb.setString(3, villeClientModif);
            addClientDb.setString(4, emailClientModif);
            addClientDb.setString(5, telClientModif);
            addClientDb.setString(6, adresseClientModif);
            addClientDb.setInt(7, idClientselect);
            addClientDb.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dialogStage.close();

    }
}

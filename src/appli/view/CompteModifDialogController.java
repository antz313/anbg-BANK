package appli.view;

import appli.MainApp;
import appli.model.Comptes;
import dao.ConnectDB;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CompteModifDialogController {
    @FXML
    private TextField numField;
    @FXML
    private TextField propField;
    @FXML
    private TextField dateField;
    @FXML
    private TextField soldeField;
    @FXML
    private TextField limitField;
    private Stage dialogStage;
    private Comptes compte;
    private boolean okClicked = false; public MainApp getMainApp() {
        return mainApp;
    }


    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */

    public CompteModifDialogController() {

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
     */  public void setComptes(Comptes compte) {
            this.compte = compte;

        numField.setText(compte.getNum_compte());
        propField.setText(compte.getProprietaire());
        dateField.setPromptText(compte.getDateCreation());
        // int convertSolde = Integer.parseInt(solde.getText());
        soldeField.setText(String.valueOf(compte.getSolde()));
        //String convertRetrait = limiteRetrait.getText();
        limitField.setText(String.valueOf(compte.getLimiteRetrait()));

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
    private void handleCancel()
    {
        dialogStage.close();
    }
    public void modifCompte() {
        int idCompteModif = compte.getIdCompte();
        String numCompteModif = numField.getText();
        String proprioModif = propField.getText();
        String dateCreaModif = dateField.getText();
        Double soldeModif = Double.valueOf(soldeField.getText());
        int limitRetraitModif = Integer.parseInt(limitField.getText());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 = new java.util.Date();

        try {
            date1 = formatter.parse(dateCreaModif);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        java.sql.Date dateSql = new java.sql.Date(date1.getTime());
        System.out.println(idCompteModif);

        try {

            Connection connexion = ConnectDB.initConnection();
            PreparedStatement addCompteDb = connexion.prepareStatement("UPDATE comptes SET `proprietaire`= ?,`date_creation`= ?,`solde`= ?,`limite_retrait`= ?,`num_compte`= ? WHERE id_compte = ?");
            addCompteDb.setString(1, proprioModif);
            addCompteDb.setDate(2, dateSql);
            addCompteDb.setDouble(3, soldeModif);
            addCompteDb.setInt(4, limitRetraitModif);
            addCompteDb.setString(5, numCompteModif);
            addCompteDb.setInt(6, idCompteModif);
            addCompteDb.executeUpdate();
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

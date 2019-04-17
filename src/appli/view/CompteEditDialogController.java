package appli.view;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import appli.MainApp;
import appli.model.Comptes;
import dao.ConnectDB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CompteEditDialogController {
    @FXML
    private TextField  numCompte;
    @FXML
    private TextField proprietaire;
    @FXML
    private TextField dateCrea;
    @FXML
    private TextField solde;
    @FXML
    private TextField limiteRetrait;
    @FXML
    private Button bt_ok;
    @FXML
    private Button bt_cancel;
    private Stage dialogStage;
    // DateCreaConvert est utilis?e pour convertir dateCrea qui es tde type STring en type Date
   // Date dateCreaConvert;
    private MainApp mainApp;
    private boolean okClicked = false; public MainApp getMainApp() {
		return mainApp;
	}
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */

    public CompteEditDialogController() {
		
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
     * Sets the compte to be edited in the dialog.
     *
     * @param compte
     */
    public void setComptes(Comptes compte) {
    //    this.comptes = compte;

        numCompte.setText(compte.getNum_compte());
        proprietaire.setText(compte.getProprietaire());
        dateCrea.setPromptText(compte.getDateCreation());
       // int convertSolde = Integer.parseInt(solde.getText());
       solde.setText(String.valueOf(compte.getSolde()));
       //String convertRetrait = limiteRetrait.getText();
       limiteRetrait.setText(String.valueOf(compte.getLimiteRetrait()));
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
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

  //  Date dateCreaConvert ;
    public void addCompte() {
		
		 String numCompteAdd = numCompte.getText();
	 	 String proprioAdd = proprietaire.getText();
	 	 String dateCreaAdd = dateCrea.getText();
	 	 Double soldeAdd = Double.valueOf(solde.getText());
	 	 int limitRetraitAdd = Integer.parseInt(limiteRetrait.getText()); 
	 	 
	 	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	 	 java.util.Date date1 = new java.util.Date();
	 	 
	 	 try {
			date1 = formatter.parse(dateCreaAdd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	 java.sql.Date dateSql = new java.sql.Date(date1.getTime());
	 	
		try {
		 		Connection connexion = ConnectDB.initConnection();
		 		PreparedStatement addCompteDb = connexion.prepareStatement("INSERT INTO `comptes`(id_compte,`proprietaire`, `date_creation`, `solde`, `limite_retrait`, `num_compte`) VALUES ( Null,?, ?, ?, ?, ?)");	 	
		 		
				addCompteDb.setString(1, proprioAdd);
		 		addCompteDb.setDate(2, dateSql);
		 		addCompteDb.setDouble(3, soldeAdd);
		 		addCompteDb.setInt(4, limitRetraitAdd);
		 		addCompteDb.setString(5, numCompteAdd);
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

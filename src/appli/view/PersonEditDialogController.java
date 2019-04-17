package appli.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import appli.MainApp;
import appli.model.Comptes;
import appli.model.Person;
import dao.ConnectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {
	@FXML
    private TableView<Person> addClientData;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField emailField;

    ObservableList<Person> tousLesClients = FXCollections.observableArrayList();
    ObservableList<Person> certainsClients = FXCollections.observableArrayList();
    ObservableList<Person> listeAddClients = FXCollections.observableArrayList();
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

    public PersonEditDialogController() {
		
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

        firstNameField.setText(person.getNomClient());
        lastNameField.setText(person.getPrenomClient());
        streetField.setText(person.getAdresseClient());
        emailField.setText(person.getMailClient());
        cityField.setText(person.getVilleClient());
        telephoneField.setText(person.getTelClient());
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
 
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNomClient(firstNameField.getText());
            person.setPrenomClient(lastNameField.getText());
            person.setAdresseClient(streetField.getText());
            person.setMailClient(emailField.getText());
            person.setTelClient(telephoneField.getText());
            person.setVilleClient(cityField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }
    
    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
            errorMessage += "No valid phone Number!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(telephoneField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid phone number (must be an integer)!\n";
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

     
     	
     
     

	public void addClient() {
		
		 String nomClientAdd = firstNameField.getText();
	 	 String prenomClientAdd = lastNameField.getText();
	 	 String adresseClientAdd = streetField.getText();
	 	 String emailClientAdd = emailField.getText();
	 	 String telClientAdd = telephoneField.getText();
	 	 String villeClientAdd = cityField.getText();
			
		 	try {
		 		Connection connexion = ConnectDB.initConnection();
		 		PreparedStatement addClientDb = connexion.prepareStatement("INSERT INTO clients(`id_client`, `nom_client`, `prenom_client`, `ville`, `email`, `tel`, `adresse`) VALUES ( NULL, ?, ?, ?, ?, ?, ?)");	 	
		 		
				addClientDb.setString(1, nomClientAdd);
		 		addClientDb.setString(2, prenomClientAdd);
		 		addClientDb.setString(3, villeClientAdd);
		 		addClientDb.setString(4, emailClientAdd);
		 		addClientDb.setString(5, telClientAdd);
		 		addClientDb.setString(6, adresseClientAdd);
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

package appli.view;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.util.StringUtils;

import appli.view.CompteEditDialogController;
import appli.MainApp;
import appli.model.Choices;
import appli.model.Comptes;
import appli.model.Count;
import appli.model.Person;
import appli.model.numCompteChoice;
import dao.ClientDao;
import dao.ConnectDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import appli.model.Operations;
import javafx.scene.control.ChoiceBox;
import appli.model.numCompteChoice;
import appli.model.Choices;

public class PersonOverviewController {
	@FXML
    private TableView<Person> personTable;
	@FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, Integer> idColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private TextField tf_chercheNom;
    @FXML
    private Button bt_cherche;
    @FXML
    private TextField tf_chercheNum;
    @FXML
    private Button bt_cherchNum;
    @FXML
    private Button bt_new;
    @FXML
    private Button bt_modif;
    @FXML
    private Button bt_chercheOpe;
    @FXML
    private TextField tf_chercheOpe;
    @FXML
    private ChoiceBox<String> cb_transac;
    @FXML
    private TextField tf_montant;
    @FXML
    private Button bt_creerOpe;
    @FXML 
    private TextField tf_region;
    @FXML
    private Button bt_region;
    
    ObservableList<Person> tousLesClients = FXCollections.observableArrayList();
    ObservableList<Operations> certainesOpe = FXCollections.observableArrayList();
    ObservableList<Count> certainesStats = FXCollections.observableArrayList();
   
    
    
	@FXML
    private TableView<Comptes> compteTable;
	@FXML
    private TableColumn<Comptes, String> proprietaireCompteColumn;
    @FXML
    private TableColumn<Comptes, String> prenomCompteColumn;
    @FXML
    private TableColumn<Comptes, Integer> idCompteColumn;
    @FXML
    private TableColumn<Comptes, Double> soldeCompteColumn;
    @FXML
    private TableColumn<Comptes, Integer> limiteRetraitColumn;
    @FXML
    private TableColumn<Comptes, String> dateCreationColumn;


    @FXML
    private TableView<Operations> operationTable;
    @FXML
    private TableColumn<Operations, Integer> numOpeCol;
    @FXML
    private TableColumn<Operations, Integer> typeCol;
    @FXML
    private TableColumn<Operations, Double> montantCol;
    @FXML
    private TableColumn<Operations, String> dateCol;
    
    @FXML
    private TableView<Count> statsTable;
    @FXML
    private TableColumn<Count, String> villeCount;
    @FXML
    private TableColumn<Count, String> TypeCount;
    @FXML
    private TableColumn<Count, Integer> calculCount;
   /* @FXML
    private ChoiceBox<Choices> proprietaireChoiceBox;
*/

    ObservableList<Comptes> lstCompteFind = FXCollections.observableArrayList(); 
   // ObservableList<Choices> lstChoices = FXCollections.observableArrayList(); 
   // ObservableList<numCompteChoice> lstNumCompteChoice = FXCollections.observableArrayList();
    ObservableList<Comptes> listVide = FXCollections.observableArrayList();
    int lancement = 0;
    public MainApp getMainApp() {
		return mainApp;
	}
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// Add observable list data to the table
        personTable.setItems(mainApp.getPersonData());
        compteTable.setItems(mainApp.getCompteData());
        operationTable.setItems(mainApp.getOperationsData());

        // Remplissage de la table des operations

      /*  lstChoices.add(new Choices(0, "Selectionner un client"));

        for(Comptes p : mainApp.getCompteData()) {
            lstChoices.add(new Choices(p.getIdCompte(),p.getProprietaire()+" "+p.getNum_compte()));
        }
	*/
	}
   /* public int completeCompteChoice(int id) {
        if(lancement != 0){
            lstNumCompteChoice.removeAll(lstNumCompteChoice);
        }
        for (Comptes c : mainApp.getCompteData()) {
            if (id == c.getIdCompte()) {
                lstNumCompteChoice.add(new numCompteChoice(c.getIdCompte(), c.getNum_compte()));
            }

        }
        if (lstNumCompteChoice.isEmpty() && id!=0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Pas d'opérations");
            alert.setContentText("Le compte selectionné n'a pas d'opérations");
            alert.showAndWait();
            lstNumCompteChoice.add(new numCompteChoice(0, "Selectionner un client"));
            proprietaireChoiceBox.setItems(lstChoices);
            proprietaireChoiceBox.getSelectionModel().select(0);
        }else{
            proprietaireChoiceBox.setItems(lstChoices);
            proprietaireChoiceBox.getSelectionModel().select(0);

        }
        lancement = 1;
        return lancement;
    }
    
    */
	// Reference to the main application.
    private MainApp mainApp;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().prenomClientProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idClientProperty().asObject());
        soldeCompteColumn.setCellValueFactory(cellData -> cellData.getValue().soldeProperty().asObject());
        limiteRetraitColumn.setCellValueFactory(cellData -> cellData.getValue().limiteRetraitProperty().asObject());
        dateCreationColumn.setCellValueFactory(cellData -> cellData.getValue().dateCreationProperty());
        proprietaireCompteColumn.setCellValueFactory(cellData -> cellData.getValue().proprietaireProperty());
        idCompteColumn.setCellValueFactory(cellData -> cellData.getValue().idCompteProperty().asObject());
        numOpeCol.setCellValueFactory(cellData -> cellData.getValue().id_operationProperty().asObject());
        typeCol.setCellValueFactory(cellData -> cellData.getValue().debit_creditProperty().asObject());
        montantCol.setCellValueFactory(cellData -> cellData.getValue().montantProperty().asObject());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().date_operationProperty());
        
        cb_transac.setItems(FXCollections.observableArrayList("Debit","Credit"));
        cb_transac.getSelectionModel().select(0);
        
       
     // Clear person details.
        showPersonDetails(null);
        showOperationsDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
       // proprietaireChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> lancement = completeCompteChoice((proprietaireChoiceBox.getSelectionModel().selectedItemProperty().getValue().getId())));
    }
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getNomClient());
            lastNameLabel.setText(person.getPrenomClient());
            streetLabel.setText(person.getVilleClient());

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
        }
    }
     
    
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            deleteClient();
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
   @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person(1 ,"", "", "", "", "", "");
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
       /* if (okClicked) {
          //  mainApp.getPersonData().add(tempPerson);
        // mainApp.showPersonEditDialog(tempPerson);
        }*/
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonModifDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
        }
    }
	public void chercherClient() {
	    ObservableList<Person> certainsClients = FXCollections.observableArrayList();
		ClientDao dataBd = new ClientDao(); 
		String nomCl = tf_chercheNom.getText();
		ObservableList<Person> personData = dataBd.recupClient();
		for(Person Cl: personData) { 
			if(Cl.getNomClient().contains(nomCl) || Cl.getPrenomClient().contains(nomCl)) {
				certainsClients.add(Cl);
			}
		}
		personTable.setItems(certainsClients);
		
	}
	public void deleteClient() {
			
		 	try {
		 		Connection connexion = ConnectDB.initConnection();
		 		PreparedStatement supprClientDb = connexion.prepareStatement("DELETE FROM clients WHERE id_client = ?");	 	
		 		int selIndex = personTable.getSelectionModel().getSelectedItem().getIdClient();
				supprClientDb.setInt(1, selIndex);
		 		supprClientDb.executeUpdate();	 				
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void chercherCompte() {
		ClientDao dataBd = new ClientDao(); 			
		ObservableList<Comptes> certainsComptes = FXCollections.observableArrayList();
		ObservableList<Comptes> compteData = dataBd.recupComptes();
		String textVide = "";
		//if (Integer.parseInt(tf_chercheNum.getText()) != Integer.parseInt(textVide)) {
			int numCpte = Integer.parseInt(tf_chercheNum.getText());
			for(Comptes Cpt: compteData) {
				if(Cpt.getIdCompte() == numCpte) {
					certainsComptes.add(Cpt);		
				}
			}
		//}		
		compteTable.setItems(certainsComptes);
	}
	
	   @FXML
	    private void handleNewCompte() {
		   	Comptes tempCompte = new Comptes(1, "", "", 0.0, 1, "");
	        boolean okClicked = mainApp.showCompteEditDialog(tempCompte);
	        if (okClicked) {
	          //  mainApp.getPersonData().add(tempPerson);
	        // mainApp.showPersonEditDialog(tempPerson);
	        }
	    }


    @FXML
    private void handleModifCompte() {
        Comptes selectedCompte = compteTable.getSelectionModel().getSelectedItem();
        if (selectedCompte != null) {
            boolean okClicked = mainApp.showCompteModifDialog(selectedCompte);
            if (okClicked) {
                //showCompteDetails(selectedCompte);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No account Selected");
            alert.setContentText("Please select an account in the table.");
            alert.showAndWait();
        }
    }

   private void showOperationsDetails(Operations operations) {
        if (operations != null) {
            // Fill the labels with info from the Operations object.
            numOpeCol.setText(String.valueOf(operations.getId_operation()));
            typeCol.setText(String.valueOf(operations.getDebit_credit()));
            montantCol.setText(String.valueOf(operations.getMontant()));
            dateCol.setText(operations.getDate_operation());

        } else {
            // Operations is null, remove all the text.
            numOpeCol.setText(String.valueOf(""));
            typeCol.setText(String.valueOf(""));
            montantCol.setText(String.valueOf(""));
            dateCol.setText("");
        }
    }

   /* public void chercherOperations() {

        ClientDao dataBd = new ClientDao();
        String id_Compte = tf_chercheOpe.getText();

        ObservableList<Operations> certainesOperations = FXCollections.observableArrayList();
        ObservableList<Operations> opeData = dataBd.recupOperations();

        for(Operations Ope: opeData) {
            if(Ope.getId_compte().contains(id_Compte)) {
                certainesOperations.add(opeData);

            }
        }
        operationTable.setItems(null);
        operationTable.setItems(certainesOperations);



    }
*/

    public void chercherOperations() {
        ClientDao dataBd = new ClientDao();
        int id_Compte = Integer.parseInt(tf_chercheOpe.getText());
        ObservableList<Operations> opeData = dataBd.recupOperations();
        for(Operations Cl: opeData) {
            if(Cl.getId_compte() == id_Compte) {
                certainesOpe.add(Cl);
            }
        }
        operationTable.setItems(certainesOpe);

    }
    
    public void creerOpe() {
    	ClientDao dataBd = new ClientDao();
    	dataBd.addOperation(tf_chercheOpe.getText(),cb_transac.getSelectionModel().getSelectedIndex(), tf_montant.getText()); 
    
    }
    
   public void chercherStats() {
        ClientDao dataBd = new ClientDao();
        int departement = Integer.parseInt(tf_region.getText());
        certainesStats = dataBd.trouveRegion(departement);
    	villeCount.setCellValueFactory(cellData -> cellData.getValue().getVille());
        TypeCount.setCellValueFactory(cellData -> cellData.getValue().getType());
        calculCount.setCellValueFactory(cellData -> cellData.getValue().getNombre().asObject());
        statsTable.setItems(certainesStats);

    }
    
}

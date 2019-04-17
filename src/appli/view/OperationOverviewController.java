package appli.view;

import appli.MainApp;
import appli.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OperationOverviewController {


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
    private TableColumn<Operations, Integer> idCompte ;

    private void showOperationsDetails(Operations operations) {
        if (operations != null) {
            // Fill the labels with info from the person object.
            numOpeCol.setText(String.valueOf(operations.getId_operation()));
            typeCol.setText(String.valueOf(operations.getDebit_credit()));
            dateCol.setText(operations.getDate_operation());
            idCompte.setText(String.valueOf(operations.getId_operation()));



            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Operations is null, remove all the text.
            numOpeCol.setText(String.valueOf(""));
            typeCol.setText(String.valueOf(""));
            dateCol.setText("");
            idCompte.setText(String.valueOf(""));

        }
    }

    ObservableList<Operations> lstOperations = FXCollections.observableArrayList();
    ObservableList<Operations> lstOperationsFind = FXCollections.observableArrayList();
    ObservableList<Operations> listVide = FXCollections.observableArrayList();

    public MainApp getMainApp() {
        return mainApp;
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // Add observable list data to the table
        operationTable.setItems(mainApp.getOperationsData());

    }

    // Reference to the main application.
    private MainApp mainApp;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public OperationOverviewController() {
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */


}

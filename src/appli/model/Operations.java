package appli.model;

import javafx.beans.property.*;

public class Operations {
    private  IntegerProperty id_operation;
    private  IntegerProperty debit_credit;
    private  DoubleProperty montant;
    private  StringProperty date_operation;
    private  IntegerProperty id_compte;

    public Operations(Integer id_operation,Integer debit_credit, Double montant, String date_operation, Integer id_compte) {
        this.id_operation = new SimpleIntegerProperty(id_operation);
        this.debit_credit = new SimpleIntegerProperty(debit_credit);
        this.montant = new SimpleDoubleProperty(montant);
        this.date_operation = new SimpleStringProperty(date_operation);
        this.id_compte = new SimpleIntegerProperty(id_compte);
    }

    public Operations() {
    }

    public int getId_operation() {
        return id_operation.get();
    }

    public IntegerProperty id_operationProperty() {
        return id_operation;
    }

    public void setId_operation(int id_operation) {
        this.id_operation.set(id_operation);
    }

    public int getDebit_credit() {
        return debit_credit.get();
    }

    public IntegerProperty debit_creditProperty() {
        return debit_credit;
    }

    public Operations(IntegerProperty debit_credit) {
        this.debit_credit = debit_credit;
    }

    public void setDebit_credit(int debit_credit) {
        this.debit_credit.set(debit_credit);
    }

    public double getMontant() {
        return montant.get();
    }

    public DoubleProperty montantProperty() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant.set(montant);
    }



    public String getDate_operation() {
        return date_operation.get();
    }

    public StringProperty date_operationProperty() {
        return date_operation;
    }

    public void setDate_operation(String date_operation) {
        this.date_operation.set(date_operation);
    }

    public int getId_compte() {
        return id_compte.get();
    }

    public IntegerProperty id_compteProperty() {
        return id_compte;
    }

    public void setId_compte(int id_compte) {
        this.id_compte.set(id_compte);
    }
}

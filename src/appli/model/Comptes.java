package appli.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Comptes {
	private  IntegerProperty idCompte;
	private  StringProperty proprietaire;
    public 	 StringProperty dateCreation;
    private  DoubleProperty solde;
    private  IntegerProperty limiteRetrait;
    private  StringProperty num_compte;
    private BooleanProperty Type;
    /**
     * Default constructor.
     */
    public Comptes() {
        this(null, null, null, null, null, null);
    }
    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Comptes(Integer idCompte, String proprietaire, String dateCreation, Double solde, Integer limiteRetrait, String num_compte) {
    	this.idCompte = new SimpleIntegerProperty(idCompte);
    	this.proprietaire = new SimpleStringProperty(proprietaire);
        this.dateCreation = new SimpleStringProperty(dateCreation);

        // Some initial dummy data, just for convenient testing.
        this.solde = new SimpleDoubleProperty(solde);
        this.limiteRetrait = new SimpleIntegerProperty(limiteRetrait);
        this.num_compte = new SimpleStringProperty(num_compte);
    }
    
	public Comptes(BooleanProperty type) {
		super();
		Type = type;
	}
	public BooleanProperty getType() {
		return Type;
	}
	public void setType(BooleanProperty type) {
		Type = type;
	}
	public final IntegerProperty idCompteProperty() {
		return this.idCompte;
	}
	
	public final int getIdCompte() {
		return this.idCompteProperty().get();
	}
	
	public final void setIdCompte(final int idCompte) {
		this.idCompteProperty().set(idCompte);
	}
	
	public final StringProperty proprietaireProperty() {
		return this.proprietaire;
	}
	
	public final String getProprietaire() {
		return this.proprietaireProperty().get();
	}
	
	public final void setProprietaire(final String proprietaire) {
		this.proprietaireProperty().set(proprietaire);
	}
	
	public final StringProperty dateCreationProperty() {
		return this.dateCreation;
	}
	
	public final String getDateCreation() {
		return this.dateCreationProperty().get();
	}
	
	public final void setDateCreation(final String dateCreation) {
		this.dateCreationProperty().set(dateCreation);
	}
	
	public final DoubleProperty soldeProperty() {
		return this.solde;
	}
	
	public final double getSolde() {
		return this.soldeProperty().get();
	}
	
	public final void setSolde(final double solde) {
		this.soldeProperty().set(solde);
	}
	
	public final IntegerProperty limiteRetraitProperty() {
		return this.limiteRetrait;
	}
	
	public final int getLimiteRetrait() {
		return this.limiteRetraitProperty().get();
	}
	
	public final void setLimiteRetrait(final int limiteRetrait) {
		this.limiteRetraitProperty().set(limiteRetrait);
	}
	public final StringProperty num_compteProperty() {
		return this.num_compte;
	}
	
	public final String getNum_compte() {
		return this.num_compteProperty().get();
	}
	
	public final void setNum_compte(final String num_compte) {
		this.num_compteProperty().set(num_compte);
	}
	
    
}


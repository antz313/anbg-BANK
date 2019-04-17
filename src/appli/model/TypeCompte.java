package appli.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class TypeCompte {
	private IntegerProperty id_type;
	private StringProperty  nom_type;
	
	public IntegerProperty getId_type() {
		return id_type;
	}
	public void setId_type(IntegerProperty id_type) {
		this.id_type = id_type;
	}
	public StringProperty getNom_type() {
		return nom_type;
	}
	
	public void setNom_type(StringProperty nom_type) {
		this.nom_type = nom_type;
	}
	public TypeCompte(IntegerProperty id_type, StringProperty nom_type) {
		this.id_type = id_type;
		this.nom_type = nom_type;
	}
	public TypeCompte() {
		
	}
	
	
	
}

package appli.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Count {

	private StringProperty ville;
	private StringProperty Type;
	private IntegerProperty nombre;
	private IntegerProperty departement;
	
	public StringProperty getVille() {
		return this.ville;
	}
	public StringProperty getType() {
		return this.Type;
	}

	public IntegerProperty getNombre() {
		return this.nombre;
	}
	public IntegerProperty getDepartement() {
		return this.departement;
	}
	public Count(Integer nombre, String ville, String Type, Integer departement) {
		this.nombre = new SimpleIntegerProperty(nombre);
		this.ville = new SimpleStringProperty(ville);
		this.Type =  new SimpleStringProperty(Type);
		this.departement = new SimpleIntegerProperty(departement);
	}
	public Count(String ville, String Type, Integer nombre) {
		this.nombre = new SimpleIntegerProperty(nombre);
		this.ville = new SimpleStringProperty(ville);
		this.Type =  new SimpleStringProperty(Type);
	}
	

	
	
}

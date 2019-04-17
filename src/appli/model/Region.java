package appli.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Region {

	
	private final IntegerProperty id_region;
    private final IntegerProperty departement;
    private final StringProperty ville;
    private final IntegerProperty id_compte;
	
    
    public IntegerProperty getId_region() {
		return id_region;
	}
	public IntegerProperty getDepartement() {
		return departement;
	}
	public StringProperty getVille() {
		return ville;
	}
	public IntegerProperty getId_compte() {
		return id_compte;
	}
	public Region(IntegerProperty id_region, IntegerProperty departement, StringProperty ville,
			IntegerProperty id_compte) {
		super();
		this.id_region = id_region;
		this.departement = departement;
		this.ville = ville;
		this.id_compte = id_compte;
	}

   
}

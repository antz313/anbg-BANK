package appli.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/* public class Person {
	private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    
    public Person() {
        this(null, null);
    }

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        
        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

	public final StringProperty firstNameProperty() {
		return this.firstName;
	}
	

	public final String getFirstName() {
		return this.firstNameProperty().get();
	}
	

	public final void setFirstName(final String firstName) {
		this.firstNameProperty().set(firstName);
	}

	public final StringProperty lastNameProperty() {
		return this.lastName;
	}
	

	public final String getLastName() {
		return this.lastNameProperty().get();
	}
	

	public final void setLastName(final String lastName) {
		this.lastNameProperty().set(lastName);
	}
	

	public final StringProperty streetProperty() {
		return this.street;
	}
	

	public final String getStreet() {
		return this.streetProperty().get();
	}
	

	public final void setStreet(final String street) {
		this.streetProperty().set(street);
	}
	

	public final IntegerProperty postalCodeProperty() {
		return this.postalCode;
	}
	

	public final int getPostalCode() {
		return this.postalCodeProperty().get();
	}
	

	public final void setPostalCode(final int postalCode) {
		this.postalCodeProperty().set(postalCode);
	}
	

	public final StringProperty cityProperty() {
		return this.city;
	}
	

	public final String getCity() {
		return this.cityProperty().get();
	}
	

	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}
	

	public final ObjectProperty<LocalDate> birthdayProperty() {
		return this.birthday;
	}
	

	public final LocalDate getBirthday() {
		return this.birthdayProperty().get();
	}
	

	public final void setBirthday(final LocalDate birthday) {
		this.birthdayProperty().set(birthday);
	}
	
}
	*/
public class Person {

	private final IntegerProperty idClient;
    private final StringProperty nomClient;
    private final StringProperty prenomClient;
    private final StringProperty adresseClient;
    private final StringProperty villeClient;
    private final StringProperty telClient;
    private final StringProperty mailClient;
    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public Person(Integer idClient, String nomClient, String prenomClient, String adresseClient, String villeClient, String telClient, String mailClient) {
    	this.idClient = new SimpleIntegerProperty(idClient);
    	this.nomClient = new SimpleStringProperty(nomClient);
        this.prenomClient = new SimpleStringProperty(prenomClient);

        // Some initial dummy data, just for convenient testing.
        this.adresseClient = new SimpleStringProperty(adresseClient);
        this.villeClient = new SimpleStringProperty(villeClient);
        this.telClient = new SimpleStringProperty(telClient);
        this.mailClient = new SimpleStringProperty(mailClient);
        
    }

  


	public final StringProperty nomClientProperty() {
		return this.nomClient;
	}
	

	public final String getNomClient() {
		return this.nomClientProperty().get();
	}
	

	public final void setNomClient(final String nomClient) {
		this.nomClientProperty().set(nomClient);
	}

	public final StringProperty prenomClientProperty() {
		return this.prenomClient;
	}
	

	public final String getPrenomClient() {
		return this.prenomClientProperty().get();
	}
	

	public final void setPrenomClient(final String prenomClient) {
		this.prenomClientProperty().set(prenomClient);
	}
	

	public final StringProperty telClientProperty() {
		return this.telClient;
	}
	

	public final String getTelClient() {
		return this.telClientProperty().get();
	}
	

	public final void setTelClient(final String telClient) {
		this.telClientProperty().set(telClient);
	}

	public final StringProperty adresseClientProperty() {
		return this.adresseClient;
	}
	

	public final String getAdresseClient() {
		return this.adresseClientProperty().get();
	}
	

	public final void setAdresseClient(final String adresseClient) {
		this.adresseClientProperty().set(adresseClient);
	}

	public final StringProperty villeClientProperty() {
		return this.villeClient;
	}
	

	public final String getVilleClient() {
		return this.villeClientProperty().get();
	}
	

	public final void setVilleClient(final String villeClient) {
		this.villeClientProperty().set(villeClient);
	}
	

	public final StringProperty mailClientProperty() {
		return this.mailClient;
	}
	

	public final String getMailClient() {
		return this.mailClientProperty().get();
	}
	

	public final void setMailClient(final String mailClient) {
		this.mailClientProperty().set(mailClient);
	}

	public final IntegerProperty idClientProperty() {
		return this.idClient;
	}
	

	public final int getIdClient() {
		return this.idClientProperty().get();
	}
	

	public final void setIdClient(final int idClient) {
		this.idClientProperty().set(idClient);
	}
	
	
	
	
	
}


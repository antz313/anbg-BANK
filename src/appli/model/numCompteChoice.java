package appli.model;

public class numCompteChoice {
	Integer id;
	String displayString; 
	
	public numCompteChoice () {
		
	}
	
	public numCompteChoice (Integer id, String string) {
		this.id = id;
		this.displayString = string;
	}
	
	@Override 
	public String toString(){ 
		return displayString; 
		}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }
}
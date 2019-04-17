package appli.model;

public class Choices {
	Integer id;
	String displayString;
	
	public Choices() {
		
	}
	public Choices(Integer id, String string) {
		this.id = id;
		this.displayString = string;
	}
	@Override
	public String toString() {
		return displayString;
	}
	public int getId() {
		return id;
	}
	public String getDisplayString() {
		return displayString;
	}
	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}

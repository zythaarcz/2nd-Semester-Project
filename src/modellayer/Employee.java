package modellayer;

public class Employee extends Person{

	private String position;

	public Employee(String firstName, String lastName, String phoneNumber, String email, String position) {
		super(firstName, lastName, phoneNumber, email, PersonTypes.Employee);
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}

	
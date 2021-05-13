package modellayer;

public class Person {

	private int id;


	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private PersonTypes personType;
	
	public Person(String firstName, String lastName, String phoneNumber, String email, String personType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		setPersonType(personType);
	}
	
	public Person(String firstName, String lastName, String phoneNumber, String email, PersonTypes type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.personType = personType;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPersonType(String personType) {
		this.personType = PersonTypes.valueOf(personType);
	}
	public void setPersonType(PersonTypes type) {
		this.personType = type;
	}
		
	public PersonTypes getPersonType() {
		return this.personType;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

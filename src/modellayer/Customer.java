package modellayer;

import java.util.Date;

public class Customer extends Person {
	
	private String address;
	private String company;
	private Date dateOfBirth;
	private String healthIssue;
	private String timeToRemind;

	public Customer(String firstName, String lastName, String phoneNumber, String email, String password, String address, String company,
			Date dateOfBirth, String healthIssue, String timeToRemind) {
		super(firstName, lastName, phoneNumber, email, password);
		this.address = address;
		this.company = company;
		this.dateOfBirth = dateOfBirth;
		this.healthIssue = healthIssue;
		this.timeToRemind = timeToRemind;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHealthIssue() {
		return healthIssue;
	}

	public void setHealthIssue(String healthIssue) {
		this.healthIssue = healthIssue;
	}

	public String getTimeToRemind() {
		return timeToRemind;
	}

	public void setTimeToRemind(String timeToRemind) {
		this.timeToRemind = timeToRemind;
	}

}

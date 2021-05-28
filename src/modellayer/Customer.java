package modellayer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer extends Person {
	
	private String address;
	private String company;
	private LocalDate dateOfBirth;
	private String healthIssue;
	private String timeToRemind;
	
	private ArrayList<Video> listOfWatchedVideos;

	public Customer(String firstName, String lastName, String phoneNumber, String email, String address, String company,
			LocalDate dateOfBirth, String healthIssue, String timeToRemind) {
		super(firstName, lastName, phoneNumber, email, PersonTypes.Customer);
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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
	
	public ArrayList<Video> getListOfWatchedVideos() {
		return listOfWatchedVideos;
	}

	public void setListOfWatchedVideos(ArrayList<Video> listOfWatchedVideos) {
		this.listOfWatchedVideos = listOfWatchedVideos;
	}
}

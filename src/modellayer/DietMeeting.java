package modellayer;

import java.time.LocalDate;

public class DietMeeting {
	
	private LocalDate wantedDate;
	private String reason;
	private Customer customer;
	private Employee employee;
	private int id;
	
	public DietMeeting(LocalDate wantedDate, String reason) {
		this.wantedDate = wantedDate;
		this.reason = reason;
	}

	public LocalDate getWantedDate() {
		return wantedDate;
	}

	public void setWantedDate(LocalDate wantedDate) {
		this.wantedDate = wantedDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

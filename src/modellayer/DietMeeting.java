package modellayer;

import java.util.Date;

public class DietMeeting {
	
	private Date wantedDate;
	private String reason;
	private Customer customer;
	private Employee employee;
	
	public DietMeeting(Date wantedDate, String reason, Customer customer, Employee employee) {
		this.wantedDate = wantedDate;
		this.reason = reason;
		this.customer = customer;
		this.employee = employee;
	}

	public Date getWantedDate() {
		return wantedDate;
	}

	public void setWantedDate(Date wantedDate) {
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
	
	
}

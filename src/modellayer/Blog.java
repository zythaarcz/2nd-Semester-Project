package modellayer;

import java.time.LocalDate;

public class Blog {
	
	private int id;
	private String imagePath;
	private String header;
	private String contentText;
	private String shortDescription;
	private LocalDate dateIssued;
	private Employee employee;
	
	public Blog(String imagePath, String header, String contentText, String shortDescription, LocalDate dateIssued) {
		this.imagePath = imagePath;
		this.header = header;
		this.contentText = contentText;
		this.shortDescription = shortDescription;
		this.dateIssued = dateIssued;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public LocalDate getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(LocalDate dateIssued) {
		this.dateIssued = dateIssued;
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

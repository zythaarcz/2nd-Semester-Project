package modellayer;

import java.util.Date;

public class Blog {
	
	private int id;
	private String imagePath;
	private String header;
	private String contentText;
	private String shortDescription;
	private Date dateIssued;
	private Employee employee;
	
	public Blog(String imagePath, String header, String contentText, String shortDescription, Date dateIssued, Employee employee) {
		this.imagePath = imagePath;
		this.header = header;
		this.contentText = contentText;
		this.shortDescription = shortDescription;
		this.dateIssued = dateIssued;
		this.employee = employee;
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

	public Date getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
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

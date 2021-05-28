package modellayer;

public class Video {
	
	private int id;
	private String url;
	private String header;
	private String shortDescription;
	private String category;
	private int pointsForCompletion;
	private Employee employee;
	
	public Video(String url, String header, String shortDescription, String category, int pointsForCompletion) {
		this.url = url;
		this.header = header;
		this.shortDescription = shortDescription;
		this.category = category;
		this.pointsForCompletion = pointsForCompletion;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getPointsForCompletion() {
		return pointsForCompletion;
	}
	
	public void setPointsForCompletion(int pointsForCompletion) {
		this.pointsForCompletion = pointsForCompletion;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}	
}

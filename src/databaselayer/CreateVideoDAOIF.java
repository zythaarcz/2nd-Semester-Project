package databaselayer;

import java.sql.SQLException;

import modellayer.Employee;

public interface CreateVideoDAOIF {
	
	void insertVideo(String url, String header, String shortDescription, String category, int pointsForCompletion, int employeeID) throws SQLException;
	
}

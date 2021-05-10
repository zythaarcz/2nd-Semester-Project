package databaselayer;

import java.sql.SQLException;

import modellayer.Video;

public interface ManageVideoDAOIF {
	Video retrieveVideo(int id) throws SQLException;
	void updateVideo(int id, String header, String shortDescription, String category, int pointsForCompletion) throws SQLException;
	void insertVideo(String url, String header, String shortDescription, String category, int pointsForCompletion, int employeeID) throws SQLException;
	void deleteVideo(int id) throws SQLException;
}

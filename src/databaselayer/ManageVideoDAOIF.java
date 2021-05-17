package databaselayer;

import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Video;

public interface ManageVideoDAOIF {
	Video retrieveVideo(int id) throws SQLException;
	void updateVideo(int id, String header, String shortDescription, String category, int pointsForCompletion) throws SQLException;
	void insertVideo(String url, String header, String shortDescription, String category, int pointsForCompletion, int employeeID) throws SQLException;
	void deleteVideo(int id) throws SQLException;
	ArrayList<Video> retrieveAllVideos() throws SQLException;
	Video retrieveVideoByName(String header) throws SQLException;
}

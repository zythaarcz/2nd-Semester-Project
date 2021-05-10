package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modellayer.Employee;

public class CreateVideoDAO implements CreateVideoDAOIF {
	
	private static final String INSERT_VIDEO = "INSERT into Video VALUES (?,?,?,?,?,?)";
	private PreparedStatement psInsertVideo;
	
	public CreateVideoDAO() throws SQLException {
		initPreparedStatement();
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psInsertVideo = connection.prepareStatement(INSERT_VIDEO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void insertVideo(String url, String header, String shortDescription, String category,
			int pointsForCompletion, int employeeID) throws SQLException {
		
		psInsertVideo.setString(1, url);
		psInsertVideo.setString(2, header);
		psInsertVideo.setString(3, shortDescription);
		psInsertVideo.setString(4, category);
		psInsertVideo.setInt(5, pointsForCompletion);
		psInsertVideo.setInt(6, employeeID);
		
		psInsertVideo.executeUpdate();
	}

	

}

package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modellayer.Video;

public class UpdateVideoDAO implements UpdateVideoDAOIF	{	
	private static final String UPDATE_VIDEO = "UPDATE Video Set header = ?, shortDescription = ?, category = ?, pointsForCompletion = ? WHERE id=?";
	private PreparedStatement psUpdateVideo;
	
	public UpdateVideoDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psUpdateVideo= connection.prepareStatement(UPDATE_VIDEO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	@Override
	public void updateVideo(int id, String header, String shortDescription, String category, int pointsForCompletion) {
		try {
			psUpdateVideo.setString(1, header);
			psUpdateVideo.setString(2, shortDescription);
			psUpdateVideo.setString(3, category);
			psUpdateVideo.setInt(4, pointsForCompletion);
			psUpdateVideo.setInt(5, id);
			
			psUpdateVideo.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Video buildObject(ResultSet rs) throws SQLException {
		
		Video video = null;
		
		try {
			video = new Video(rs.getInt("id"), rs.getString("url"), rs.getString("header"), rs.getString("description"),
					rs.getString("category"), rs.getInt("pointsForCompletion"), rs.getInt("employeeId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return video;
	}


}

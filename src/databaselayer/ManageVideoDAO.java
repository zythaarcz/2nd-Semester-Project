package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Customer;
import modellayer.Video;

public class ManageVideoDAO implements ManageVideoDAOIF{
	private static final String SELECT_VIDEO = "SELECT * FROM Video WHERE id = ?";
	private PreparedStatement psSelectVideo;
	
	
	public ManageVideoDAO() throws SQLException {
		
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectVideo= connection.prepareStatement(SELECT_VIDEO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Video retrieveVideo(int id) throws SQLException {
		Video video = null;
		ResultSet rs;
		
		psSelectVideo.setInt(1, id);
		
		rs = psSelectVideo.executeQuery();
		
		while(rs.next()) {
			video = buildObject(rs);
		}
		
		return video;
	}
	
	private Video buildObject(ResultSet rs) throws SQLException {
		Video video = null;
		
		try {
			video = new Video(rs.getString("url"), rs.getString("header"), rs.getString("shortDescription"), rs.getString("category"), rs.getInt("pointsForCompletion"));
			video.setId(rs.getInt("id"));
			// TODO: When EmployeeDAO and CustomerDAO are done, uncomment this
			// video.setEmployee(EmployeeDAO.getEmployee(rs.getInt("employeeId");
			// video.setListOfCustomers(CustomerDAO.getListOfCustomersForVideo(rs.getInt("id")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return video;
	}

}

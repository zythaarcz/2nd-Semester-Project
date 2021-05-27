package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modellayer.Video;

public class ManageVideoDAO implements ManageVideoDAOIF{
	private static final String SELECT_VIDEO = "SELECT * FROM Video WHERE id = ?";
	private PreparedStatement psSelectVideo;
	
	private static final String SELECT_VIDEO_BY_NAME = "SELECT * FROM Video WHERE header = ?";
	private PreparedStatement psSelectVideoByName;
	
	private static final String SELECT_ALL_VIDEOS = "SELECT * FROM Video";
	private PreparedStatement psSelectAllVideos;
	
	private static final String INSERT_VIDEO = "INSERT into Video VALUES (?,?,?,?,?,?)";
	private PreparedStatement psInsertVideo;
	
	private static final String UPDATE_VIDEO = "UPDATE Video SET header = ?, shortDescription = ?, category = ?, pointsForCompletion = ? WHERE id=?";
	private PreparedStatement psUpdateVideo;
	
	private static final String DELETE_VIDEO = "DELETE FROM Video WHERE id=?";
	private PreparedStatement psDeleteVideo;
	
	public ManageVideoDAO() throws SQLException {
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectVideo= connection.prepareStatement(SELECT_VIDEO);
			psInsertVideo = connection.prepareStatement(INSERT_VIDEO);
			psUpdateVideo= connection.prepareStatement(UPDATE_VIDEO);
			psDeleteVideo= connection.prepareStatement(DELETE_VIDEO);
			psSelectAllVideos= connection.prepareStatement(SELECT_ALL_VIDEOS);
			psSelectVideoByName= connection.prepareStatement(SELECT_VIDEO_BY_NAME);

		} catch (SQLException e) {
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
	
	@Override
	public void updateVideo(int id, String header, String shortDescription, String category, int pointsForCompletion) throws SQLException {
		psUpdateVideo.setString(1, header);
		psUpdateVideo.setString(2, shortDescription);
		psUpdateVideo.setString(3, category);
		psUpdateVideo.setInt(4, pointsForCompletion);
		psUpdateVideo.setInt(5, id);

		psUpdateVideo.executeUpdate();
	}
	
	@Override
	public void deleteVideo(int id) throws SQLException {
		psDeleteVideo.setInt(1, id);
		
		psDeleteVideo.executeUpdate();
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
	
	@Override
	public Video retrieveVideoByName(String header) throws SQLException {
		Video video = null;
		ResultSet rs;
		
		psSelectVideoByName.setString(1, header);
		
		rs = psSelectVideoByName.executeQuery();
		
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
			 //video.setEmployee(EmployeeDAO.getEmployee(rs.getInt("employeeId");
			 //video.setListOfCustomers(CustomerDAO.getListOfCustomersForVideo(rs.getInt("id")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return video;
	}

	@Override
	public ArrayList<Video> retrieveAllVideos() throws SQLException {
		ArrayList<Video> allVideos = new ArrayList<>();
		Video video = null;
		ResultSet rs;
		
		rs = psSelectAllVideos.executeQuery();	
		while(rs.next()) {
			video = buildObject(rs);
			allVideos.add(video);
		}
		
		return allVideos;
	}
}

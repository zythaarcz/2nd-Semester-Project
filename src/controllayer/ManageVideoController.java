package controllayer;

import databaselayer.ManageVideoDAOIF;

import java.sql.SQLException;
import java.util.ArrayList;

import databaselayer.ManageVideoDAO;
import modellayer.AuthenticatedUser;
import modellayer.Video;

public class ManageVideoController {

	private ManageVideoDAOIF manageVideoDao;
	
	public ManageVideoController() {
		try {
			manageVideoDao = new ManageVideoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createVideo(String url, String header, String shortDescription, String category, int pointsForCompletion) {
		// TODO: Uncomment when singleton is created
		try {
			manageVideoDao.insertVideo(url, header, shortDescription, category, pointsForCompletion, AuthenticatedUser.getInstance().getCurrentUser().getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateVideoInformation(int id, String header, String shortDescription, String category, int pointsForCompletion) {
		try {
			manageVideoDao.updateVideo(id, header, shortDescription, category, pointsForCompletion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Video retrieveVideo(int id) {
		Video video = null;
		
		try {
			video = manageVideoDao.retrieveVideo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return video;
	}
	
	public Video retrieveVideoByName(String header) {
		Video video = null;
		
		try {
			video = manageVideoDao.retrieveVideoByName(header);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return video;
	}
	
	public ArrayList<Video> retrieveAllVideos() {
		ArrayList<Video> allVideos = new ArrayList<>();
		
		try {
			allVideos = manageVideoDao.retrieveAllVideos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allVideos;
	}
	
	public void deleteVideo(int id) {
		try {
			manageVideoDao.deleteVideo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

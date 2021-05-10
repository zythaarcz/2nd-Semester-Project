package controllayer;

import databaselayer.ManageVideoDAOIF;

import java.sql.SQLException;

import databaselayer.ManageVideoDAO;
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
//		try {
//			manageVideoDao.insertVideo(url, header, shortDescription, category, pointsForCompletion, AuthenticatedUser.getInstance().getID());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
	
	public void deleteVideo(int id) {
		try {
			manageVideoDao.deleteVideo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

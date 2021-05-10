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
}

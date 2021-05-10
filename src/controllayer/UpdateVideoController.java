package controllayer;

import java.sql.SQLException;

import databaselayer.UpdateVideoDAO;
import databaselayer.UpdateVideoDAOIF;
import modellayer.Video;

public class UpdateVideoController{
	
	private UpdateVideoDAOIF updateVideoDAO;
	
	public UpdateVideoController() {
		try {
			updateVideoDAO = new UpdateVideoDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Video retrieveVideo(int id) {
		Video video = null;
		
		try {
			video = updateVideoDAO.retrieveVideo(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return video;
	}
	
	public void updateVideoInformation(int id, String header, String shortDescription, String category, int pointsForCompletion) {
		updateVideoDAO.updateVideo(id, header, shortDescription, category, pointsForCompletion);
	}
}

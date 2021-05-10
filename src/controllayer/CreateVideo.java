package controllayer;

import java.sql.SQLException;

import databaselayer.CreateVideoDAO;
import databaselayer.CreateVideoDAOIF;

public class CreateVideo {
	
	private CreateVideoDAOIF createVideoDAO;
	
	public CreateVideo() {
		try {
			createVideoDAO = new CreateVideoDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createVideo(String url, String header, String shortDescription, String category, int pointsForCompletion) {
		
		try {
			createVideoDAO.insertVideo(url, header, shortDescription, category, pointsForCompletion, AuthenticatedUser.getInstance().getID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

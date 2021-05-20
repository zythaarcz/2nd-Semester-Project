package controllayer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import databaselayer.ConsultationDAO;
import databaselayer.ConsultationDAOIF;
import modellayer.AuthenticatedUser;
import modellayer.DietMeeting;

public class DietConsultationController {
	
	private ConsultationDAOIF consultationDao;
	
	public DietConsultationController() {
		try {
			consultationDao = new ConsultationDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean createDietConsultation (LocalDate date, String reason) {
		boolean wasInserted = false;
		try {
			wasInserted = consultationDao.insertConsultation(date, reason);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wasInserted;
	}
	
	public ArrayList<DietMeeting> retrieveAllConsultations() {
		ArrayList<DietMeeting> allConsultations = new ArrayList<>();
		try {
			allConsultations = consultationDao.retrieveAllConsultations();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allConsultations;
		
	}
	
	public boolean deleteConsultation(int id) {
		boolean succeeded = false;
		try {
			succeeded = consultationDao.deleteConsultationById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return succeeded;
	}
	
	
	public int getLastInsertedId() {
		return consultationDao.getLastInsertedId();
	}

}

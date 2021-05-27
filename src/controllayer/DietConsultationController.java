package controllayer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import databaselayer.ConsultationDAO;
import databaselayer.ConsultationDAOIF;
import databaselayer.PersonDAO;
import databaselayer.PersonDAOIF;
import modellayer.AuthenticatedUser;
import modellayer.DietMeeting;
import modellayer.Employee;
import modellayer.Video;

public class DietConsultationController {
	
	private ConsultationDAOIF consultationDao;
	private PersonDAOIF personDao;
	
	public DietConsultationController() {
		try {
			consultationDao = new ConsultationDAO();
			personDao = new PersonDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Returning boolean value whether or not was diet consultation successfully created
	 * */
	public boolean createDietConsultation (LocalDate date, String reason, int employeeID) {
		boolean wasInserted = true;
			try {
				consultationDao.insertConsultation(date, reason, employeeID);
			}catch (SQLException e) {
				// catched the sql exception
				wasInserted = false;
			}

		return wasInserted;
	}
	
	/*
	 * This method is not used anywhere, but we made it for future reference
	 * Responsible for returning a list of all consultations in a database
	 * */
	public ArrayList<DietMeeting> retrieveAllConsultations() {
		ArrayList<DietMeeting> allConsultations = new ArrayList<>();
		try {
			allConsultations = consultationDao.retrieveAllConsultations();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allConsultations;
	}
	
	public boolean deleteConsultation(int id) {
		boolean succeeded = false;
		try {
			succeeded = consultationDao.deleteConsultationById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return succeeded;
	}
	
	/*
	 * TODO: We still need to figure out if this should be part of the code or not
	 * */
	public int getLastInsertedId() {
		return consultationDao.getLastInsertedId();
	}
	
	public DietMeeting retrieveConsultationCountByDate(LocalDate date) {
		DietMeeting dietMeeting = null;
		try {
			dietMeeting = consultationDao.retrieveConsultationByDate(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dietMeeting;
	}
	
	public DietMeeting retrieveConsultationByDate(LocalDate date) {
		DietMeeting dietMeeting = null;
		
		try {
			dietMeeting = consultationDao.retrieveConsultationByDate(date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dietMeeting;
	}
	
	public ArrayList<Employee> retrieveAllEmployees() {
		ArrayList<Employee> allEmployees = null;
		
		try {
			allEmployees = personDao.retrieveAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allEmployees;
	}

}

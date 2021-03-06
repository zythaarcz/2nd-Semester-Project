package databaselayer;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modellayer.DietMeeting;

public interface ConsultationDAOIF {	
	public DietMeeting retrieveConsultationByDate(LocalDate date) throws SQLException;
	public void insertConsultation(LocalDate date, String reason, int employeeID) throws SQLException;
	public ArrayList<DietMeeting> retrieveAllConsultations() throws SQLException;
	//public int retrieveConsultationCountByDate(LocalDate date) throws SQLException;
	public boolean deleteConsultationById(int id) throws SQLException;
	
	//public int getLastInsertedId();
	//public void setLastInsertedId(int id);
}

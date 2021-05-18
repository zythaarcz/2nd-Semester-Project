package databaselayer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modellayer.DietMeeting;

public interface ConsultationDAOIF {	
	public boolean insertConsultation(LocalDate date, String reason) throws SQLException;
	public ArrayList<DietMeeting> retrieveAllConsultations() throws SQLException;
}

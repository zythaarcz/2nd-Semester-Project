package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modellayer.AuthenticatedUser;
import modellayer.DietMeeting;

public class ConsultationDAO implements ConsultationDAOIF {

	private static final String INSERT_CONSULTATION = "INSERT into DietMeeting VALUES (?, ?, ?, ?)";
	private PreparedStatement psInsertConsultation;
	private static final String RETRIEVE_ALL_CONSULTATIONS = "SELECT * from DietMeeting";
	private PreparedStatement psRetrieveAllConsultation;
	private static final String RETRIEVE_COUNT_CONSULTATIONS = "SELECT COUNT(*) AS total from DietMeeting WHERE wantedDate=?";
	private PreparedStatement psRetrieveCountConsultations;
	
	private Connection connection;
	private PersonDAOIF personDao;
	public ConsultationDAO() throws SQLException {
		initPreparedStatement();
		personDao = new PersonDAO();
	}
	
	private void initPreparedStatement() throws SQLException {
		
		 connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psInsertConsultation= connection.prepareStatement(INSERT_CONSULTATION);
			psRetrieveAllConsultation= connection.prepareStatement(RETRIEVE_ALL_CONSULTATIONS);
			psRetrieveCountConsultations= connection.prepareStatement(RETRIEVE_COUNT_CONSULTATIONS);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean insertConsultation(LocalDate date, String reason) throws SQLException {
		boolean executed = false;
		psInsertConsultation.setObject(1,date);
		psInsertConsultation.setString(2, reason);
		psInsertConsultation.setInt(3,AuthenticatedUser.getInstance().getCurrentUser().getId());
		
		// Jiri is always responsible for consultation
		psInsertConsultation.setInt(4, 2);
		
		try {
			connection.setAutoCommit(false);
			psInsertConsultation.executeUpdate();
			
			if(retrieveConsultationCountByDate(date) < 2) {
				connection.commit();
				executed = true;
			}
			else {
				throw new SQLException();
			}
		}
		catch(SQLException e) {
			connection.rollback();
		}
		finally {
			connection.close();
		}
		return executed;
	}

	@Override
	public ArrayList<DietMeeting> retrieveAllConsultations() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<DietMeeting> meetings = null;
		
		ResultSet rs;
		rs = psRetrieveAllConsultation.executeQuery();
		
		while(rs.next()) {
			if(meetings == null)
				meetings = new ArrayList<DietMeeting>();
			
			DietMeeting meeting = buildObject(rs);
			meetings.add(meeting);
		}
		
		return meetings;
	}
	
	@Override
	public int retrieveConsultationCountByDate(LocalDate date) throws SQLException {
		int count = 0;
		psRetrieveCountConsultations.setObject(1, date);
		
		ResultSet rs;
		rs = psRetrieveCountConsultations.executeQuery();
		
		while(rs.next()) {
			count = rs.getInt("total");	
		}
		
		return count;
	}
	
	private boolean doMultipleMeetingsExist(LocalDate date) {
		ArrayList<DietMeeting> allMeetings = null;
		int counter = 0;
		
		try {
			allMeetings = retrieveAllConsultations();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(DietMeeting meeting : allMeetings) {
			if(meeting.getWantedDate().compareTo(date) == 0) {
				counter ++;
			}
		}
		
		return (counter >= 2) ? true : false;
		
		
	}
	
	
	
	private DietMeeting buildObject(ResultSet rs) throws SQLException {
		DietMeeting meeting = null;
		
		try {
			meeting = new DietMeeting(rs.getDate("wantedDate").toLocalDate(), rs.getString("reason"));
			meeting.setCustomer(personDao.retrieveCustomerById(rs.getInt("customerId")));
			meeting.setEmployee(personDao.retrieveEmployeeById(rs.getInt("employeeId")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return meeting;
	}  
	
}

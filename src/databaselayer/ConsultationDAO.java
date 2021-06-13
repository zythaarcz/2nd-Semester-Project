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
	
	private static final String SELECT_CONSULTATION_BY_DATE = "SELECT * FROM DietMeeting WHERE wantedDate = ?";
	private PreparedStatement psSelectConsultationByDate;
	
	private static final String RETRIEVE_ALL_CONSULTATIONS = "SELECT * from DietMeeting";
	private PreparedStatement psRetrieveAllConsultation;
	
	private static final String RETRIEVE_COUNT_CONSULTATIONS = "SELECT COUNT(*) AS total from DietMeeting WHERE wantedDate=?";
	private PreparedStatement psRetrieveCountConsultations;
	
	private static final String DELETE_CONSULTATION = "DELETE from DietMeeting WHERE id = ?";
	private PreparedStatement psDeleteConsultation;

	private Connection connection;
	private PersonDAOIF personDao;

	private int lastInsertedId = 0;

	public ConsultationDAO() throws SQLException {
		initPreparedStatement();
		personDao = new PersonDAO();
	}

	private void initPreparedStatement() throws SQLException {

		connection = DBConnection.getInstance().getDBconnection();

		try {
			psSelectConsultationByDate = connection.prepareStatement(SELECT_CONSULTATION_BY_DATE);
			psInsertConsultation = connection.prepareStatement(INSERT_CONSULTATION);
			psRetrieveAllConsultation = connection.prepareStatement(RETRIEVE_ALL_CONSULTATIONS);
			psRetrieveCountConsultations = connection.prepareStatement(RETRIEVE_COUNT_CONSULTATIONS);
			psDeleteConsultation = connection.prepareStatement(DELETE_CONSULTATION);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertConsultation(LocalDate date, String reason, int employeeId) throws SQLException{
		psInsertConsultation.setObject(1, date);
		psInsertConsultation.setString(2, reason);
		psInsertConsultation.setInt(3, AuthenticatedUser.getInstance().getCurrentUser().getId());

		// Jiri (id=2) is always responsible for consultation
		psInsertConsultation.setInt(4, employeeId);

		psInsertConsultation.executeUpdate();
	}

	@Override
	public ArrayList<DietMeeting> retrieveAllConsultations() throws SQLException {
		ArrayList<DietMeeting> meetings = null;

		ResultSet rs;
		rs = psRetrieveAllConsultation.executeQuery();

		while (rs.next()) {
			if (meetings == null)
				meetings = new ArrayList<DietMeeting>();

			DietMeeting meeting = buildObject(rs);
			meetings.add(meeting);
		}

		return meetings;
	}
	
	@Override
	public DietMeeting retrieveConsultationByDate(LocalDate date) throws SQLException {
		DietMeeting dietMeeting = null;
		ResultSet rs;
		
		psSelectConsultationByDate.setObject(1, date);
		
		rs = psSelectConsultationByDate.executeQuery();
		
		while(rs.next()) {
			dietMeeting = buildObject(rs);
		}
		
		return dietMeeting;
	}

	/*
	 * Retrieving number of records in a database of consultations with the same date
	 * */
//	@Override
//	public int retrieveConsultationCountByDate(LocalDate date) throws SQLException {
//		int count = 0;
//		psRetrieveCountConsultations.setObject(1, date);
//
//		ResultSet rs;
//		rs = psRetrieveCountConsultations.executeQuery();
//
//		while (rs.next()) {
//			count = rs.getInt("total");
//		}
//
//		return count;
//	}

	public boolean deleteConsultationById(int id) throws SQLException {
		boolean deletionSucceeded = false;

		psDeleteConsultation.setInt(1, id);

		if (psDeleteConsultation.executeUpdate() != 0) {
			deletionSucceeded = true;
		}

		return deletionSucceeded;
	}

	private DietMeeting buildObject(ResultSet rs) throws SQLException {
		DietMeeting meeting = null;

		try {
			meeting = new DietMeeting(rs.getDate("wantedDate").toLocalDate(), rs.getString("reason"));
			meeting.setCustomer(personDao.retrieveCustomerById(rs.getInt("customerId")));
			meeting.setEmployee(personDao.retrieveEmployeeById(rs.getInt("employeeId")));
			meeting.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return meeting;
	}

//	public int getLastInsertedId() {
//		return lastInsertedId;
//	}
//
//	public void setLastInsertedId(int id) {
//		this.lastInsertedId = id;
//	}
}

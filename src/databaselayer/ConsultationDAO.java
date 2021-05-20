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
			psInsertConsultation = connection.prepareStatement(INSERT_CONSULTATION);
			psRetrieveAllConsultation = connection.prepareStatement(RETRIEVE_ALL_CONSULTATIONS);
			psRetrieveCountConsultations = connection.prepareStatement(RETRIEVE_COUNT_CONSULTATIONS);
			psDeleteConsultation = connection.prepareStatement(DELETE_CONSULTATION);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean insertConsultation(LocalDate date, String reason) throws SQLException {
		boolean executed = false;
		psInsertConsultation.setObject(1, date);
		psInsertConsultation.setString(2, reason);
		psInsertConsultation.setInt(3, AuthenticatedUser.getInstance().getCurrentUser().getId());

		// Jiri is always responsible for consultation
		psInsertConsultation.setInt(4, 2);

		try {
			
			connection.setAutoCommit(false);
			psInsertConsultation.executeUpdate();

			if (retrieveConsultationCountByDate(date) < 2) {
				ResultSet generatedKeys = psInsertConsultation.getGeneratedKeys();
				if (generatedKeys.next()) {
					setLastInsertedId((int) generatedKeys.getLong(1));
				}

				connection.commit();
				executed = true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			connection.rollback();
		} finally {
			connection.setAutoCommit(true);
		}
		return executed;
	}

	@Override
	public ArrayList<DietMeeting> retrieveAllConsultations() throws SQLException {
		// TODO Auto-generated method stub
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
	public int retrieveConsultationCountByDate(LocalDate date) throws SQLException {
		int count = 0;
		psRetrieveCountConsultations.setObject(1, date);

		ResultSet rs;
		rs = psRetrieveCountConsultations.executeQuery();

		while (rs.next()) {
			count = rs.getInt("total");
		}

		return count;
	}

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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return meeting;
	}

	public int getLastInsertedId() {
		return lastInsertedId;
	}

	public void setLastInsertedId(int id) {
		this.lastInsertedId = id;
	}

}

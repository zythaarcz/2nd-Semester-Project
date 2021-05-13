package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modellayer.Person;
import modellayer.Video;

public class PersonDAO implements PersonDAOIF {
	private static final String SELECT_PERSON = "SELECT * FROM Person WHERE id = ?";
	private PreparedStatement psSelectPerson;
	
	private static final String SELECT_AUTHENTICATEDUSER = "SELECT * FROM Authentication WHERE email = ?";
	private PreparedStatement psSelectAuthenticatedUser;
	
	public PersonDAO() throws SQLException {
		initPreparedStatement();
	}
	
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectPerson= connection.prepareStatement(SELECT_PERSON);
			psSelectAuthenticatedUser = connection.prepareStatement(SELECT_AUTHENTICATEDUSER);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Person retrievePersonById(int id) throws SQLException {
		Person person = null;
		ResultSet rs;
		
		psSelectPerson.setInt(1, id);
		
		rs = psSelectPerson.executeQuery();
		
		if(rs.next()) {
			person = buildObject(rs);
		}
		
		return person;
	}

	@Override
	public Person authenticatePerson(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		Person person = null;
		ResultSet rs;
		psSelectAuthenticatedUser.setString(1, email);
		rs = psSelectAuthenticatedUser.executeQuery();
		
		if(rs.next()) {
			String dbEmail = rs.getString("email");
			String dbPassword = rs.getString("password");
			
			if(dbEmail.equals(email) && dbPassword.equals(password)) {
				// User puts right credentials
				int personId = rs.getInt("id");
				person = retrievePersonById(personId);
			}
		}
		
		
		
		return person;
	}

	private Person buildObject(ResultSet rs) throws SQLException {
		Person person = null;
		
		try {
			person = new Person(rs.getString("firstName"), rs.getString("lastName"), rs.getString("phoneNumber"), rs.getString("email"), rs.getString("personType"));
			person.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return person;
	}
	
}

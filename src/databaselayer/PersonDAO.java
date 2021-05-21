package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modellayer.Customer;
import modellayer.Employee;
import modellayer.Person;
import modellayer.Video;

public class PersonDAO implements PersonDAOIF {
	private static final String SELECT_PERSON = "SELECT * FROM Person WHERE id = ?";
	private PreparedStatement psSelectPerson;

	private static final String SELECT_EMPLOYEE = "SELECT * FROM Employee WHERE id = ?";
	private PreparedStatement psSelectEmployee;
	
	private static final String SELECT_CUSTOMER = "SELECT * FROM Customer WHERE id = ?";
	private PreparedStatement psSelectCustomer;

	private static final String SELECT_AUTHENTICATEDUSER = "SELECT * FROM Authentication WHERE email = ?";
	private PreparedStatement psSelectAuthenticatedUser;

	public PersonDAO() throws SQLException {
		initPreparedStatement();
	}

	private void initPreparedStatement() throws SQLException {

		Connection connection = DBConnection.getInstance().getDBconnection();

		try {
			psSelectPerson = connection.prepareStatement(SELECT_PERSON);
			psSelectAuthenticatedUser = connection.prepareStatement(SELECT_AUTHENTICATEDUSER);
			psSelectEmployee = connection.prepareStatement(SELECT_EMPLOYEE);
			psSelectCustomer = connection.prepareStatement(SELECT_CUSTOMER);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Person authenticatePerson(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		Person person = null;
		ResultSet rs;
		psSelectAuthenticatedUser.setString(1, email);
		rs = psSelectAuthenticatedUser.executeQuery();

		if (rs.next()) {
			String dbEmail = rs.getString("email");
			String dbPassword = rs.getString("password");

			if (dbEmail.equals(email) && dbPassword.equals(password)) {
				// User puts right credentials
				int personId = rs.getInt("id");
				person = retrievePersonById(personId);
			}
		}

		return person;
	}
	
	

	@Override
	public Person retrievePersonById(int id) throws SQLException {
		Person person = null;
		ResultSet rs;

		psSelectPerson.setInt(1, id);

		rs = psSelectPerson.executeQuery();

		if (rs.next()) {
			person = buildObjectPerson(rs);
		}

		return person;
	}

	@Override
	public Employee retrieveEmployeeById(int id) throws SQLException {
		Employee employee = null;
		Person person = retrievePersonById(id);

		ResultSet rs;

		psSelectEmployee.setInt(1, id);

		rs = psSelectEmployee.executeQuery();

		if (rs.next()) {
			employee = buildObjectEmployee(rs, person);
		}

		return employee;
	}

	@Override
	public Customer retrieveCustomerById(int id) throws SQLException {
		Customer customer = null;

		Person person = retrievePersonById(id);

		ResultSet rs;

		psSelectCustomer.setInt(1, id);

		rs = psSelectCustomer.executeQuery();

		if (rs.next()) {
			customer = buildObjectCustomer(rs, person);
		}
		
		return customer;
	}

	private Employee buildObjectEmployee(ResultSet rs, Person person) throws SQLException {
		Employee empToReturn = null;

		try {
			empToReturn = new Employee(person.getFirstName(), person.getLastName(), person.getPhoneNumber(),
					person.getEmail(), rs.getString("position"));
			empToReturn.setId(person.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return empToReturn;
	}

	private Person buildObjectPerson(ResultSet rs) throws SQLException {
		Person person = null;

		try {
			person = new Person(rs.getString("firstName"), rs.getString("lastName"), rs.getString("phoneNumber"),
					rs.getString("email"), rs.getString("personType"));
			person.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	private Customer buildObjectCustomer(ResultSet rs, Person person) throws SQLException {
		Customer customer = null;
		try {
			String address = rs.getString("street") + " " + rs.getInt("houseNumber") + ", " + rs.getString("zipcode") + ", " + rs.getString("city") + ", " + rs.getString("country");
			customer = new Customer(person.getFirstName(), person.getLastName(), person.getPhoneNumber(),
					person.getEmail(), address, rs.getString("company"),
					rs.getDate("dateOfBirth").toLocalDate(), rs.getString("healthIssue"), rs.getString("timeToRemind"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

}

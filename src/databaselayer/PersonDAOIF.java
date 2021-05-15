package databaselayer;
import java.sql.SQLException;

import modellayer.Employee;
import modellayer.Person;

public interface PersonDAOIF {
	public Person retrievePersonById(int id) throws SQLException;
	public Person authenticatePerson(String email, String password) throws SQLException;
	public Employee retrieveEmployeeById(int id) throws SQLException;
}

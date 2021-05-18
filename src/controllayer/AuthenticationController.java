package controllayer;

import modellayer.PersonTypes;

import java.sql.SQLException;

import databaselayer.PersonDAO;
import databaselayer.PersonDAOIF;
import modellayer.AuthenticatedUser;
import modellayer.Customer;
import modellayer.Person;

public class AuthenticationController {
	
	private PersonDAOIF personDao;
	
	public AuthenticationController() {
		try {
			personDao = new PersonDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean authenticateUser(String email, String password) {
		// TODO: Implement authentication functionality
		boolean valToReturn = false;
		Person person = null;
		
		try {
			person = personDao.authenticatePerson(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(person != null) {
			valToReturn = true;
			AuthenticatedUser.getInstance().setCurrentUser(person);
		}
		return valToReturn;
	}
	
	public PersonTypes getCurrentPersonType() {
		return AuthenticatedUser.getInstance().getCurrentUser().getPersonType();
	}
	
	public Customer getCustomer() {
		Customer customer = null;
		if (getCurrentPersonType() == PersonTypes.Customer) {
			try {
				customer = personDao.retrieveCustomerById(AuthenticatedUser.getInstance().getCurrentUser().getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return customer;
	}
	
}

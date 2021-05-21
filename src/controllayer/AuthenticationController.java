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
	/*
	 * Returning boolean value whether or not was the user authenticated
	 * */
	public boolean authenticateUser(String email, String password) {
		boolean valToReturn = false;
		Person person = null;
		
		try {
			person = personDao.authenticatePerson(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(person != null) {
			valToReturn = true;
			//Setting authenticated user to singleton class, so we can easily access it from all of the code
			AuthenticatedUser.getInstance().setCurrentUser(person);
		}
		return valToReturn;
	}
	
	public PersonTypes getCurrentPersonType() {
		return AuthenticatedUser.getInstance().getCurrentUser().getPersonType();
	}
	
	/*
	 * Returning Customer, if a customer is signed in
	 * Does not work if an employee is signed in
	 * */ 
	
	public Customer getCustomer() {
		Customer customer = null;
		if (getCurrentPersonType() == PersonTypes.Customer) {
			try {
				customer = personDao.retrieveCustomerById(AuthenticatedUser.getInstance().getCurrentUser().getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customer;
	}
	
}

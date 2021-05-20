package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import controllayer.AuthenticationController;
import controllayer.ManageBlogController;

public class TestBookingDietConsultation {

	private static AuthenticationController authenticationController;
	
	@BeforeClass
	public static void setUp() throws Exception {
		authenticationController = new AuthenticationController();
		authenticationController.authenticateUser("matej@gmail.com", "123");
		
	}
	
	@Test
	public void test() {
		//Arrange
		ConsultationThread customer1 = new ConsultationThread("Customer 1");
		ConsultationThread customer2 = new ConsultationThread("Customer 2");
		
		Thread tr1 = new Thread(customer1);
		Thread tr2 = new Thread(customer2);
		
		//Act
		tr1.start();	
		tr2.start();

		try {
			tr1.join();
			customer1.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			tr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Assert
		assertFalse(customer2.getExecuted());
	}

}

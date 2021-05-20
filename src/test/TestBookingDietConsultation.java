package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import controllayer.AuthenticationController;
import controllayer.DietConsultationController;
import controllayer.ManageBlogController;
import controllayer.ManageVideoController;
import modellayer.DietMeeting;
import modellayer.Video;

public class TestBookingDietConsultation {

	private static AuthenticationController authenticationController;
	static DietConsultationController dietConsultationController;
	
	@BeforeClass
	public static void setUp() throws Exception {
		authenticationController = new AuthenticationController();
		authenticationController.authenticateUser("matej@gmail.com", "123");
		
	}
	
	@Test
	public void testTwoCustomersBookingTheSameDate() {
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
	
	//Scenario 3, past date selected
	@Test
	public void testIfCustomerEnteredPastDate() {
		
		//Arrange
		
		
		//Act
		
		//Assert

	}
	//Scenario 4, numeric value written to reason text field
	@Test
	public void testIfConsultationAddedWhenNumericValue() {
		
		//Arrange
		
		//Act
		
		//Assert
	}
	
	@Test
	public void testDietConsultationBookedSuccessfully() {
		//Arrange
		DietMeeting consultation;
		String expectedConsultationDate = "2021-06-24";
		
		//Act
		dietConsultationController.createDietConsultation(2021-06-24, "Back pain");
		consultation = dietConsultationController.retrieveConsultationByDate(2021-06-24);
		
		//Assert
		assertEquals("Expected diet consultation date should be: 2021-06-24", expectedConsultationDate, consultation.getWantedDate());
	}
}

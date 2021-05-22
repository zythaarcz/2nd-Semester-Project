package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controllayer.AuthenticationController;
import controllayer.DietConsultationController;
import controllayer.ManageBlogController;
import controllayer.ManageVideoController;
import modellayer.AuthenticatedUser;
import modellayer.DietMeeting;
import modellayer.Video;

public class TestBookingDietConsultation {

	private static AuthenticationController authenticationController;
	static DietConsultationController dietConsultationController;
	
	@BeforeClass
	public static void setUp() throws Exception {
		authenticationController = new AuthenticationController();
		authenticationController.authenticateUser("matej@gmail.com", "123");
		dietConsultationController = new DietConsultationController();
		
	}
	
	@Test
	public void testTwoCustomersBookingTheSameDate() {
		//Arrange
		LocalDate date = LocalDate.of(2021, 5, 26); 
		int employeeID = 2;
		boolean customer1Executed = false;
		boolean customer2Executed = false;

		//Act
		customer1Executed = dietConsultationController.createDietConsultation(date, "I need to get slim.", employeeID);
		
		AuthenticatedUser.getInstance().setCurrentUser(null);
		authenticationController.authenticateUser("dan@gmail.com", "123");
		customer2Executed = dietConsultationController.createDietConsultation(date, "I need to get huge.", employeeID);

		//Assert
		assertTrue(customer1Executed);
		assertFalse(customer2Executed);
	}
	
	@Test
	public void testDietConsultationBookedSuccessfully() {
		//Arrange
		DietMeeting consultation;
		int employeeID = 2;
		LocalDate expectedConsultationDate = LocalDate.of(2021, Month.JUNE, 24);
		
		//Act
		dietConsultationController.createDietConsultation(LocalDate.of(2021, Month.JUNE, 24), "Back pain", employeeID);
		consultation = dietConsultationController.retrieveConsultationByDate(LocalDate.of(2021, Month.JUNE, 24));
		
		//Assert
		assertEquals("Expected diet consultation date should be: 2021-06-24", expectedConsultationDate, consultation.getWantedDate());
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		int firstId = dietConsultationController.retrieveConsultationByDate(LocalDate.of(2021, Month.JUNE, 24)).getId();
		dietConsultationController.deleteConsultation(firstId);
		
		int secondId = dietConsultationController.retrieveConsultationByDate(LocalDate.of(2021, 5, 26)).getId();
		dietConsultationController.deleteConsultation(secondId);
	}
}

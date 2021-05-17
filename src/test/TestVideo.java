package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllayer.AuthenticationController;
import controllayer.ManageVideoController;
import modellayer.Video;

public class TestVideo {
	
	static ManageVideoController manageVideoController;
	Video testVideo;
	AuthenticationController authenticationController;

	@Before
	public void setUp() throws Exception {
		manageVideoController = new ManageVideoController();
		authenticationController = new AuthenticationController();
		authenticationController.authenticateUser("jirizadina@gmail.com", "Password123");
		
	}

	//testing video RETRIEVE from database
	@Test
	public void testIfVideoExistsInDatabase() {
		// Arrange
		Video video;
		String expectedVideoName = "cool fix back";
				
		// Act
		video = manageVideoController.retrieveVideo(2);
				
		// Assert
		assertEquals("Expected video header should be Cool fix back", expectedVideoName, video.getHeader().toLowerCase());
	}
	//testing CREATE video and inserting into database
	@Test
	public void testIfVideoIsInsertedInDatabase() {
		//Arrange
		Video video;
		String expectedShortDescription = "testVideoShortDescription";
		//Act
		manageVideoController.createVideo("videoURL", "testVideoHeader", "testVideoShortDescription", "testVideoCategory", 50);
		video = manageVideoController.retrieveVideoByName("testVideoHeader");
		//Assert
		assertEquals("Expected short description should be: testVideoShortDescription", expectedShortDescription, video.getShortDescription());
	}
	
	//deleting test data from database
	@AfterClass
	public static void tearDown() throws Exception {
		int id = manageVideoController.retrieveVideoByName("testVideoHeader").getId();
		manageVideoController.deleteVideo(id);
	}

}

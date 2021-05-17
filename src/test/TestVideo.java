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
	static AuthenticationController authenticationController;
	static Video oldVideo;

	@BeforeClass
	public static void setUp() throws Exception {
		manageVideoController = new ManageVideoController();
		authenticationController = new AuthenticationController();
		authenticationController.authenticateUser("jirizadina@gmail.com", "Password123");
		
	}

	//testing video RETRIEVE from database
	@Test
	public void testIfVideoExistsInDatabase() {
		// Arrange
		Video video;
		String expectedVideoHeader = "cool fix back";
				
		// Act
		video = manageVideoController.retrieveVideo(2);
				
		// Assert
		assertEquals("Expected video header should be Cool fix back", expectedVideoHeader, video.getHeader().toLowerCase());
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
	
	//testing UPDATE video information in the database
	@Test
	public void testIfVideoInformationIsUpdatedInDatabase() {
		//Arrange
		Video video;
		String expectedNewVideoHeader = "Changed testVideoHeader";
		
		//Act
		video = manageVideoController.retrieveVideo(1);
		oldVideo = video;
		manageVideoController.updateVideoInformation(video.getId(), "Changed testVideoHeader", "testVideoShortDescription", "testVideoCategory", 50);
		video = manageVideoController.retrieveVideo(video.getId());
		
		//Assert
		assertEquals("Expected new header should be: Changed testVideoHeader", expectedNewVideoHeader,video.getHeader());
	}

	
	//Deleting and reverting changes made to the database
	@AfterClass
	public static void tearDown() throws Exception {
		int id = manageVideoController.retrieveVideoByName("testVideoHeader").getId();
		manageVideoController.deleteVideo(id);
		manageVideoController.updateVideoInformation(oldVideo.getId(), oldVideo.getHeader(), oldVideo.getShortDescription(), oldVideo.getCategory(), oldVideo.getPointsForCompletion());
	}

}

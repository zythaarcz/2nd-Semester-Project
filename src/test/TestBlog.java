package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controllayer.AuthenticationController;
import controllayer.ManageBlogController;
import modellayer.Blog;

public class TestBlog {
	static ManageBlogController manageBlogController;
	static AuthenticationController authenticationController;
	static Blog oldBlog;

	@BeforeClass
	public static void setUp() throws Exception {
		manageBlogController = new ManageBlogController();
		authenticationController = new AuthenticationController();
		authenticationController.authenticateUser("jirizadina@gmail.com", "Password123");
	}

	// testing RETRIEVE blog from database
	@Test
	public void testIfBlogExistsInDatabase() {
		// Arrange
		Blog blog;
		String expectedBlogHeader = "home gym equipments";

		// Act
		blog = manageBlogController.retrieveBlog(14);

		// Assert
		assertEquals("Expected blog header should be: home gym equipments", expectedBlogHeader, blog.getHeader().toLowerCase());
	}

	// testing CREATE blog and inserting into database
	@Test
	public void testIfBlogIsInsertedInDatabase() {
		// Arrange
		Blog blog;
		String expectedShortDescription = "testBlogShortDescription";

		// Act
		manageBlogController.createBlog("testBlogImagePath", "testBlogHeader", "testBlogContentText", "testBlogShortDescription", LocalDate.now());
		blog = manageBlogController.retrieveBlogByName("testBlogHeader");

		// Assert
		assertEquals("Expected short description should be: testBlogShortDescription", expectedShortDescription,blog.getShortDescription());
	}

	// testing UPDATE blog information in the database
	@Test
	public void testIfBlogInformationIsUpdatedInDatabase() {
		// Arrange
		Blog blog;
		String expectedNewBlogHeader = "Changed testBlogHeader";

		// Act
		blog = manageBlogController.retrieveBlog(15);
		oldBlog = blog;
		manageBlogController.updateBlogInformation(blog.getId(), "testBlogImagePath", "Changed testBlogHeader", "testBlogContentText", "testBlogShortDescription");
		blog = manageBlogController.retrieveBlog(blog.getId());

		// Assert
		assertEquals("Expected new header should be: Changed testBlogHeader", expectedNewBlogHeader, blog.getHeader());
	}

	// Deleting and reverting changes made to the database
	@AfterClass
	public static void tearDown() throws Exception {
		int id = manageBlogController.retrieveBlogByName("testBlogHeader").getId();
		manageBlogController.deleteBlog(id);
		manageBlogController.updateBlogInformation(oldBlog.getId(), oldBlog.getImagePath(), oldBlog.getHeader(),
		oldBlog.getContentText(), oldBlog.getShortDescription());
	}
}
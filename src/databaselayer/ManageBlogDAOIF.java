package databaselayer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modellayer.Blog;
import modellayer.Video;

public interface ManageBlogDAOIF {
	Blog retrieveBlog(int id) throws SQLException;
	void updateBlog(int id, String imagePath, String header, String contentText, String shortDescription, LocalDate dateIssued) throws SQLException;
	void insertBlog(String imagePath, String header, String contentText, String shortDescription, LocalDate dateIssued, int employeeID) throws SQLException;
	void deleteBlog(int id) throws SQLException;
	ArrayList<Blog> retrieveAllBlogs() throws SQLException;

}

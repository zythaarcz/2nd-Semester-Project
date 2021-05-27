package controllayer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import databaselayer.ManageBlogDAO;
import databaselayer.ManageBlogDAOIF;
import modellayer.AuthenticatedUser;
import modellayer.Blog;

public class ManageBlogController {
	
	private ManageBlogDAOIF manageBlogDao;
	
	public ManageBlogController() {
		try {
			manageBlogDao = new ManageBlogDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Creating blog based on user input
	 * */
	public void createBlog(String imagePath, String header, String contentText, String shortDescription, LocalDate dateIssued) {
		try {
			manageBlogDao.insertBlog(imagePath, header, contentText, shortDescription, dateIssued, AuthenticatedUser.getInstance().getCurrentUser().getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Updating blog based on user input
	 * */
	public void updateBlogInformation(int id, String imagePath, String header, String contentText, String shortDescription) {
		try {
			manageBlogDao.updateBlog(id, imagePath, header, contentText, shortDescription);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Blog retrieveBlog(int id) {
		Blog blog = null;
		
		try {
			blog = manageBlogDao.retrieveBlog(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blog;
	}
	
	public Blog retrieveBlogByName(String header) {
		Blog blog = null;
		
		try {
			blog = manageBlogDao.retrieveBlogByName(header);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blog;
	}
	
	public ArrayList<Blog> retrieveAllBlogs() {
		ArrayList<Blog> allBlogs = new ArrayList<>();
		
		try {
			allBlogs = manageBlogDao.retrieveAllBlogs();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allBlogs;
	}
	
	public void deleteBlog(int id) {
		try {
			manageBlogDao.deleteBlog(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * When deleting a blog post, we need to make sure that also a image from project directory is deleted as well
	 * */
	public void deleteImageFromBlog(String path) {
		 Path pathToBeDeleted = Paths.get(path);
		 try {
			Files.delete(pathToBeDeleted);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

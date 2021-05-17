package controllayer;

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
	
	public void createBlog(String imagePath, String header, String contentText, String shortDescription, LocalDate dateIssued) {
		// TODO: Uncomment when singleton is created
		try {
			manageBlogDao.insertBlog(imagePath, header, contentText, shortDescription, dateIssued, AuthenticatedUser.getInstance().getCurrentUser().getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateBlogInformation(int id, String imagePath, String header, String contentText, String shortDescription) {
		try {
			manageBlogDao.updateBlog(id, imagePath, header, contentText, shortDescription);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Blog retrieveBlog(int id) {
		Blog blog = null;
		
		try {
			blog = manageBlogDao.retrieveBlog(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return blog;
	}
	
	public Blog retrieveBlogByName(String header) {
		Blog blog = null;
		
		try {
			blog = manageBlogDao.retrieveBlogByName(header);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return blog;
	}
	
	public ArrayList<Blog> retrieveAllBlogs() {
		ArrayList<Blog> allBlogs = new ArrayList<>();
		
		try {
			allBlogs = manageBlogDao.retrieveAllBlogs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allBlogs;
	}
	
	public void deleteBlog(int id) {
		try {
			manageBlogDao.deleteBlog(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

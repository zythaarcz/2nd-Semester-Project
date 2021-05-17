package databaselayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modellayer.Blog;

public class ManageBlogDAO implements ManageBlogDAOIF {
	private static final String SELECT_BLOG = "SELECT * FROM Blog WHERE id = ?";
	private PreparedStatement psSelectBlog;
	
	private static final String SELECT_BLOG_BY_NAME = "SELECT * FROM Blog WHERE header = ?";
	private PreparedStatement psSelectBlogByName;
	
	private static final String SELECT_ALL_BLOGS = "SELECT * FROM Blog";
	private PreparedStatement psSelectAllBlogs;
	
	private static final String INSERT_BLOG = "INSERT into Blog VALUES (?,?,?,?,?,?)";
	private PreparedStatement psInsertBlog;
	
	private static final String UPDATE_BLOG = "UPDATE Blog SET imagePath = ?, header = ?, contentText = ?, shortDescription = ? WHERE id=?";
	private PreparedStatement psUpdateBlog;
	
	private static final String DELETE_BLOG= "DELETE FROM Blog WHERE id=?";
	private PreparedStatement psDeleteBlog;
	
	
	private PersonDAOIF personDao;
	
	public ManageBlogDAO() throws SQLException {
		personDao = new PersonDAO();
		initPreparedStatement();		
	}
	
	private void initPreparedStatement() throws SQLException {
		
		Connection connection = DBConnection.getInstance().getDBconnection();
		
		try {
			psSelectBlog= connection.prepareStatement(SELECT_BLOG);
			psInsertBlog = connection.prepareStatement(INSERT_BLOG);
			psUpdateBlog= connection.prepareStatement(UPDATE_BLOG);
			psDeleteBlog= connection.prepareStatement(DELETE_BLOG);
			psSelectAllBlogs= connection.prepareStatement(SELECT_ALL_BLOGS);
			psSelectBlogByName= connection.prepareStatement(SELECT_BLOG_BY_NAME);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insertBlog(String imagePath, String header, String contentText, String shortDescription, LocalDate dateIssued, int employeeID) throws SQLException {
		
		psInsertBlog.setString(1, imagePath);
		psInsertBlog.setString(2, header);
		psInsertBlog.setString(3, contentText);
		psInsertBlog.setString(4, shortDescription);
		psInsertBlog.setObject(5, dateIssued);
		psInsertBlog.setInt(6, employeeID);
		
		psInsertBlog.executeUpdate();
	}
	
	@Override
	public void updateBlog(int id, String imagePath, String header, String contentText, String shortDescription) throws SQLException {
		psUpdateBlog.setString(1, imagePath);
		psUpdateBlog.setString(2, header);
		psUpdateBlog.setString(3, contentText);
		psUpdateBlog.setString(4, shortDescription);
		psUpdateBlog.setInt(5, id);

		psUpdateBlog.executeUpdate();
	}
	
	@Override
	public void deleteBlog(int id) throws SQLException {
		psDeleteBlog.setInt(1, id);
		
		psDeleteBlog.executeUpdate();
		
	}

	
	@Override
	public Blog retrieveBlog(int id) throws SQLException {
		Blog blog = null;
		ResultSet rs;
		
		psSelectBlog.setInt(1, id);
		
		rs = psSelectBlog.executeQuery();
		
		while(rs.next()) {
			blog = buildObject(rs);
		}
		
		return blog;
	}
	
	@Override
	public Blog retrieveBlogByName(String header) throws SQLException {
		Blog blog = null;
		ResultSet rs;
		
		psSelectBlogByName.setString(1, header);
		
		rs = psSelectBlogByName.executeQuery();
		
		while(rs.next()) {
			blog = buildObject(rs);
		}
		
		return blog;
	}
	
	private Blog buildObject(ResultSet rs) throws SQLException {
		Blog blog = null;
		
		try {
			blog = new Blog(rs.getString("imagePath"), rs.getString("header"), rs.getString("contentText"), rs.getString("shortDescription"), rs.getDate("dateIssued").toLocalDate());
			blog.setId(rs.getInt("id"));
			blog.setEmployee(personDao.retrieveEmployeeById(rs.getInt("employeeId")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return blog;
	}

	@Override
	public ArrayList<Blog> retrieveAllBlogs() throws SQLException {
		ArrayList<Blog> allBlogs = new ArrayList<>();
		Blog blog = null;
		ResultSet rs;
		
		rs = psSelectAllBlogs.executeQuery();	
		while(rs.next()) {
			blog = buildObject(rs);
			allBlogs.add(blog);
		}
		
		return allBlogs;
	}
	
}

package guilayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import controllayer.ManageBlogController;
import controllayer.ManageVideoController;
import modellayer.Blog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class BlogPanel extends JPanel {

	private ManageBlogController manageBlogController = new ManageBlogController();
	protected JButton editBlogButton;
	protected JTextPane textPane;
	protected JButton deleteBlogButton;
	
	/**
	 * Create the panel.
	 */
	public BlogPanel(Blog blog) {
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nameLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DailyBlog dailyBlog = new DailyBlog(blog);
				dailyBlog.setLocationRelativeTo(null);
				dailyBlog.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		nameLabel.setText(blog.getHeader());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLabel.setBounds(11, 7, 378, 25);
		add(nameLabel);
		
		textPane = new JTextPane();
		textPane.setText(blog.getShortDescription());
		textPane.setEditable(false);
		textPane.setBounds(11, 295, 345, 58);
		add(textPane);
		
		editBlogButton = new JButton("");
		editBlogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditBlog editBlog = new EditBlog(blog);
				editBlog.setLocationRelativeTo(null);
				editBlog.setVisible(true);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		editBlogButton.setOpaque(false);
		editBlogButton.setBorderPainted(false);
		editBlogButton.setIcon(new ImageIcon(BlogPanel.class.getResource("/images/editVideoButton.png")));
		editBlogButton.setBounds(366, 295, 23, 21);
		add(editBlogButton);
		
		deleteBlogButton = new JButton("");
		deleteBlogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int choice = JOptionPane.showConfirmDialog(textPane, "Are you sure to delete this blog?");
				
				if(choice == 0) {
					manageBlogController.deleteBlog(blog.getId());
					manageBlogController.deleteImageFromBlog(blog.getImagePath());
					AllBlogsEmployee allBlogs = new AllBlogsEmployee();
					allBlogs.setLocationRelativeTo(null);
					allBlogs.setVisible(true);
					((JFrame) getTopLevelAncestor()).dispose();
				}
			}
		});
		deleteBlogButton.setIcon(new ImageIcon(BlogPanel.class.getResource("/images/deleteButton.png")));
		deleteBlogButton.setOpaque(false);
		deleteBlogButton.setBorderPainted(false);
		deleteBlogButton.setBounds(366, 326, 23, 27);
		add(deleteBlogButton);
		
		File file = new File(blog.getImagePath());
		if(file.exists()) {
			ImageIcon imageIcon = new ImageIcon(blog.getImagePath()); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(320, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			
			JLabel blogImage = new JLabel(imageIcon);
			blogImage.setBounds(40, 64, 320, 180);
			add(blogImage);
			
			blogImage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DailyBlog dailyBlog = new DailyBlog(blog);
				dailyBlog.setLocationRelativeTo(null);
				dailyBlog.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
			}	
			});
		}
	}
}

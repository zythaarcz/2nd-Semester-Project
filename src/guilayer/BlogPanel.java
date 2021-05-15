package guilayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import controllayer.ManageBlogController;
import controllayer.ManageVideoController;
import modellayer.Blog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class BlogPanel extends JPanel {

	private ManageBlogController manageBlogController = new ManageBlogController();
	/**
	 * Create the panel.
	 */
	public BlogPanel(Blog blog) {
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.setText(blog.getHeader());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLabel.setBounds(11, 19, 378, 13);
		add(nameLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(blog.getShortDescription());
		textPane.setEditable(false);
		textPane.setBounds(11, 295, 345, 58);
		add(textPane);
		
		JButton editBlogButton = new JButton("");
		editBlogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditBlog editBlog = new EditBlog();
				editBlog.setVisible(true);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		editBlogButton.setOpaque(false);
		editBlogButton.setBorderPainted(false);
		editBlogButton.setIcon(new ImageIcon(BlogPanel.class.getResource("/images/editVideoButton.png")));
		editBlogButton.setBounds(366, 295, 23, 21);
		add(editBlogButton);
		
		JButton deleteBlogButton = new JButton("\"\"");
		deleteBlogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Delete also the image from project directory
				
				manageBlogController.deleteBlog(blog.getId());
				AllBlogsEmployee allBlogs = new AllBlogsEmployee();
				allBlogs.setVisible(true);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		deleteBlogButton.setIcon(new ImageIcon(BlogPanel.class.getResource("/images/deleteButton.png")));
		deleteBlogButton.setOpaque(false);
		deleteBlogButton.setBorderPainted(false);
		deleteBlogButton.setBounds(371, 332, 23, 21);
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
		}
	}
}

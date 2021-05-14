package guilayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		editBlogButton.setBounds(366, 297, 23, 21);
		add(editBlogButton);
		
		JButton deleteBlogButton = new JButton("\"\"");
		deleteBlogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageBlogController.deleteBlog(blog.getId());
				//AllBlogsEmployee allBlogs = new AllBlogsEmployee();
				//allBlogs.setVisible(true);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		deleteBlogButton.setIcon(new ImageIcon(BlogPanel.class.getResource("/images/deleteButton.png")));
		deleteBlogButton.setOpaque(false);
		deleteBlogButton.setBorderPainted(false);
		deleteBlogButton.setBounds(366, 332, 23, 21);
		add(deleteBlogButton);
		
		JTextPane blogTextPane = new JTextPane();
		blogTextPane.setText(blog.getContentText());
		blogTextPane.setBounds(11, 44, 345, 234);
		add(blogTextPane);

	
	}
}

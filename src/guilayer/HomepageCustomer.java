package guilayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.ImageIcon;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;

import controllayer.ManageBlogController;
import controllayer.ManageVideoController;
import doryan.windowsnotificationapi.fr.Notification;
import modellayer.AuthenticatedUser;
import modellayer.Blog;
import modellayer.PersonTypes;
import modellayer.Video;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.TrayIcon.MessageType;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class HomepageCustomer extends JFrame {

	private JPanel contentPane;
	private SideBarCustomer sideBarCustomer;
	private SideBarEmployee sideBarEmployee;
	private ManageVideoController manageVideoController = new ManageVideoController();
	private ManageBlogController manageBlogController = new ManageBlogController();

	/**
	 * Create the frame.
	 */
	public HomepageCustomer() {
		try {
			Notification.sendNotification("Office Fitness", "DO EXERCISE!", MessageType.INFO);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		setTitle("Homepage");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 440, 722);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		Dimension d = new Dimension(440, 930);
		panel.setPreferredSize(d);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			sideBarCustomer = new SideBarCustomer();
			((JPanel) sideBarCustomer).setSize(0, 740);
			panel.add((JPanel) sideBarCustomer);
			((JPanel) sideBarCustomer).setVisible(false);
		} else {
			sideBarEmployee = new SideBarEmployee();
			((JPanel) sideBarEmployee).setSize(0, 740);
			panel.add((JPanel) sideBarEmployee);
			((JPanel) sideBarEmployee).setVisible(false);
		}

		JButton sidebarButton = new JButton("");
		sidebarButton.setBounds(10, 10, 43, 39);
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);

		sidebarButton.addActionListener(e -> {
			if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
				((JPanel) sideBarCustomer).setVisible(true);
				sideBarCustomer.runSidebar();
			} else {
				((JPanel) sideBarEmployee).setVisible(true);
				sideBarEmployee.runSidebar();
			}
		});

		JLabel logoLabel = new JLabel("");
		logoLabel.setBounds(139, 2, 280, 96);
		logoLabel.setIcon(new ImageIcon(HomepageCustomer.class.getResource("/images/logo.png")));

		VideoPanel latestVideoPanel = new VideoPanel(getLatestVideo());

		latestVideoPanel.setBounds(10, 133, 400, 370);
		latestVideoPanel.setVisible(true);

		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			latestVideoPanel.deleteVideoButton.setVisible(false);
			latestVideoPanel.editVideoButton.setVisible(false);
			latestVideoPanel.textPane.setSize(378, 58);
		}
		// panel.set
		panel.add(latestVideoPanel);

		BlogPanel latestBlogPanel = new BlogPanel(getLatestBlog());
		// 315
		latestBlogPanel.setBounds(10, 547, 400, 370);
		latestBlogPanel.setVisible(true);

		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			latestBlogPanel.deleteBlogButton.setVisible(false);
			latestBlogPanel.editBlogButton.setVisible(false);
			latestBlogPanel.textPane.setSize(378, 58);
		}
		// panel.set
		panel.add(latestBlogPanel);

		sidebarButton.setBackground(SystemColor.controlHighlight);
		sidebarButton.setIcon(new ImageIcon(HomepageCustomer.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setSelectedIcon(null);
		contentPane.setLayout(null);
		panel.add(sideBarCustomer);
		panel.add(sidebarButton);
		panel.add(logoLabel);

		JLabel NewLessonLabel = new JLabel("Newest Lesson");
		NewLessonLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		NewLessonLabel.setBounds(10, 101, 139, 28);
		panel.add(NewLessonLabel);

		JLabel NewBlogLabel = new JLabel("Newest Blog Post");
		NewBlogLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		NewBlogLabel.setBounds(10, 513, 139, 28);
		panel.add(NewBlogLabel);

		panel.setComponentZOrder(sideBarCustomer, 0);
		panel.setComponentZOrder(latestVideoPanel, 1);
		panel.setComponentZOrder(latestBlogPanel, 2);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				scrollPane.getVerticalScrollBar().setValue(0);
			}
		});

	}

	public Video getLatestVideo() {
		Video latestVideo = new Video(null, null, null, null, 0);
		ArrayList<Video> allVideos = manageVideoController.retrieveAllVideos();
		for (Video video : allVideos) {
			if (video.getId() > latestVideo.getId()) {
				latestVideo = video;
			}
		}
		return latestVideo;
	}

	public Blog getLatestBlog() {
		Blog latestBlog = new Blog(null, null, null, null, null);
		ArrayList<Blog> allBlogs = manageBlogController.retrieveAllBlogs();
		for (Blog blog : allBlogs) {
			if (blog.getId() > latestBlog.getId()) {
				latestBlog = blog;
			}
		}
		return latestBlog;
	}
}

package guilayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.ManageBlogController;
import modellayer.AuthenticatedUser;
import modellayer.Blog;
import modellayer.PersonTypes;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllBlogsEmployee extends JFrame {
	private ManageBlogController manageBlogController = new ManageBlogController();
	
	private JPanel contentPane;
	private ArrayList<Blog> allBlogs = manageBlogController.retrieveAllBlogs();

	private SideBarCustomer sideBarCustomer;
	private SideBarEmployee sideBarEmployee;

	/**
	 * Create the frame.
	 */
	public AllBlogsEmployee() {
		setTitle("Blogs");
		ArrayList<BlogPanel> allBlogPanels = createAllBlogPanels();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 440, 750);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		Dimension d = new Dimension(440,750);
		panel.setPreferredSize(d);
		panel.setLayout(null);
		scrollPane.setViewportView(panel);

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
		
		JLabel logoImage = new JLabel(new ImageIcon(AllBlogsEmployee.class.getResource("/images/logo.png")));
		logoImage.setBounds(131, 10, 300, 102);
		panel.add(logoImage);
		
		JLabel lblAllBlogs = new JLabel("All Blogs");
		lblAllBlogs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllBlogs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAllBlogs.setBounds(177, 145, 86, 26);
		panel.add(lblAllBlogs);
		
		JLabel lblNewLabel_1 = new JLabel("Sort by:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(50, 181, 62, 34);
		panel.add(lblNewLabel_1);
		
		String[] filterTypes = {"Newest added", "Oldest added", "Most watched"};
		JComboBox comboBox = new JComboBox(filterTypes);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(122, 181, 196, 34);
		panel.add(comboBox);
		
		JButton addBlogButton = new JButton(new ImageIcon(AllBlogsEmployee.class.getResource("/images/addVideoButton.png")));
		addBlogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateBlog blog = new CreateBlog();
				blog.setLocationRelativeTo(null);
				blog.setVisible(true);
				dispose();
			}
		});
		addBlogButton.setOpaque(false);
		addBlogButton.setBorderPainted(false);
		addBlogButton.setBackground(Color.WHITE);
		addBlogButton.setBounds(178, 220, 83, 59);
		panel.add(addBlogButton);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
					((JPanel) sideBarCustomer).setVisible(true);
					sideBarCustomer.runSidebar();
				} else {
					((JPanel) sideBarEmployee).setVisible(true);
					sideBarEmployee.runSidebar();
				}
			}
		});
		sidebarButton.setIcon(new ImageIcon(AllBlogsEmployee.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 45, 39);
		panel.add(sidebarButton);
		
		int yPosition = 300;
		int height = 100;
		
		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			addBlogButton.setVisible(false);
			yPosition = 240;
		}
		
		for (BlogPanel blogPanel : allBlogPanels) {
			
			blogPanel.setBounds(10, yPosition, 400, 370);
			blogPanel.setVisible(true);
			yPosition = yPosition + 380;	
			
			d.setSize(440, height + yPosition);
			if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
				blogPanel.deleteBlogButton.setVisible(false);
				blogPanel.editBlogButton.setVisible(false);
				blogPanel.textPane.setSize(378, 58);
			}
			panel.add(blogPanel);
			}
		
		SwingUtilities.invokeLater(new Runnable() {
			   public void run() { 
			       scrollPane.getVerticalScrollBar().setValue(0);
			   }
		});
	}
	
	public ArrayList<BlogPanel> createAllBlogPanels() {
		ArrayList<BlogPanel> allBlogPanels = new ArrayList<>();
		for (Blog blog : allBlogs) {
			BlogPanel blogPanel = new BlogPanel(blog);
			allBlogPanels.add(blogPanel);
		}
		return allBlogPanels;
	}
}

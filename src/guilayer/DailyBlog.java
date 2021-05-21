package guilayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import helpers.Slider;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import modellayer.AuthenticatedUser;
import modellayer.Blog;
import modellayer.PersonTypes;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

public class DailyBlog extends JFrame {

	private JPanel contentPane;
	private SideBarCustomer sideBarCustomer;
	private SideBarEmployee sideBarEmployee;

	/**
	 * Create the frame.
	 */
	public DailyBlog(Blog blog) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Blog");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 440, 722);
		contentPane.add(scrollPane);
		
		Dimension d = new Dimension(440, 722);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(d);
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
		panel.setLayout(null);
		sidebarButton.setIcon(new ImageIcon(DailyBlog.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 47, 39);
		panel.add(sidebarButton);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(DailyBlog.class.getResource("/images/logo.png")));
		logo.setBounds(150, 10, 278, 98);
		panel.add(logo);
		
		JLabel titleLbl = new JLabel(blog.getHeader());
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		titleLbl.setBounds(23, 115, 252, 32);
		panel.add(titleLbl);
		
		JLabel dateLbl = new JLabel(blog.getDateIssued().toString());
		dateLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLbl.setForeground(Color.GRAY);
		dateLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		dateLbl.setBounds(304, 122, 111, 21);
		panel.add(dateLbl);
		
		JTextPane contentTextPane = new JTextPane();
		contentTextPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentTextPane.setText(blog.getContentText());
		contentTextPane.setBackground(SystemColor.menu);
		contentTextPane.setEditable(false);
		contentTextPane.setBounds(23, 402, 392, 338);
		panel.add(contentTextPane);
		
		File file = new File(blog.getImagePath());
		if(file.exists()) {
			ImageIcon imageIcon = new ImageIcon(blog.getImagePath()); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(320, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			
			JLabel blogImage = new JLabel(imageIcon);
			blogImage.setBounds(52, 158, 320, 180);
			panel.add(blogImage);
		}
		
		d.setSize(440, 722 + contentTextPane.getHeight());
	}
}

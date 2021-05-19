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
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import modellayer.AuthenticatedUser;
import modellayer.Blog;
import modellayer.PersonTypes;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

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
		scrollPane.setBounds(0, 0, 440, 722);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
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
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleLbl.setBounds(23, 115, 185, 32);
		panel.add(titleLbl);
		
		JLabel dateLbl = new JLabel(blog.getDateIssued().toString());
		dateLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		dateLbl.setForeground(Color.GRAY);
		dateLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		dateLbl.setBounds(317, 122, 98, 21);
		panel.add(dateLbl);
		
		JTextPane contentTextPane = new JTextPane();
		contentTextPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentTextPane.setText(blog.getContentText());
		contentTextPane.setBackground(SystemColor.menu);
		contentTextPane.setEditable(false);
		contentTextPane.setBounds(23, 402, 392, 172);
		panel.add(contentTextPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(23, 157, 392, 219);
		panel.add(panel_1);
		
		
	}
}

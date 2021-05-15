package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import modellayer.Blog;

public class DailyBlog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

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
		setTitle("Daily exercise");
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(DailyBlog.class.getResource("/images/logo.png")));
		logo.setBounds(139, 26, 297, 111);
		contentPane.add(logo);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.setIcon(new ImageIcon(DailyBlog.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 43, 39);
		contentPane.add(sidebarButton);
		
		JLabel titleLbl = new JLabel(blog.getHeader());
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		titleLbl.setBounds(35, 148, 122, 31);
		contentPane.add(titleLbl);
		
		JPanel panel = new JPanel();
		panel.setBounds(93, 197, 268, 147);
		contentPane.add(panel);
		panel.add(new BlogImage(blog.getImagePath()));
		
		JLabel dateLbl = new JLabel(blog.getDateIssued().toString());
		dateLbl.setForeground(Color.GRAY);
		dateLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		dateLbl.setBounds(317, 157, 98, 13);
		contentPane.add(dateLbl);
		
		JTextPane txtDescription = new JTextPane();
		txtDescription.setBackground(SystemColor.menu);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setText(blog.getContentText());
		txtDescription.setBounds(35, 366, 374, 344);
		JScrollPane jsp = new JScrollPane(txtDescription);
		//contentPane.add(txtDescription);
		contentPane.add(jsp);
	}
}

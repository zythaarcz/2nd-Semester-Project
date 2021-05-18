package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;
import modellayer.Video;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.SwingConstants;

public class DailyExercise extends JFrame {

	private JPanel contentPane;
	Object sidebar;


	/**
	 * Create the frame.
	 */
	public DailyExercise(Video video) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Daily exercise");
		
		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			sidebar = new SideBarCustomer();
		} else {
			sidebar = new SideBarEmployee();
		}
		((JPanel) sidebar).setSize(0, 740);
		contentPane.add((JPanel) sidebar);
		((JPanel) sidebar).setVisible(false);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(DailyExercise.class.getResource("/images/logo.png")));
		logo.setBounds(139, 10, 297, 111);
		contentPane.add(logo);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JPanel) sidebar).setVisible(true);
				((JPanel) sidebar).setSize(225, 740);				
			}
		});
		sidebarButton.setIcon(new ImageIcon(DailyExercise.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 43, 39);
		contentPane.add(sidebarButton);
		
		JButton btnAllLessons = new JButton("Browse all lessons");
		btnAllLessons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllVideosEmployee avEmployee = new AllVideosEmployee();
				avEmployee.setVisible(true);
				dispose();
			}
		});
		btnAllLessons.setRolloverEnabled(false);
		btnAllLessons.setForeground(Color.BLACK);
		btnAllLessons.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAllLessons.setBackground(new Color(255, 208, 32));
		btnAllLessons.setBounds(118, 654, 200, 31);
		contentPane.add(btnAllLessons);
		
		JButton btnProgress = new JButton("See my progress");
		btnProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO connect with progress
				JOptionPane.showMessageDialog(btnProgress, "Feature not implemented yet.");
			}
		});
		btnProgress.setRolloverEnabled(false);
		btnProgress.setForeground(Color.BLACK);
		btnProgress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnProgress.setBackground(new Color(255, 208, 32));
		btnProgress.setBounds(118, 613, 200, 31);
		contentPane.add(btnProgress);
		
		JLabel titleLbl = new JLabel("");
		titleLbl.setText(video.getHeader());
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		titleLbl.setBounds(31, 121, 175, 31);
		contentPane.add(titleLbl);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 190, 374, 206);
		contentPane.add(panel);
		
		JLabel pointsLbl = new JLabel("");
		pointsLbl.setText("+" + video.getPointsForCompletion()+ " Points");
		pointsLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		pointsLbl.setForeground(Color.GREEN);
		pointsLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		pointsLbl.setBounds(300, 131, 105, 21);
		contentPane.add(pointsLbl);
		
		JTextPane txtDescription = new JTextPane();
		txtDescription.setText(video.getShortDescription());
		txtDescription.setEditable(false);
		txtDescription.setBackground(SystemColor.menu);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque in facilisis diam. Aliquam imperdiet risus urna, laoreet posuere ante lobortis at. Vestibulum eu odio ultrices, feugiat elit in, rutrum sem. Aenean non massa velit. Nam posuere maximus felis, a congue elit cursus vitae.......");
		txtDescription.setBounds(31, 420, 374, 85);
		contentPane.add(txtDescription);
		
		JLabel exerciseDoneLbl = new JLabel("You have already done this exercise.");
		exerciseDoneLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		exerciseDoneLbl.setBounds(80, 567, 276, 36);
		contentPane.add(exerciseDoneLbl);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDone.setRolloverEnabled(false);
		btnDone.setForeground(Color.BLACK);
		btnDone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDone.setBackground(new Color(255, 208, 32));
		btnDone.setBounds(300, 526, 105, 31);
		contentPane.add(btnDone);
	}
}

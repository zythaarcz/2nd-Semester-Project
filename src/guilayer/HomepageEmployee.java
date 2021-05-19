package guilayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;

import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class HomepageEmployee extends JFrame {

	private JPanel contentPane;
	private SideBarEmployee sideBarEmployee;
	private SideBarCustomer sideBarCustomer;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomepageEmployee frame = new HomepageEmployee();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomepageEmployee() {
		setTitle("Homepage");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		
		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			sideBarCustomer = new SideBarCustomer();
			((JPanel) sideBarCustomer).setSize(0, 740);
			contentPane.add((JPanel) sideBarCustomer);
			((JPanel) sideBarCustomer).setVisible(false);
		} else {
			sideBarEmployee = new SideBarEmployee();
			((JPanel) sideBarEmployee).setSize(0, 740);
			contentPane.add((JPanel) sideBarEmployee);
			((JPanel) sideBarEmployee).setVisible(false);
		}
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(HomepageEmployee.class.getResource("/images/logo.png")));
		
		JPanel statisticsPanel = new JPanel();
		statisticsPanel.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		
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
		sidebarButton.setBackground(SystemColor.controlHighlight);
		sidebarButton.setIcon(new ImageIcon(HomepageEmployee.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setSelectedIcon(null);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(sidebarButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
							.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(statisticsPanel, GroupLayout.PREFERRED_SIZE, 417, Short.MAX_VALUE)))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sidebarButton)
						.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addComponent(statisticsPanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(221, Short.MAX_VALUE))
		);
		
		JLabel easyAccessLabel = new JLabel("Easy Access");
		easyAccessLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton manageVideosButton = new JButton("Manage Videos");
		manageVideosButton.setBorderPainted(false);
		manageVideosButton.setSelected(true);
		manageVideosButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		manageVideosButton.setBackground(Color.decode("#FFD020"));
		manageVideosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllVideosEmployee avEmployee = new AllVideosEmployee();
				avEmployee.setVisible(true);
				dispose();
			}
		});
		
		JButton manageBlogsButton = new JButton("Manage Blogs");
		manageBlogsButton.setRolloverEnabled(false);
		manageBlogsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllBlogsEmployee abEmployee = new AllBlogsEmployee();
				abEmployee.setVisible(true);
				dispose();
			}
		});
		manageBlogsButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		manageBlogsButton.setBackground(Color.decode("#FFD020"));
		manageBlogsButton.setBorderPainted(false);
		
		JButton dietConsultationButton = new JButton("Diet Consultation");
		dietConsultationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO make manager version of diet consultation
				JOptionPane.showMessageDialog(contentPane, "Feature not implemented yet.");
			}
		});
		dietConsultationButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		dietConsultationButton.setBackground(Color.decode("#FFD020"));
		dietConsultationButton.setBorderPainted(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(manageVideosButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(manageBlogsButton, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(dietConsultationButton))
						.addComponent(easyAccessLabel))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(easyAccessLabel)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(manageVideosButton, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
						.addComponent(dietConsultationButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(manageBlogsButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel statisticsLabel = new JLabel("Statistics");
		statisticsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton calendarButton = new JButton("Calendar");
		calendarButton.setBackground(Color.decode("#FFD020"));
		calendarButton.setBorderPainted(false);
		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Feature not implemented yet.");
			}
		});
		calendarButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel newUsersLabel = new JLabel("New users:");
		newUsersLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel activeUsersLabel = new JLabel("Active users:");
		activeUsersLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel mostWatchedVideoLabel = new JLabel("Most watched video:");
		mostWatchedVideoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel mostReadBlogLabel = new JLabel("Most read blog:");
		mostReadBlogLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel newUsersCountLabel = new JLabel("24");
		
		JLabel activeUsersCountLabel = new JLabel("22");
		
		JLabel mostWatchedVideoCountLabel = new JLabel("Morning workout");
		
		JLabel mostReadBlogCountLabel = new JLabel("Fitness tips");
		GroupLayout gl_statisticsPanel = new GroupLayout(statisticsPanel);
		gl_statisticsPanel.setHorizontalGroup(
			gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statisticsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_statisticsPanel.createSequentialGroup()
							.addComponent(statisticsLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(194)
							.addComponent(calendarButton)
							.addContainerGap())
						.addGroup(gl_statisticsPanel.createSequentialGroup()
							.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_statisticsPanel.createSequentialGroup()
											.addComponent(newUsersLabel, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
											.addGap(82))
										.addGroup(gl_statisticsPanel.createSequentialGroup()
											.addComponent(activeUsersLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addGap(92)))
									.addGroup(gl_statisticsPanel.createSequentialGroup()
										.addComponent(mostWatchedVideoLabel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addGap(30)))
								.addGroup(gl_statisticsPanel.createSequentialGroup()
									.addComponent(mostReadBlogLabel)
									.addGap(73)))
							.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_statisticsPanel.createSequentialGroup()
										.addComponent(activeUsersCountLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_statisticsPanel.createSequentialGroup()
										.addComponent(newUsersCountLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addGap(189)))
								.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(mostReadBlogCountLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(mostWatchedVideoCountLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
							.addGap(378))))
		);
		gl_statisticsPanel.setVerticalGroup(
			gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statisticsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(calendarButton)
						.addGroup(gl_statisticsPanel.createSequentialGroup()
							.addComponent(statisticsLabel)
							.addGap(27)
							.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(newUsersLabel)
								.addComponent(newUsersCountLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(activeUsersLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(activeUsersCountLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(mostWatchedVideoLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(mostWatchedVideoCountLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_statisticsPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(mostReadBlogLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
								.addComponent(mostReadBlogCountLabel))))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		statisticsPanel.setLayout(gl_statisticsPanel);
		contentPane.setLayout(gl_contentPane);
	}
}

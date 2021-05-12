package guilayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class HomepageCustomer extends JFrame {

	private JPanel contentPane;
	private SideBarEmployee sidebar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HomepageCustomer() {
		setTitle("Homepage");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		
		SideBarCustomer sidebar = new SideBarCustomer();
		sidebar.setSize(0, 740);
		contentPane.add(sidebar);
		sidebar.setVisible(false);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(HomepageCustomer.class.getResource("/images/logo.png")));
		
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
			sidebar.setVisible(true);
			sidebar.setSize(225, 740);
			}
		});
		sidebarButton.setBackground(SystemColor.controlHighlight);
		sidebarButton.setIcon(new ImageIcon(HomepageCustomer.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setSelectedIcon(null);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(statisticsPanel, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(sidebarButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
							.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(sidebarButton)))
					.addGap(18)
					.addComponent(statisticsPanel, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		
		JLabel dailyBlogLabel = new JLabel("Daily Blog");
		dailyBlogLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton manageBlogsButton = new JButton("Read more");
		manageBlogsButton.setRolloverEnabled(false);
		manageBlogsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		manageBlogsButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		manageBlogsButton.setBackground(Color.decode("#FFD020"));
		manageBlogsButton.setBorderPainted(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(dailyBlogLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(125)
							.addComponent(manageBlogsButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(dailyBlogLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
					.addComponent(manageBlogsButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel dailyExerciseLabel = new JLabel("Daily Exercise");
		dailyExerciseLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_statisticsPanel = new GroupLayout(statisticsPanel);
		gl_statisticsPanel.setHorizontalGroup(
			gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statisticsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(dailyExerciseLabel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		gl_statisticsPanel.setVerticalGroup(
			gl_statisticsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statisticsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(dailyExerciseLabel)
					.addContainerGap(213, Short.MAX_VALUE))
		);
		statisticsPanel.setLayout(gl_statisticsPanel);
		contentPane.setLayout(gl_contentPane);
	}
}

package guilayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Rectangle;

public class SideBarEmployee extends JPanel {

	/**
	 * Create the panel.
	 */
	public SideBarEmployee() {
		ArrayList<JButton> buttons = new ArrayList();

		setAutoscrolls(true);
		setBackground(Color.DARK_GRAY);
		
		SideBarCustomer customerPreview = new SideBarCustomer();
		customerPreview.setSize(0, 740);
		customerPreview.setVisible(false);
		add (customerPreview);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.setRolloverEnabled(false);
		sidebarButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setSize(0, 750);
			}
		});
		sidebarButton.setIcon(new ImageIcon(SideBarEmployee.class.getResource("/images/arrowIconDS.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.DARK_GRAY);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.DARK_GRAY);
		
		JButton viewProfileButton = new JButton("View Profile");
		buttons.add(viewProfileButton);
		viewProfileButton.setRolloverEnabled(false);
		viewProfileButton.setBackground(Color.decode("#FFD020"));
		viewProfileButton.setBorderPainted(false);
		viewProfileButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton manageVideosButton = new JButton("Manage Videos");
		buttons.add(manageVideosButton);
		manageVideosButton.setRolloverEnabled(false);
		manageVideosButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		manageVideosButton.setBorderPainted(false);
		manageVideosButton.setBackground(new Color(255, 208, 32));
		
		JButton manageBlogsButton = new JButton("Manage Blogs");
		buttons.add(manageBlogsButton);
		manageBlogsButton.setRolloverEnabled(false);
		manageBlogsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		manageBlogsButton.setBorderPainted(false);
		manageBlogsButton.setBackground(new Color(255, 208, 32));
		
		JButton logOutButton = new JButton("Log out");
		buttons.add(logOutButton);
		logOutButton.setRolloverEnabled(false);
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		logOutButton.setBorderPainted(false);
		logOutButton.setBackground(new Color(255, 208, 32));
		
		JButton dietConsultationButton = new JButton("Diet Consultation");
		buttons.add(dietConsultationButton);
		dietConsultationButton.setRolloverEnabled(false);
		dietConsultationButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		dietConsultationButton.setBorderPainted(false);
		dietConsultationButton.setBackground(new Color(255, 208, 32));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SideBarEmployee.class.getResource("/images/profilePictureSmall.png")));
		lblNewLabel.setForeground(Color.WHITE);
		
		JButton customerPreviewButton = new JButton("Customer Preview");
		customerPreviewButton.setIconTextGap(1);
		customerPreviewButton.setMargin(new Insets(2, 6, 2, 6));
		customerPreviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!customerPreview.isVisible()) {
					customerPreviewButton.setText("Manager view");
					customerPreview.setVisible(true);
					customerPreview.setSize(225,740);
					setComponentZOrder(customerPreviewButton, 0);
					setComponentZOrder(sidebarButton, 0);
					for (JButton jButton : buttons) {
						jButton.setVisible(false);
					}
					
				} else {
					customerPreviewButton.setText("Customer preview");
					customerPreview.setVisible(false);
					for (JButton jButton : buttons) {
						jButton.setVisible(true);
					}
				}
			}
			
		});
		customerPreviewButton.setOpaque(true);
		customerPreviewButton.setBorderPainted(false);
		customerPreviewButton.setBackground(new Color(255, 208, 32));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(sidebarButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
									.addComponent(customerPreviewButton))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(dietConsultationButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(viewProfileButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(manageVideosButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(manageBlogsButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(customerPreviewButton)
						.addComponent(sidebarButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewProfileButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(manageVideosButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(manageBlogsButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addComponent(dietConsultationButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
					.addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		setLayout(groupLayout);

	}
}

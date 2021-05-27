package guilayer;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllayer.ManageVideoController;
import helpers.Slider;
import modellayer.AuthenticatedUser;
import modellayer.Video;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SideBarCustomer extends Slider{


	private ManageVideoController manageVideoController = new ManageVideoController();

	/**
	 * Create the panel.
	 */
	public SideBarCustomer() {
		
		setAutoscrolls(true);
		setBackground(Color.DARK_GRAY);
		
		JButton blogButton = new JButton("Blog");
		blogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllBlogsEmployee allBlogs = new AllBlogsEmployee();
				allBlogs.setLocationRelativeTo(null);
				allBlogs.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		blogButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		blogButton.setBorderPainted(false);
		blogButton.setBackground(new Color(255, 208, 32));
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(e -> {
					Thread th = new Thread() {
			            @Override
			            public void run(){
			                try {
			                    
			                    for ( int i = 225; i >= 0; i--){
			                        Thread.sleep(1);
			                        setSize(i, 740);
			                    }
			                } catch (Exception e) {
			                    JOptionPane.showMessageDialog(null, e);
			                }
			            };
			            
				};th.start();
		});
		sidebarButton.setIcon(new ImageIcon(SideBarCustomer.class.getResource("/images/arrowIconDS.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.DARK_GRAY);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.DARK_GRAY);
		
		JButton logOutButton = new JButton("Log out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthenticatedUser.getInstance().setCurrentUser(null);
				Authentication authentication = new Authentication();
				authentication.setLocationRelativeTo(null);
				authentication.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		logOutButton.setBorderPainted(false);
		logOutButton.setBackground(new Color(255, 208, 32));
		
		JButton viewProfileButton = new JButton("View Profile");
		viewProfileButton.addActionListener(e -> {
				Profile profile = new Profile();
				profile.setLocationRelativeTo(null);
				profile.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
		});
		viewProfileButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		viewProfileButton.setBorderPainted(false);
		viewProfileButton.setBackground(new Color(255, 208, 32));
		
		JButton myProgressButton = new JButton("My Progress");
		myProgressButton.addActionListener(e -> {
				//TODO connect with progress
				JOptionPane.showMessageDialog(((JFrame) getTopLevelAncestor()), "Feature not implemented yet.");
		});
		myProgressButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		myProgressButton.setBorderPainted(false);
		myProgressButton.setBackground(new Color(255, 208, 32));
		
		JButton dailyExerciseButton = new JButton("Daily Exercise");
		dailyExerciseButton.addActionListener(e -> {
				DailyExercise dailyExercise = new DailyExercise(getLatestVideo());
				dailyExercise.setLocationRelativeTo(null);
				dailyExercise.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
		});
		dailyExerciseButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		dailyExerciseButton.setBorderPainted(false);
		dailyExerciseButton.setBackground(new Color(255, 208, 32));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SideBarCustomer.class.getResource("/images/profilePictureSmall.png")));
		lblNewLabel.setForeground(Color.WHITE);
		
		JButton leaderboardButton = new JButton("Leaderboard");
		leaderboardButton.addActionListener(e -> {
				//TODO connect when leaderboard is implemented
				JOptionPane.showMessageDialog(((JFrame) getTopLevelAncestor()), "Feature not implemented yet.");
		});
		leaderboardButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		leaderboardButton.setBorderPainted(false);
		leaderboardButton.setBackground(new Color(255, 208, 32));
		
		JButton allLessonsButton = new JButton("All Lessons");
		allLessonsButton.addActionListener(e -> {
				AllVideosEmployee allVideos = new AllVideosEmployee();
				allVideos.setLocationRelativeTo(null);
				allVideos.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
		});
		allLessonsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		allLessonsButton.setBorderPainted(false);
		allLessonsButton.setBackground(new Color(255, 208, 32));
		
		JButton dietConsultationButton = new JButton("Diet Consultation");
		dietConsultationButton.addActionListener(e -> {
				DietConsultation dietConsultation = new DietConsultation();
				dietConsultation.setLocationRelativeTo(null);
				dietConsultation.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
		});
		dietConsultationButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		dietConsultationButton.setBorderPainted(false);
		dietConsultationButton.setBackground(new Color(255, 208, 32));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sidebarButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel))
						.addComponent(viewProfileButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(myProgressButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(leaderboardButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(allLessonsButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(dietConsultationButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(dailyExerciseButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(blogButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(sidebarButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(viewProfileButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(myProgressButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(dailyExerciseButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(blogButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addComponent(leaderboardButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(allLessonsButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dietConsultationButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
		);
		setLayout(groupLayout);

	}
	
	public Video getLatestVideo() {
		Video latestVideo = new Video(null, null, null, null, 0);
		ArrayList<Video> allVideos = manageVideoController .retrieveAllVideos();
		for (Video video : allVideos) {
			if (video.getId() > latestVideo.getId()) {
				latestVideo = video;
			}
		}
		return latestVideo;
	}
	
	public void runSidebar() {
		Thread th = new Thread() {
            @Override
            public void run(){
                try {
                    
                    for ( int i = 0; i <= 225; i++){
                        Thread.sleep(1);
                        setSize(i, 740);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            };
            
		};th.start();
	}

}

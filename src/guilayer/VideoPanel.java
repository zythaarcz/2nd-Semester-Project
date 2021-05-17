package guilayer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;

import controllayer.ManageVideoController;
import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;
import modellayer.Video;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VideoPanel extends JPanel {
	
	private ManageVideoController manageVideoController = new ManageVideoController();

	/**
	 * Create the panel.
	 */
	public VideoPanel(Video video) {
		setBackground(Color.ORANGE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(11, 42, 378, 245);
		add(panel);
		
		JLabel nameLabel = new JLabel("");
		nameLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DailyExercise dailyExercise = new DailyExercise(video);
				dailyExercise.setVisible(true);
				setSize(0, 750);
				((JFrame) getTopLevelAncestor()).dispose();
			}
		});
		nameLabel.setText(video.getHeader());
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLabel.setBounds(11, 19, 378, 13);
		add(nameLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setText(video.getShortDescription());
		textPane.setEditable(false);
		textPane.setBounds(11, 295, 345, 58);
		add(textPane);
		
		
		if(AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Employee) {
			JButton editVideoButton = new JButton("");
			editVideoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EditVideo editVideo = new EditVideo(video);
					editVideo.setVisible(true);
					((JFrame) getTopLevelAncestor()).dispose();
				}
			});
			editVideoButton.setOpaque(false);
			editVideoButton.setBorderPainted(false);
			editVideoButton.setIcon(new ImageIcon(VideoPanel.class.getResource("/images/editVideoButton.png")));
			editVideoButton.setBounds(366, 297, 23, 21);
			add(editVideoButton);
			
			JButton deleteVideoButton = new JButton("");
			deleteVideoButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					manageVideoController.deleteVideo(video.getId());
					AllVideosEmployee allVideos = new AllVideosEmployee();
					allVideos.setVisible(true);
					((JFrame) getTopLevelAncestor()).dispose();
				}
			});
			deleteVideoButton.setIcon(new ImageIcon(VideoPanel.class.getResource("/images/deleteButton.png")));
			deleteVideoButton.setOpaque(false);
			deleteVideoButton.setBorderPainted(false);
			deleteVideoButton.setBounds(366, 332, 23, 21);
			add(deleteVideoButton);
		}
		
//		JButton editVideoButton = new JButton("");
//		editVideoButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				EditVideo editVideo = new EditVideo(video);
//				editVideo.setVisible(true);
//				((JFrame) getTopLevelAncestor()).dispose();
//			}
//		});
//		editVideoButton.setOpaque(false);
//		editVideoButton.setBorderPainted(false);
//		editVideoButton.setIcon(new ImageIcon(VideoPanel.class.getResource("/images/editVideoButton.png")));
//		editVideoButton.setBounds(366, 297, 23, 21);
//		add(editVideoButton);
//		
//		JButton deleteVideoButton = new JButton("");
//		deleteVideoButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				manageVideoController.deleteVideo(video.getId());
//				AllVideosEmployee allVideos = new AllVideosEmployee();
//				allVideos.setVisible(true);
//				((JFrame) getTopLevelAncestor()).dispose();
//			}
//		});
//		deleteVideoButton.setIcon(new ImageIcon(VideoPanel.class.getResource("/images/deleteButton.png")));
//		deleteVideoButton.setOpaque(false);
//		deleteVideoButton.setBorderPainted(false);
//		deleteVideoButton.setBounds(366, 332, 23, 21);
//		add(deleteVideoButton);

	}
}

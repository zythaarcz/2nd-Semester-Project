package guilayer;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import controllayer.ManageVideoController;
import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;
import modellayer.Video;

import java.util.ArrayList;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AllVideosEmployee extends JFrame {
	ManageVideoController manageVideoController = new ManageVideoController();
	
	private JPanel contentPane;
	private JLabel logoImage;
	private CreateVideo createVideo;
	private EditVideo editVideo;
	
	private SideBarCustomer sideBarCustomer;
	private SideBarEmployee sideBarEmployee;
	
	ArrayList<Video> allVideos = manageVideoController.retrieveAllVideos();

	/**
	 * Create the frame.
	 */
	public AllVideosEmployee() {
		setTitle("All Lessons");
		ArrayList<VideoPanel> allVideoPanels = createAllVideoPanels();
		setResizable(false);
		createVideo= new CreateVideo();
		createVideo.setVisible(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 440, 750);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		Dimension d = new Dimension(440,750);
		panel.setPreferredSize(d);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

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
		
		
		logoImage = new JLabel(new ImageIcon(VideoCategories.class.getResource("/images/logo.png")));
		logoImage.setBounds(131, 10, 300, 102);
		panel.add(logoImage);
		
		JLabel lblNewLabel = new JLabel("All videos");
		lblNewLabel.setBounds(172, 145, 86, 26);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sort by:");
		lblNewLabel_1.setBounds(50, 194, 37, 13);
		panel.add(lblNewLabel_1);
		
		String[] filterTypes = {"Newest added", "Oldest added", "Most watched"};
		JComboBox comboBox = new JComboBox(filterTypes);
		comboBox.setBounds(92, 191, 196, 19);
		panel.add(comboBox);
		
		JButton addVideoButton = new JButton(new ImageIcon(AllVideosEmployee.class.getResource("/images/addVideoButton.png")));
		addVideoButton.setBounds(174, 235, 83, 59);
		addVideoButton.setOpaque(false);
		addVideoButton.setBorderPainted(false);
		addVideoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addVideoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createVideo.setVisible(true);
				dispose();
			}
		});
		addVideoButton.setBackground(SystemColor.window);
		panel.add(addVideoButton);
		
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
		sidebarButton.setIcon(new ImageIcon(AllVideosEmployee.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 45, 39);
		panel.add(sidebarButton);
		
		int yPosition = 300;
		int height = 100;
		
		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			addVideoButton.setVisible(false);
			yPosition = 240;
		}
		
		
		for (VideoPanel videoPanel : allVideoPanels) {
			
			videoPanel.setBounds(10, yPosition, 400, 370);
			videoPanel.setVisible(true);
			yPosition = yPosition + 380;
			
			
			d.setSize(440, height + yPosition);
			if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
				videoPanel.deleteVideoButton.setVisible(false);
				videoPanel.editVideoButton.setVisible(false);
				videoPanel.textPane.setSize(378, 58);
			}
			//panel.set
			panel.add(videoPanel);
			}		
	}
	public ArrayList<VideoPanel> createAllVideoPanels() {
		allVideos = manageVideoController.retrieveAllVideos();
		ArrayList<VideoPanel> allVideoPanels = new ArrayList<>();
		for (Video video : allVideos) {
			VideoPanel videoPanel = new VideoPanel(video);
			allVideoPanels.add(videoPanel);
		}
		return allVideoPanels;
	}
}

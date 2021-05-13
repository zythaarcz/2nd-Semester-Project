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
	
	ArrayList<Video> allVideos = manageVideoController.retrieveAllVideos();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllVideosEmployee frame = new AllVideosEmployee();
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
	public AllVideosEmployee() {
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
		scrollPane.setBounds(3, 0, 440, 750);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		Dimension d = new Dimension(440,750);
		panel.setPreferredSize(d);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);

		SideBarEmployee sidebar = new SideBarEmployee();
		sidebar.setSize(0, 740);
		panel.add(sidebar);
		sidebar.setVisible(false);
		
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
				sidebar.setVisible(true);
				sidebar.setSize(225, 740);
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
		int height = 750;
		
		
		for (VideoPanel videoPanel : allVideoPanels) {
			
			videoPanel.setBounds(10, yPosition, 400, 370);
			videoPanel.setVisible(true);
			yPosition = yPosition + 380;
			
			
			d.setSize(440, height + yPosition);
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

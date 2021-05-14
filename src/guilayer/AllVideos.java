package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.ManageVideoController;
import modellayer.Video;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AllVideos extends JFrame {
	ManageVideoController manageVideoController = new ManageVideoController();

	static Choice c;
	private JPanel contentPane;
	private JLabel logoImage;
	private AllVideosEmployee allVideosEmployee;

	ArrayList<Video> allVideos = manageVideoController.retrieveAllVideos();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllVideos frame = new AllVideos();
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
	public AllVideos() {
		ArrayList<VideoPanel> allVideoPanels = createAllVideoPanels();
		allVideosEmployee = new AllVideosEmployee();
		setResizable(false);
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
		
		logoImage = new JLabel(new ImageIcon(VideoCategories.class.getResource("/images/logo.png")));
		GridBagConstraints gbc_logoImage = new GridBagConstraints();
		gbc_logoImage.gridheight = 2;
		gbc_logoImage.gridwidth = 3;
		gbc_logoImage.anchor = GridBagConstraints.NORTHEAST;
		gbc_logoImage.insets = new Insets(0, 0, 5, 5);
		gbc_logoImage.gridx = 0;
		gbc_logoImage.gridy = 1;
		panel.add(logoImage, gbc_logoImage);

		JLabel lblNewLabel = new JLabel("All videos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sort by:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		String[] filterTypes = {"Newest added", "Oldest added", "Most watched"};
		JComboBox comboBox = new JComboBox(filterTypes);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 7;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{301, 0};
		gbl_panel_1.rowHeights = new int[]{150, 0, 27, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("New video");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Short description");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		SideBarCustomer sidebar = new SideBarCustomer();
		sidebar.setSize(0, 740);
		panel.add(sidebar);
		sidebar.setVisible(false);

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
		int height = 100;

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

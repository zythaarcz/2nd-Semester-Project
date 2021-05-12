package guilayer;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AllVideosEmployee extends JFrame {

	private JPanel contentPane;
	private JLabel logoImage;
	private CreateVideo createVideo;
	private EditVideo editVideo;
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
		createVideo= new CreateVideo();
		createVideo.setVisible(false);
		editVideo = new EditVideo();
		editVideo.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 450, 750);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{17, 32, 0, 98, 50, 97, 0, 35, 0};
		gbl_panel.rowHeights = new int[]{69, 74, 47, 43, 43, 10, 50, 30, 229, 230};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		panel.setLayout(gbl_panel);
		
		logoImage = new JLabel(new ImageIcon(VideoCategories.class.getResource("/images/logo.png")));
		GridBagConstraints gbc_logoImage = new GridBagConstraints();
		gbc_logoImage.gridwidth = 5;
		gbc_logoImage.anchor = GridBagConstraints.NORTHEAST;
		gbc_logoImage.insets = new Insets(0, 0, 5, 5);
		gbc_logoImage.gridx = 2;
		gbc_logoImage.gridy = 1;
		panel.add(logoImage, gbc_logoImage);
		
		JLabel lblNewLabel = new JLabel("All videos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sort by:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		String[] filterTypes = {"Newest added", "Oldest added", "Most watched"};
		JComboBox comboBox = new JComboBox(filterTypes);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 4;
		panel.add(comboBox, gbc_comboBox);
		
		JButton addVideoButton = new JButton(new ImageIcon(AllVideosEmployee.class.getResource("/images/addVideoButton.png")));
		addVideoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addVideoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createVideo.setVisible(true);
				dispose();
			}
		});
		addVideoButton.setBorderPainted(false);
		addVideoButton.setBackground(SystemColor.window);
		GridBagConstraints gbc_addVideoButton = new GridBagConstraints();
		gbc_addVideoButton.insets = new Insets(0, 0, 5, 5);
		gbc_addVideoButton.gridx = 4;
		gbc_addVideoButton.gridy = 6;
		panel.add(addVideoButton, gbc_addVideoButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 8;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{227, 31, 30, 0};
		gbl_panel_1.rowHeights = new int[]{150, 39, 41, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Video title");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton editVideoButton = new JButton(new ImageIcon(AllVideosEmployee.class.getResource("/images/editVideoButton.png")));
		editVideoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editVideoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editVideo.setVisible(true);
				dispose();
			}
		});
		editVideoButton.setBorderPainted(false);
		GridBagConstraints gbc_editVideoButton = new GridBagConstraints();
		gbc_editVideoButton.insets = new Insets(0, 0, 5, 5);
		gbc_editVideoButton.gridx = 1;
		gbc_editVideoButton.gridy = 1;
		panel_1.add(editVideoButton, gbc_editVideoButton);
		
		JButton deleteVideoButton = new JButton(new ImageIcon(AllVideosEmployee.class.getResource("/images/deleteButton.png")));
		deleteVideoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(scrollPane, "Are you sure you want to delete video?", "Delete video", JOptionPane.YES_NO_OPTION);
				
			}
		});
		deleteVideoButton.setBorderPainted(false);
		GridBagConstraints gbc_deleteVideoButton = new GridBagConstraints();
		gbc_deleteVideoButton.insets = new Insets(0, 0, 5, 0);
		gbc_deleteVideoButton.gridx = 2;
		gbc_deleteVideoButton.gridy = 1;
		panel_1.add(deleteVideoButton, gbc_deleteVideoButton);
		
		JLabel lblNewLabel_3 = new JLabel("Short description");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
	}
}

package guilayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.ManageVideoController;
import modellayer.Video;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EditVideo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtPoints;
	private JTextPane textPaneDescription;
	private JButton editButton_titleOK;
	private JButton editButton_descriptionOK;
	private JButton editButton_pointsOK;
	private AllVideosEmployee allVideos;
	private String newHeader;
	private String newDescription;
	private int newPoints;
	private String newCategory;
	private ManageVideoController manageVideoController;

	/**
	 * Create the frame.
	 */
	public EditVideo(Video video) {
		manageVideoController = new ManageVideoController();
				
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Edit video");
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(133, 27, 293, 111);
		logo.setIcon(new ImageIcon(EditVideo.class.getResource("/images/logo.png")));
		contentPane.add(logo);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allVideos = new AllVideosEmployee();
				allVideos.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoBack.setBounds(90, 625, 97, 33);
		btnGoBack.setBackground(Color.decode("#FFD020"));
		contentPane.add(btnGoBack);

		JButton editButton_title = new JButton("");
		editButton_title.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitle.setEditable(true);
				editButton_title.setVisible(false);
				editButton_title.setEnabled(false);
				editButton_titleOK.setVisible(true);
				editButton_titleOK.setEnabled(true);
			}
		});
		editButton_title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_title.setBounds(339, 195, 43, 43);
		editButton_title.setBackground(SystemColor.menu);
		contentPane.add(editButton_title);
		
		editButton_titleOK = new JButton("");
		editButton_titleOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTitle.setEditable(false);
				editButton_title.setVisible(true);
				editButton_title.setEnabled(true);
				editButton_titleOK.setVisible(false);
				editButton_titleOK.setEnabled(false);
				
				newHeader = txtTitle.getText();
				System.out.println(newHeader);
			}
		});
		editButton_titleOK.setEnabled(false);
		editButton_titleOK.setVisible(false);
		editButton_titleOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_titleOK.setBackground(SystemColor.menu);
		editButton_titleOK.setBounds(339, 195, 43, 43);
		contentPane.add(editButton_titleOK);

		JButton editButton_description = new JButton("");
		editButton_description.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneDescription.setEditable(true);
				editButton_description.setVisible(false);
				editButton_description.setEnabled(false);
				editButton_descriptionOK.setVisible(true);
				editButton_descriptionOK.setEnabled(true);
			}
		});
		editButton_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_description.setBackground(SystemColor.menu);
		editButton_description.setBounds(339, 273, 43, 43);
		contentPane.add(editButton_description);
		
		editButton_descriptionOK = new JButton("");
		editButton_descriptionOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneDescription.setEditable(false);
				editButton_description.setVisible(true);
				editButton_description.setEnabled(true);
				editButton_descriptionOK.setVisible(false);
				editButton_descriptionOK.setEnabled(false);
				
				newDescription = textPaneDescription.getText();
				System.out.println(newDescription);
			}
		});
		editButton_descriptionOK.setEnabled(false);
		editButton_descriptionOK.setVisible(false);
		editButton_descriptionOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_descriptionOK.setBackground(SystemColor.menu);
		editButton_descriptionOK.setBounds(339, 273, 43, 43);
		contentPane.add(editButton_descriptionOK);
		

		JButton editButton_points = new JButton("");
		editButton_points.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPoints.setEditable(true);
				editButton_points.setVisible(false);
				editButton_points.setEnabled(false);
				editButton_pointsOK.setVisible(true);
				editButton_pointsOK.setEnabled(true);
			}
		});
		editButton_points.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_points.setBackground(SystemColor.menu);
		editButton_points.setBounds(339, 450, 43, 43);
		contentPane.add(editButton_points);
		
		editButton_pointsOK = new JButton("");
		editButton_pointsOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPoints.setEditable(false);
				editButton_points.setVisible(true);
				editButton_points.setEnabled(true);
				editButton_pointsOK.setVisible(false);
				editButton_pointsOK.setEnabled(false);
				
				try {
					newPoints = Integer.parseInt(txtPoints.getText());
					System.out.println(newPoints);	
				}
				catch (NumberFormatException e) {
					txtPoints.setText(String.valueOf(video.getPointsForCompletion()));
					JOptionPane.showMessageDialog(contentPane, "You must enter numbers not characters!");
				}
			}
		});
		editButton_pointsOK.setEnabled(false);
		editButton_pointsOK.setVisible(false);
		editButton_pointsOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_pointsOK.setBackground(SystemColor.menu);
		editButton_pointsOK.setBounds(339, 450, 43, 43);
		contentPane.add(editButton_pointsOK);
		
		txtTitle = new JTextField();
		txtTitle.setText(video.getHeader());
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTitle.setEditable(false);
		txtTitle.setColumns(10);
		txtTitle.setBounds(70, 195, 269, 43);
		contentPane.add(txtTitle);
		
		txtPoints = new JTextField();
		txtPoints.setText(String.valueOf(video.getPointsForCompletion()));
		txtPoints.setHorizontalAlignment(SwingConstants.CENTER);
		txtPoints.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPoints.setEditable(false);
		txtPoints.setColumns(10);
		txtPoints.setBounds(70, 450, 269, 43);
		contentPane.add(txtPoints);
		
		JLabel lblPoints = new JLabel("Points for completion");
		lblPoints.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPoints.setBounds(70, 423, 185, 30);
		contentPane.add(lblPoints);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(70, 503, 162, 30);
		contentPane.add(lblCategory);
		
		String[] filterStrings = {"Uncategorized","Neck training", "Upper body training", "Lower body training", "Pain relief techniques"};
		JComboBox comboBoxCategory = new JComboBox(filterStrings);
		comboBoxCategory.setSelectedItem(video.getCategory());
		comboBoxCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCategory = String.valueOf(comboBoxCategory.getSelectedItem());
				System.out.println(newCategory);
			}
		});
		comboBoxCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCategory.setBounds(70, 528, 312, 43);
		contentPane.add(comboBoxCategory);
		
		JButton btnConfirmEdit = new JButton("Confirm");
		btnConfirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				if(newHeader == null && newDescription == null
						&& newPoints == 0 && newCategory == null) {
					JOptionPane.showMessageDialog(contentPane, "You did not changed any data, please check again!");
				} else {
					newHeader = txtTitle.getText();
					newDescription = textPaneDescription.getText();
					newCategory = comboBoxCategory.getSelectedItem().toString();
					newPoints = Integer.parseInt(txtPoints.getText());
					manageVideoController.updateVideoInformation(video.getId(), newHeader, newDescription, newCategory, newPoints);
					JOptionPane.showMessageDialog(contentPane, "The information about the video was successfully updated.");
				}
			}
		});
		btnConfirmEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmEdit.setBackground(new Color(255, 208, 32));
		btnConfirmEdit.setBounds(248, 625, 97, 33);
		contentPane.add(btnConfirmEdit);
		
		textPaneDescription = new JTextPane();
		textPaneDescription.setText(video.getShortDescription());
		textPaneDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneDescription.setEditable(false);
		textPaneDescription.setBounds(70, 273, 269, 139);
		contentPane.add(textPaneDescription);
		
		JLabel lblHeader = new JLabel("Header");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeader.setBounds(70, 170, 100, 30);
		contentPane.add(lblHeader);
		
		JLabel lblShortDescription = new JLabel("Short description");
		lblShortDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShortDescription.setBounds(70, 248, 162, 30);
		contentPane.add(lblShortDescription);
	}
}

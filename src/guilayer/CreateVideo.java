package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.ManageVideoController;
import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateVideo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUrl;
	private JTextField textFieldHeader;
	private JTextField textFieldPointsForCompletion;
	private JComboBox comboBoxCategory;
	private JTextPane textPaneShortDescription;
	
	private String urlString;
	private String headerString;
	private String shortDescriptionString;
	private String categoryString;
	private int pointsForCompletion;
	
	private JLabel errorIconURL;
	private JLabel errorIconPointsForCompletion;
	private JLabel errorIconHeader;
	private JLabel errorIconShortDescription;
		
	private CancelCreateVideo cancelCreateVideo;
	
	private SideBarEmployee sideBarEmployee;
	
	private ManageVideoController manageVideoController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateVideo frame = new CreateVideo();
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
	public CreateVideo() {
		cancelCreateVideo = new CancelCreateVideo(this);
		cancelCreateVideo.setVisible(false);
		manageVideoController = new ManageVideoController();
		
		setResizable(false);
		setTitle("Create video");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sideBarEmployee = new SideBarEmployee();
		sideBarEmployee.setSize(0, 740);
		sideBarEmployee.setVisible(false);
		contentPane.add(sideBarEmployee);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/logo.png")));
		logo.setBounds(130, 28, 287, 111);
		contentPane.add(logo);
		
		textFieldUrl = new JTextField();
		textFieldUrl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldUrl.setBounds(70, 171, 300, 43);
		contentPane.add(textFieldUrl);
		textFieldUrl.setColumns(10);
		
		textFieldHeader = new JTextField();
		textFieldHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldHeader.setColumns(10);
		textFieldHeader.setBounds(70, 249, 300, 43);
		contentPane.add(textFieldHeader);
		
		textPaneShortDescription = new JTextPane();
		textPaneShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneShortDescription.setBounds(70, 327, 300, 100);
		contentPane.add(textPaneShortDescription);
		
		String[] filterStrings = {"Uncategorized","Neck training", "Upper body training", "Lower body training", "Pain relief techniques"};
		comboBoxCategory = new JComboBox(filterStrings);
		comboBoxCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxCategory.setBounds(70, 462, 300, 43);
		contentPane.add(comboBoxCategory);
		
		textFieldPointsForCompletion = new JTextField();
		textFieldPointsForCompletion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPointsForCompletion.setColumns(10);
		textFieldPointsForCompletion.setBounds(70, 540, 300, 43);
		contentPane.add(textFieldPointsForCompletion);
		
		JLabel lblURL = new JLabel("URL");
		lblURL.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblURL.setBounds(70, 146, 100, 30);
		contentPane.add(lblURL);
		
		JLabel lblHeader = new JLabel("Header");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeader.setBounds(70, 224, 100, 30);
		contentPane.add(lblHeader);
		
		JLabel lblShortDescription = new JLabel("Short description");
		lblShortDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShortDescription.setBounds(70, 302, 146, 30);
		contentPane.add(lblShortDescription);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategory.setBounds(70, 437, 146, 30);
		contentPane.add(lblCategory);
		
		JLabel lblPointsForCompletion = new JLabel("Points for completion");
		lblPointsForCompletion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPointsForCompletion.setBounds(70, 515, 165, 30);
		contentPane.add(lblPointsForCompletion);
		
		JButton btnCreateVideo = new JButton("Create video");
		btnCreateVideo.setRolloverEnabled(false);
		btnCreateVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewVideo();	
			}
		});
		btnCreateVideo.setForeground(Color.BLACK);
		btnCreateVideo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateVideo.setBackground(new Color(255, 208, 32));
		btnCreateVideo.setBounds(120, 611, 200, 31);
		contentPane.add(btnCreateVideo);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setRolloverEnabled(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelCreateVideo();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(255, 208, 32));
		btnCancel.setBounds(120, 652, 200, 31);
		contentPane.add(btnCancel);
		
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sideBarEmployee.setVisible(true);
				sideBarEmployee.runSidebar();
			}
		});
		sidebarButton.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 45, 39);
		contentPane.add(sidebarButton);
		
		errorIconURL = new JLabel("");
		errorIconURL.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/iconError32px.png")));
		errorIconURL.setBounds(380, 171, 32, 43);
		errorIconURL.setVisible(false);
		contentPane.add(errorIconURL);
		
		errorIconPointsForCompletion = new JLabel("");
		errorIconPointsForCompletion.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/iconError32px.png")));
		errorIconPointsForCompletion.setBounds(380, 540, 32, 43);
		errorIconPointsForCompletion.setVisible(false);
		contentPane.add(errorIconPointsForCompletion);
		
		errorIconHeader = new JLabel("");
		errorIconHeader.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/iconError32px.png")));
		errorIconHeader.setBounds(380, 249, 32, 43);
		errorIconHeader.setVisible(false);
		contentPane.add(errorIconHeader);
		
		errorIconShortDescription = new JLabel("");
		errorIconShortDescription.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/iconError32px.png")));
		errorIconShortDescription.setBounds(380, 327, 32, 43);
		errorIconShortDescription.setVisible(false);
		contentPane.add(errorIconShortDescription);
	}
	
	private void createNewVideo() {	
		urlString = textFieldUrl.getText();
		headerString = textFieldHeader.getText();
		shortDescriptionString = textPaneShortDescription.getText();
		categoryString = String.valueOf(comboBoxCategory.getSelectedItem());
		
		boolean isURLValid = validateStrings(urlString, errorIconURL);
		boolean isHeaderValid = validateStrings(headerString, errorIconHeader);
		boolean isShortDescriptionValid = validateStrings(shortDescriptionString, errorIconShortDescription);
		
		if(isURLValid && isHeaderValid && isShortDescriptionValid) {
			try
			{
				pointsForCompletion = Integer.parseInt(textFieldPointsForCompletion.getText());
				
				//manageVideoController.createVideo(urlString, headerString, shortDescriptionString, categoryString, pointsForCompletion);
				
				System.out.println(urlString);
				System.out.println(headerString);
				System.out.println(shortDescriptionString);
				System.out.println(categoryString);
				System.out.println(pointsForCompletion);
				
				errorIconPointsForCompletion.setVisible(false);
				
				JOptionPane.showMessageDialog(contentPane, "Video was successfully created!");

				textFieldUrl.setText("");
				textFieldHeader.setText("");
				textPaneShortDescription.setText("");
				textFieldPointsForCompletion.setText("");
				comboBoxCategory.setSelectedItem("Uncategorized");
		    } 
		    catch (NumberFormatException e) 
		    {
		    	errorIconPointsForCompletion.setVisible(true);
		    	textFieldPointsForCompletion.setText("");
		    }
		}
			
	}
	
	private void cancelCreateVideo() {
		cancelCreateVideo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		cancelCreateVideo.setLocationRelativeTo(this);
		cancelCreateVideo.setVisible(true);
	}
	
	private boolean validateStrings(String line, JLabel label) {
		boolean isValid = true;
		
		if(line.equals("")) {
			label.setVisible(true);
			isValid = false;
		} else {
			label.setVisible(false);
		} 
		
		return isValid;
		
	}
}

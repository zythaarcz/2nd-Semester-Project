package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	
	private CancelCreateVideo cancelCreateVideo;
	
	int x;
	

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
		cancelCreateVideo = new CancelCreateVideo();
		cancelCreateVideo.setVisible(false);
		
		setResizable(false);
		setTitle("Create video");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		String[] filterStrings = {"Uncategorized","Neck training", "Upper body training", "Lower body training"};
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
				createVideo();	
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
		
		SideBarCustomer sidebar = new SideBarCustomer();
		//setComponentZOrder(sidebar, );
		sidebar.setSize(0, 740);
		contentPane.add(sidebar);
		sidebar.setVisible(false);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sidebar.setVisible(true);
				sidebar.setSize(225, 740);

				textFieldUrl.setFocusable(false);
				textFieldHeader.setEnabled(false);
				textFieldPointsForCompletion.setEnabled(false);
				textPaneShortDescription.setEnabled(false);
				comboBoxCategory.setEnabled(false);
				
				btnCreateVideo.setEnabled(false);
				btnCancel.setEnabled(false);
				
			}
		});
		sidebarButton.setIcon(new ImageIcon(CreateVideo.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 45, 39);
		contentPane.add(sidebarButton);
	}
	
	private void createVideo() {	
		urlString = textFieldUrl.getText();
		headerString = textFieldHeader.getText();
		shortDescriptionString = textPaneShortDescription.getText();
		categoryString = String.valueOf(comboBoxCategory.getSelectedItem());
		
		try
		{
			pointsForCompletion = Integer.parseInt(textFieldPointsForCompletion.getText());
			System.out.println(urlString);
			System.out.println(headerString);
			System.out.println(shortDescriptionString);
			System.out.println(categoryString);
			System.out.println(pointsForCompletion);
			
			JOptionPane.showMessageDialog(contentPane, "Video was successfully created!");
			
			textFieldUrl.setText("");
			textFieldHeader.setText("");
			textPaneShortDescription.setText("");
			textFieldPointsForCompletion.setText("");
			comboBoxCategory.setSelectedItem("Uncategorized");
	    } 
	    catch (NumberFormatException e) 
	    {
	    	textFieldPointsForCompletion.setText("");
	      	JOptionPane.showMessageDialog(contentPane, "Write numbers not characters");
	    }
	}
	
	private void cancelCreateVideo() {
		cancelCreateVideo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		cancelCreateVideo.setLocationRelativeTo(this);
		cancelCreateVideo.setVisible(true);
	}
}

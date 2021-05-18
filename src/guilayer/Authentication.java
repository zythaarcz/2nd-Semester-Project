package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.AuthenticationController;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;

public class Authentication extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JLabel hyperlink;
	private JLabel logoImage;
	
	private AuthenticationController authController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentication frame = new Authentication();
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
	public Authentication() {
		authController = new AuthenticationController(); 
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 751);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#F0F0F0"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Authentication");
		setContentPane(contentPane);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(115, 229, 171, 17);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailTextField.setBounds(115, 249, 213, 43);
		emailTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(115, 303, 105, 17);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(115, 323, 213, 43);
		contentPane.setLayout(null);
		contentPane.add(passwordLabel);
		contentPane.add(emailLabel);
		contentPane.add(emailTextField);
		contentPane.add(passwordField);
		
		JButton signInButton = new JButton("Sign in");
		signInButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailTextField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				boolean result = authController.authenticateUser(email, password);
				
				if(result) {
					switch(AuthenticatedUser.getInstance().getCurrentUser().getPersonType()) {
					case Customer:
						HomepageCustomer hpCustomer = new HomepageCustomer();
						hpCustomer.setVisible(true);
						dispose();
						break;
					case Employee:
						HomepageEmployee hpEmployee = new HomepageEmployee();
						hpEmployee.setVisible(true);
						dispose();
						break;
					}
				}
				else {
					//TODO: display message to user to try again
					JOptionPane.showMessageDialog(contentPane, "Email or password is wrong. Try again!");
				}
			}
		});
		signInButton.setBackground(Color.decode("#FFD020"));
		signInButton.setForeground(Color.BLACK);
		signInButton.setBounds(175, 435, 93, 30);
		contentPane.add(signInButton);
		
		hyperlink = new JLabel("Create new account?");
		hyperlink.setFont(new Font("Tahoma", Font.BOLD, 12));
		hyperlink.setBounds(200, 377, 130, 13);
		contentPane.add(hyperlink);
		hyperlink.setForeground(Color.BLUE.darker());
		hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hyperlink.setText("<html><a href=''>Create new account?</a></html>");
		
		logoImage = new JLabel(new ImageIcon(Authentication.class.getResource("/images/logo.png")));
		logoImage.setBounds(71, 92, 295, 95);
		contentPane.add(logoImage);
		
		hyperlink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 try {
			         
				        Desktop.getDesktop().browse(new URI("https://officefitness.cz/en/"));
				         
				    } catch (IOException | URISyntaxException e1) {
				        e1.printStackTrace();
				    }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		
	}
}

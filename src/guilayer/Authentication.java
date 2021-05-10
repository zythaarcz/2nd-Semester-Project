package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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

public class Authentication extends JFrame {

	private JPanel contentPane;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JLabel hyperlink;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.add(new JLabel(new ImageIcon("C:/Users/neagu/Desktop/Untitled.png")));
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(117, 229, 171, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		emailTextField = new JTextField();
		emailTextField.setBounds(117, 256, 213, 30);
		emailTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(117, 296, 105, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 323, 213, 31);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(emailTextField);
		contentPane.add(passwordField);
		
		JButton signInButton = new JButton("Sign in");
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		signInButton.setBackground(Color.decode("#FFD020"));
		signInButton.setForeground(Color.BLACK);
		signInButton.setBounds(175, 420, 93, 30);
		contentPane.add(signInButton);
		
		hyperlink = new JLabel("Create new account?");
		hyperlink.setBounds(217, 376, 192, 13);
		contentPane.add(hyperlink);
		hyperlink.setForeground(Color.BLUE.darker());
		hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hyperlink.setText("<html><a href=''>Create new account?</a></html>");
		
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

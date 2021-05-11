package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDateOfBirth;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JTextField txtCompanyName;
	public PasswordChange passwordChangeDialog;
	private JButton btnSettingsEmail;
	private JButton btnSettingsPhoneNumber;
	private JButton btnSettingsCompanyName;
	private JButton btnSettingsEmailOK;
	private JButton btnSettingsPhoneNumberOK;
	private JButton btnSettingsCompanyNameOK;
	private String emailString;
	private String phoneNumberString;
	private String companyNameString;
	private String healthIssueString;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		passwordChangeDialog = new PasswordChange();
		passwordChangeDialog.setVisible(false);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSettingsEmail = new JButton("");
		btnSettingsEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEmail.setEditable(true);
				btnSettingsEmail.setVisible(false);
				btnSettingsEmail.setEnabled(false);
				btnSettingsEmailOK.setVisible(true);
				btnSettingsEmailOK.setEnabled(true);
			}
		});
		btnSettingsEmail.setBackground(SystemColor.menu);
		btnSettingsEmail.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIcon32x32.png")));
		btnSettingsEmail.setBounds(300, 385, 43, 42);
		contentPane.add(btnSettingsEmail);
		
		btnSettingsEmailOK = new JButton("");
		btnSettingsEmailOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEmail.setEditable(false);
				btnSettingsEmail.setVisible(true);
				btnSettingsEmail.setEnabled(true);
				btnSettingsEmailOK.setVisible(false);
				btnSettingsEmailOK.setEnabled(false);
				
				emailString = txtEmail.getText();
				System.out.println(emailString);
			}
		});
		btnSettingsEmailOK.setEnabled(false);
		btnSettingsEmailOK.setVisible(false);
		btnSettingsEmailOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnSettingsEmailOK.setBackground(SystemColor.menu);
		btnSettingsEmailOK.setBounds(300, 385, 43, 42);
		contentPane.add(btnSettingsEmailOK);
		
		btnSettingsCompanyName = new JButton("");
		btnSettingsCompanyName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCompanyName.setEditable(true);
				btnSettingsCompanyName.setVisible(false);
				btnSettingsCompanyName.setEnabled(false);
				btnSettingsCompanyNameOK.setVisible(true);
				btnSettingsCompanyNameOK.setEnabled(true);
				
			}
		});
		btnSettingsCompanyName.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIcon32x32.png")));
		btnSettingsCompanyName.setBackground(SystemColor.menu);
		btnSettingsCompanyName.setBounds(300, 491, 43, 42);
		contentPane.add(btnSettingsCompanyName);
		
		btnSettingsCompanyNameOK = new JButton("");
		btnSettingsCompanyNameOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCompanyName.setEditable(false);
				btnSettingsCompanyName.setVisible(true);
				btnSettingsCompanyName.setEnabled(true);
				btnSettingsCompanyNameOK.setVisible(false);
				btnSettingsCompanyNameOK.setEnabled(false);
				
				companyNameString = txtCompanyName.getText();
				System.out.println(companyNameString);
			}
		});
		btnSettingsCompanyNameOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnSettingsCompanyNameOK.setEnabled(false);
		btnSettingsCompanyNameOK.setBackground(SystemColor.menu);
		btnSettingsCompanyNameOK.setBounds(300, 491, 43, 42);
		contentPane.add(btnSettingsCompanyNameOK);
		
		btnSettingsPhoneNumber = new JButton("");
		btnSettingsPhoneNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPhoneNumber.setEditable(true);
				btnSettingsPhoneNumber.setVisible(false);
				btnSettingsPhoneNumber.setEnabled(false);
				btnSettingsPhoneNumberOK.setVisible(true);
				btnSettingsPhoneNumberOK.setEnabled(true);
			}
		});
		btnSettingsPhoneNumber.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIcon32x32.png")));
		btnSettingsPhoneNumber.setBackground(SystemColor.menu);
		btnSettingsPhoneNumber.setBounds(300, 438, 43, 42);
		contentPane.add(btnSettingsPhoneNumber);
		
		btnSettingsPhoneNumberOK = new JButton("");
		btnSettingsPhoneNumberOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPhoneNumber.setEditable(false);
				btnSettingsPhoneNumber.setVisible(true);
				btnSettingsPhoneNumber.setEnabled(true);
				btnSettingsPhoneNumberOK.setVisible(false);
				btnSettingsPhoneNumberOK.setEnabled(false);
				
				phoneNumberString = txtPhoneNumber.getText();
				System.out.println(phoneNumberString);
			}
		});
		btnSettingsPhoneNumberOK.setEnabled(false);
		btnSettingsPhoneNumberOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnSettingsPhoneNumberOK.setBackground(SystemColor.menu);
		btnSettingsPhoneNumberOK.setBounds(300, 437, 43, 42);
		contentPane.add(btnSettingsPhoneNumberOK);
		
		JLabel profilePicture = new JLabel("");
		profilePicture.setIcon(new ImageIcon(Profile.class.getResource("/images/profilePicture.png")));
		profilePicture.setBounds(125, 29, 200, 200);
		contentPane.add(profilePicture);
		
		JButton btnChangePhoto = new JButton("Change photo");
		btnChangePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordChangeDialog.isVisible() == false) {
					JOptionPane.showMessageDialog(contentPane, "Feature not implemented.");
				}

			}
		});
		btnChangePhoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangePhoto.setForeground(Color.BLACK);
		btnChangePhoto.setBackground(new Color(255, 208, 32));
		btnChangePhoto.setBounds(125, 224, 200, 31);
		contentPane.add(btnChangePhoto);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtName.setText("Matej Horváth");
		txtName.setBounds(103, 280, 240, 43);
		txtName.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setText("27.04.20201");
		txtDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
		txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDateOfBirth.setEditable(false);
		txtDateOfBirth.setColumns(10);
		txtDateOfBirth.setBounds(103, 332, 240, 43);
		contentPane.add(txtDateOfBirth);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText("email@email.com");
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 385, 200, 43);
		contentPane.add(txtEmail);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setEditable(false);
		txtPhoneNumber.setText("+4550153020");
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(103, 438, 200, 43);
		contentPane.add(txtPhoneNumber);
		
		txtCompanyName = new JTextField();
		txtCompanyName.setEditable(false);
		txtCompanyName.setText("Company name");
		txtCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
		txtCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCompanyName.setColumns(10);
		txtCompanyName.setBounds(103, 491, 200, 43);
		contentPane.add(txtCompanyName);
		
		String[] filterStrings = {"Health issue: none","Back pain", "Neck pain", "Knees injury", "Arm injury"};
		JComboBox healthIssuesComboBox = new JComboBox(filterStrings);
		healthIssuesComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				healthIssueString = String.valueOf(healthIssuesComboBox.getSelectedItem());
				System.out.println(healthIssueString);
			}
		});
		healthIssuesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		healthIssuesComboBox.setBounds(103, 544, 240, 43);
		((JLabel)healthIssuesComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(healthIssuesComboBox);
		
		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePassword();
			}
		});
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnChangePassword.setBackground(new Color(255, 208, 32));
		btnChangePassword.setBounds(125, 619, 200, 31);
		contentPane.add(btnChangePassword);	
	}
	
	private void changePassword() {
		passwordChangeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		passwordChangeDialog.setLocationRelativeTo(this);
		passwordChangeDialog.setVisible(true);
	}
}

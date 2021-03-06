package guilayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.AuthenticationController;
import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;

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

	private AuthenticationController authenticationController;

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

	private SideBarEmployee sideBarEmployee;
	private SideBarCustomer sideBarCustomer;

	/**
	 * Create the frame.
	 */
	public Profile() {
		setTitle("Profile");
		authenticationController = new AuthenticationController();

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
			}
		});
		btnSettingsCompanyNameOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnSettingsCompanyNameOK.setEnabled(false);
		btnSettingsCompanyNameOK.setBackground(SystemColor.menu);
		btnSettingsCompanyNameOK.setBounds(300, 491, 43, 42);
		contentPane.add(btnSettingsCompanyNameOK);

		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Employee) {
			btnSettingsCompanyName.setVisible(false);
			btnSettingsCompanyNameOK.setVisible(false);
		}

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
		btnChangePhoto.setRolloverEnabled(false);
		btnChangePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (passwordChangeDialog.isVisible() == false) {
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
		txtName.setText(AuthenticatedUser.getInstance().getCurrentUser().getFirstName() + " "
				+ AuthenticatedUser.getInstance().getCurrentUser().getLastName());
		txtName.setBounds(103, 280, 240, 43);
		txtName.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(txtName);
		txtName.setColumns(10);

		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			txtDateOfBirth = new JTextField();
			txtDateOfBirth.setText(authenticationController.getCustomer().getDateOfBirth().toString());
			txtDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);
			txtDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtDateOfBirth.setEditable(false);
			txtDateOfBirth.setColumns(10);
			txtDateOfBirth.setBounds(103, 332, 240, 43);
			contentPane.add(txtDateOfBirth);

			txtCompanyName = new JTextField();
			txtCompanyName.setEditable(false);
			txtCompanyName.setText(authenticationController.getCustomer().getCompany());
			txtCompanyName.setHorizontalAlignment(SwingConstants.CENTER);
			txtCompanyName.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtCompanyName.setColumns(10);
			txtCompanyName.setBounds(103, 491, 200, 43);
			contentPane.add(txtCompanyName);

			String[] filterStrings = { "Health issue: none", "Back pain", "Neck pain", "Knees injury", "Arm injury" };
			JComboBox healthIssuesComboBox = new JComboBox(filterStrings);
			healthIssuesComboBox.setSelectedItem(authenticationController.getCustomer().getHealthIssue());
			healthIssuesComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					healthIssueString = String.valueOf(healthIssuesComboBox.getSelectedItem());
				}
			});
			healthIssuesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
			healthIssuesComboBox.setBounds(103, 544, 240, 43);
			((JLabel) healthIssuesComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(healthIssuesComboBox);
		}

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setText(AuthenticatedUser.getInstance().getCurrentUser().getEmail());
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 385, 200, 43);
		contentPane.add(txtEmail);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setEditable(false);
		txtPhoneNumber.setText(AuthenticatedUser.getInstance().getCurrentUser().getPhoneNumber());
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(103, 438, 200, 43);
		contentPane.add(txtPhoneNumber);

		JButton btnChangePassword = new JButton("Change password");
		btnChangePassword.setRolloverEnabled(false);
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

		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			sideBarCustomer = new SideBarCustomer();
			((JPanel) sideBarCustomer).setSize(0, 740);
			contentPane.add((JPanel) sideBarCustomer);
			((JPanel) sideBarCustomer).setVisible(false);
			contentPane.setComponentZOrder(sideBarCustomer, 0);
		} else {
			sideBarEmployee = new SideBarEmployee();
			((JPanel) sideBarEmployee).setSize(0, 740);
			contentPane.add((JPanel) sideBarEmployee);
			((JPanel) sideBarEmployee).setVisible(false);
			contentPane.setComponentZOrder(sideBarEmployee, 0);
		}

		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
					((JPanel) sideBarCustomer).setVisible(true);
					sideBarCustomer.runSidebar();
				} else {
					((JPanel) sideBarEmployee).setVisible(true);
					sideBarEmployee.runSidebar();
				}
			}
		});
		sidebarButton.setIcon(new ImageIcon(Profile.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 45, 39);
		contentPane.add(sidebarButton);
	}

	private void changePassword() {
		passwordChangeDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		passwordChangeDialog.setLocationRelativeTo(this);
		passwordChangeDialog.setVisible(true);
	}
}

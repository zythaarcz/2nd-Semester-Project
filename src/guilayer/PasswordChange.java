package guilayer;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordChange extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private String savedNewPasswordString;
	private String savedConfirmPasswordString;

	/**
	 * Create the dialog.
	 */
	public PasswordChange() {
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 330, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnConfirmPassword = new JButton("Confirm password");
			btnConfirmPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getNewPassword();
				}
			});
			btnConfirmPassword.setForeground(Color.BLACK);
			btnConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnConfirmPassword.setBackground(new Color(255, 208, 32));
			btnConfirmPassword.setBounds(83, 87, 160, 25);
			contentPanel.add(btnConfirmPassword);
		}
		{
			JLabel lblNewPassword = new JLabel("New password");
			lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewPassword.setBounds(10, 20, 120, 15);
			contentPanel.add(lblNewPassword);
		}
		{
			JLabel lblConfirmPassword = new JLabel("Confirm password");
			lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblConfirmPassword.setBounds(175, 20, 120, 15);
			contentPanel.add(lblConfirmPassword);
		}
		{
			newPasswordField = new JPasswordField();
			newPasswordField.setBounds(10, 36, 128, 26);
			contentPanel.add(newPasswordField);
		}
		{
			confirmPasswordField = new JPasswordField();
			confirmPasswordField.setBounds(175, 36, 128, 26);
			contentPanel.add(confirmPasswordField);
		}
	}

	private void getNewPassword() {
		String newPasswordString = String.valueOf(newPasswordField.getPassword());
		String confirmPasswordString = String.valueOf(confirmPasswordField.getPassword());
		if (newPasswordString.equals("") || confirmPasswordString.equals("")) {
			JOptionPane.showMessageDialog(this, "Fields can not be empty!");
		} else {
			if (newPasswordString.equals(confirmPasswordString)) {
				savedNewPasswordString = newPasswordString;
				savedConfirmPasswordString = confirmPasswordString;

				newPasswordField.setText("");
				confirmPasswordField.setText("");
				JOptionPane.showMessageDialog(this, "Password changed but not updated in database(not implemented)");
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Passwords do not match!");
			}
		}
	}
}

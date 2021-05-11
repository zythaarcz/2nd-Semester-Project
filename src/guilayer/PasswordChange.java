package guilayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PasswordChange extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private String newPasswordString;
	private String confirmPasswordString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PasswordChange dialog = new PasswordChange();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			btnConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnConfirmPassword.setBackground(new Color(255, 208, 32));
			btnConfirmPassword.setBounds(86, 87, 140, 19);
			contentPanel.add(btnConfirmPassword);
		}
		{
			JLabel lblNewPassword = new JLabel("New password");
			lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewPassword.setBounds(10, 20, 96, 13);
			contentPanel.add(lblNewPassword);
		}
		{
			JLabel lblConfirmPassword = new JLabel("Confirm password");
			lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConfirmPassword.setBounds(165, 20, 96, 13);
			contentPanel.add(lblConfirmPassword);
		}
		{
			newPasswordField = new JPasswordField();
			newPasswordField.setBounds(10, 36, 128, 26);
			contentPanel.add(newPasswordField);
		}
		{
			confirmPasswordField = new JPasswordField();
			confirmPasswordField.setBounds(165, 36, 128, 26);
			contentPanel.add(confirmPasswordField);
		}
	}
	
	private void getNewPassword() {
		newPasswordString = newPasswordField.getText();
		confirmPasswordString = confirmPasswordField.getText();
		
		System.out.println(newPasswordString);
		System.out.println(confirmPasswordString);
		
		newPasswordField.setText("");
		confirmPasswordField.setText("");
		
		dispose();
	}
}

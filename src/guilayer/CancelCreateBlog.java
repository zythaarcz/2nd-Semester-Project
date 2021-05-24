package guilayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CancelCreateBlog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private AllBlogsEmployee allBlogsEmployee;

	/**
	 * Create the dialog.
	 */
	
	public CancelCreateBlog(JFrame frame) {
		setAlwaysOnTop(true);
		setBounds(100, 100, 330, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnYes = new JButton("Yes");
			btnYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					allBlogsEmployee = new AllBlogsEmployee();
					allBlogsEmployee.setVisible(true);
					frame.dispose();
					dispose();
				}
			});
			btnYes.setBounds(25, 73, 100, 31);
			btnYes.setForeground(Color.BLACK);
			btnYes.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnYes.setBackground(new Color(255, 208, 32));
			contentPanel.add(btnYes);
		}
		{
			JButton btnNo = new JButton("No");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnNo.setForeground(Color.BLACK);
			btnNo.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNo.setBackground(new Color(255, 208, 32));
			btnNo.setBounds(200, 73, 100, 31);
			contentPanel.add(btnNo);
		}
		{
			JLabel lblNewLabel = new JLabel("Are you sure to cancel adding the blog?");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(25, 21, 280, 30);
			contentPanel.add(lblNewLabel);
		}
	}
}

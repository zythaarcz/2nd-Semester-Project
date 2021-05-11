package guilayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditVideo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditVideo frame = new EditVideo();
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
	public EditVideo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Edit video");
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(100, 37, 349, 111);
		logo.setIcon(new ImageIcon(EditVideo.class.getResource("/images/logo.png")));
		contentPane.add(logo);

		JLabel titleLabel = new JLabel("Title");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		titleLabel.setBounds(54, 226, 45, 13);
		contentPane.add(titleLabel);

		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		descriptionLabel.setBounds(54, 292, 191, 13);
		contentPane.add(descriptionLabel);

		JLabel pointsLabel = new JLabel("Points for completion");
		pointsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		pointsLabel.setBounds(54, 464, 235, 13);
		contentPane.add(pointsLabel);

		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		categoryLabel.setBounds(54, 530, 108, 20);
		contentPane.add(categoryLabel);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet."); //send you back to the previous page
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelButton.setBackground(Color.decode("#FFD020"));
		cancelButton.setBounds(204, 649, 97, 33);
		contentPane.add(cancelButton);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet."); //"Video details were successfully updated."
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmButton.setBounds(311, 649, 97, 33);
		confirmButton.setBackground(Color.decode("#FFD020"));
		contentPane.add(confirmButton);

		JTextPane txtDescription = new JTextPane();
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescription.setText("\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo.");
		txtDescription.setBounds(54, 316, 235, 132);
		contentPane.add(txtDescription);

		JButton editButton_title = new JButton("Edit");
		editButton_title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet.");
			}
		});
		editButton_title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_title.setBounds(299, 249, 67, 33);
		editButton_title.setBackground(Color.decode("#FFD020"));
		contentPane.add(editButton_title);

		JEditorPane txtTitle = new JEditorPane();
		txtTitle.setEditable(false);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTitle.setText("5 Ways to reduce back pain");
		txtTitle.setBounds(55, 249, 234, 33);
		contentPane.add(txtTitle);

		JEditorPane txtPoints = new JEditorPane();
		txtPoints.setEditable(false);
		txtPoints.setText("35");
		txtPoints.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPoints.setBounds(54, 487, 234, 33);
		contentPane.add(txtPoints);

		JEditorPane txtCategory = new JEditorPane();
		txtCategory.setEditable(false);
		txtCategory.setText("Pain relief");
		txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCategory.setBounds(54, 560, 234, 33);
		contentPane.add(txtCategory);

		JButton editButton_description = new JButton("Edit");
		editButton_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet.");
			}
		});
		editButton_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_description.setBackground(new Color(255, 208, 32));
		editButton_description.setBounds(299, 362, 67, 33);
		contentPane.add(editButton_description);

		JButton editButton_points = new JButton("Edit");
		editButton_points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet.");
			}
		});
		editButton_points.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_points.setBackground(new Color(255, 208, 32));
		editButton_points.setBounds(299, 487, 67, 33);
		contentPane.add(editButton_points);

		JButton editButton_category = new JButton("Edit");
		editButton_category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet.");
			}
		});
		editButton_category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_category.setBackground(new Color(255, 208, 32));
		editButton_category.setBounds(299, 560, 67, 33);
		contentPane.add(editButton_category);
	}
}

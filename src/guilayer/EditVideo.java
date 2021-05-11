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
import java.awt.SystemColor;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EditVideo extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtDescription;
	private JTextField txtPoints;
	private JTextField txtCategory;
	private JButton editButton_titleOK;
	private JButton editButton_descriptionOK;
	private JButton editButton_pointsOK;
	private JButton editButton_categoryOK;

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

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet."); //send you back to the previous page
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBackground(Color.decode("#FFD020"));
		cancelButton.setBounds(204, 649, 97, 33);
		contentPane.add(cancelButton);

		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet."); //"Video details were successfully updated."
			}
		});
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmButton.setBounds(311, 649, 97, 33);
		confirmButton.setBackground(Color.decode("#FFD020"));
		contentPane.add(confirmButton);

		JButton editButton_title = new JButton("");
		editButton_title.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitle.setEditable(true);
				editButton_title.setVisible(false);
				editButton_title.setEnabled(false);
				editButton_titleOK.setVisible(true);
				editButton_titleOK.setEnabled(true);
			}
		});
		editButton_title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_title.setBounds(325, 198, 57, 43);
		editButton_title.setBackground(SystemColor.menu);
		contentPane.add(editButton_title);
		
		editButton_titleOK = new JButton("");
		editButton_titleOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTitle.setEditable(false);
				editButton_title.setVisible(true);
				editButton_title.setEnabled(true);
				editButton_titleOK.setVisible(false);
				editButton_titleOK.setEnabled(false);
				
				String titleString = txtTitle.getText();
				System.out.println(titleString);
			}
		});
		editButton_titleOK.setEnabled(false);
		editButton_titleOK.setVisible(false);
		editButton_titleOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_titleOK.setBackground(SystemColor.menu);
		editButton_titleOK.setBounds(325, 198, 57, 43);
		contentPane.add(editButton_titleOK);

		JButton editButton_description = new JButton("");
		editButton_description.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDescription.setEditable(true);
				editButton_description.setVisible(false);
				editButton_description.setEnabled(false);
				editButton_descriptionOK.setVisible(true);
				editButton_descriptionOK.setEnabled(true);
			}
		});
		editButton_description.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_description.setBackground(SystemColor.menu);
		editButton_description.setBounds(325, 267, 57, 44);
		contentPane.add(editButton_description);
		
		editButton_descriptionOK = new JButton("");
		editButton_descriptionOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDescription.setEditable(false);
				editButton_description.setVisible(true);
				editButton_description.setEnabled(true);
				editButton_descriptionOK.setVisible(false);
				editButton_descriptionOK.setEnabled(false);
				
				String descriptionString = txtDescription.getText();
				System.out.println(descriptionString);
			}
		});
		editButton_descriptionOK.setEnabled(false);
		editButton_descriptionOK.setVisible(false);
		editButton_descriptionOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_descriptionOK.setBackground(SystemColor.menu);
		editButton_descriptionOK.setBounds(325, 267, 57, 44);
		contentPane.add(editButton_descriptionOK);
		

		JButton editButton_points = new JButton("");
		editButton_points.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_points.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPoints.setEditable(true);
				editButton_points.setVisible(false);
				editButton_points.setEnabled(false);
				editButton_pointsOK.setVisible(true);
				editButton_pointsOK.setEnabled(true);
			}
		});
		editButton_points.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_points.setBackground(SystemColor.menu);
		editButton_points.setBounds(325, 442, 57, 43);
		contentPane.add(editButton_points);
		
		editButton_pointsOK = new JButton("");
		editButton_pointsOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPoints.setEditable(false);
				editButton_points.setVisible(true);
				editButton_points.setEnabled(true);
				editButton_pointsOK.setVisible(false);
				editButton_pointsOK.setEnabled(false);
				
				String pointsString = txtPoints.getText();
				System.out.println(pointsString);
			}
		});
		editButton_pointsOK.setEnabled(false);
		editButton_pointsOK.setVisible(false);
		editButton_pointsOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_pointsOK.setBackground(SystemColor.menu);
		editButton_pointsOK.setBounds(325, 442, 57, 43);
		contentPane.add(editButton_pointsOK);

		JButton editButton_category = new JButton("");
		editButton_category.setIcon(new ImageIcon(EditVideo.class.getResource("/images/settingsIcon32x32.png")));
		editButton_category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCategory.setEditable(true);
				editButton_category.setVisible(false);
				editButton_category.setEnabled(false);
				editButton_categoryOK.setVisible(true);
				editButton_categoryOK.setEnabled(true);
			}
		});
		editButton_category.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editButton_category.setBackground(SystemColor.menu);
		editButton_category.setBounds(325, 519, 57, 43);
		contentPane.add(editButton_category);
		
		editButton_categoryOK = new JButton("");
		editButton_categoryOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtCategory.setEditable(false);
				editButton_category.setVisible(true);
				editButton_category.setEnabled(true);
				editButton_categoryOK.setVisible(false);
				editButton_categoryOK.setEnabled(false);
				
				String categoryString = txtCategory.getText();
				System.out.println(categoryString);
			}
		});
		editButton_categoryOK.setEnabled(false);
		editButton_categoryOK.setVisible(false);
		editButton_categoryOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		editButton_categoryOK.setBackground(SystemColor.menu);
		editButton_categoryOK.setBounds(325, 519, 57, 43);
		contentPane.add(editButton_categoryOK);
		
		txtTitle = new JTextField();
		txtTitle.setText("5 Ways to reduce back pain");
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTitle.setEditable(false);
		txtTitle.setColumns(10);
		txtTitle.setBounds(70, 198, 312, 43);
		contentPane.add(txtTitle);
		
		txtDescription = new JTextField();
		txtDescription.setText("This is a short description of the video.");
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDescription.setEditable(false);
		txtDescription.setColumns(10);
		txtDescription.setBounds(70, 267, 312, 139);
		contentPane.add(txtDescription);
		
		txtPoints = new JTextField();
		txtPoints.setText("Points for completion: 35");
		txtPoints.setHorizontalAlignment(SwingConstants.CENTER);
		txtPoints.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPoints.setEditable(false);
		txtPoints.setColumns(10);
		txtPoints.setBounds(70, 442, 312, 43);
		contentPane.add(txtPoints);
		
		txtCategory = new JTextField();
		txtCategory.setText("Category: Pain relief");
		txtCategory.setHorizontalAlignment(SwingConstants.CENTER);
		txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCategory.setEditable(false);
		txtCategory.setColumns(10);
		txtCategory.setBounds(70, 519, 312, 43);
		contentPane.add(txtCategory);
	}
}

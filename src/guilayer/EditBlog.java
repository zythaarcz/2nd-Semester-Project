package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controllayer.ManageBlogController;
import controllayer.ManageVideoController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class EditBlog extends JFrame {

	private JPanel contentPane;
	private JTextField txtImagePath;
	private JTextField txtHeader;
	private JButton btnEdit_imagePath;
	private JButton btnEdit_header;
	private JButton btnEdit_contentText;
	private JButton btnEdit_description;
	private JButton btnEdit_imagePathOK;
	private JButton btnEdit_headerOK;
	private JButton btnEdit_contentTextOK;
	private JButton btnEdit_descriptionOK;
	
	private JTextPane textPaneShortDescription;
	private JTextPane textPaneContentText;
	
	private String newImagePath;
	private String newHeader;
	private String newContentText;
	private String newDescription;
	
	private AllBlogsEmployee allBlogs;
	private ManageBlogController manageBlogController;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBlog frame = new EditBlog();
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
	public EditBlog() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Edit blog");
		contentPane.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(EditBlog.class.getResource("/images/logo.png")));
		logo.setBounds(133, 27, 293, 111);
		contentPane.add(logo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 484, 290, 139);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		contentPane.add(scrollPane);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allBlogs = new AllBlogsEmployee();
				allBlogs.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoBack.setBackground(new Color(255, 208, 32));
		btnGoBack.setBounds(98, 658, 97, 33);
		contentPane.add(btnGoBack);
		
		JButton btnConfirmEdit = new JButton("Confirm");
		btnConfirmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//manageBlogController.updateBlogInformation(blog.getId(), newImagePath, newHeader, newContentText, newDescription;
				JOptionPane.showMessageDialog(contentPane, "The information about the blog was successfully updated.");
			}
		});
		btnConfirmEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmEdit.setBackground(new Color(255, 208, 32));
		btnConfirmEdit.setBounds(231, 658, 97, 33);
		contentPane.add(btnConfirmEdit);
		
		txtImagePath = new JTextField();
		txtImagePath.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtImagePath.setBounds(71, 201, 293, 39);
		txtImagePath.setEditable(false);
		contentPane.add(txtImagePath);
		txtImagePath.setColumns(10);
		
		txtHeader = new JTextField();
		txtHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHeader.setColumns(10);
		txtHeader.setBounds(71, 275, 293, 39);
		txtHeader.setEditable(false);
		contentPane.add(txtHeader);
		
		textPaneContentText = new JTextPane();
		textPaneContentText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneContentText.setBounds(71, 484, 290, 139);
		textPaneContentText.setEditable(false);
		scrollPane.setViewportView(textPaneContentText);
		
		textPaneShortDescription = new JTextPane();
		textPaneShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneShortDescription.setBounds(71, 349, 290, 100);
		textPaneShortDescription.setEditable(false);
		contentPane.add(textPaneShortDescription);
		
		btnEdit_imagePath = new JButton("");
		btnEdit_imagePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtImagePath.setEditable(true);
				btnEdit_imagePath.setVisible(false);
				btnEdit_imagePath.setEnabled(false);
				btnEdit_imagePathOK.setVisible(true);
				btnEdit_imagePathOK.setEnabled(true);
			}
		});
		btnEdit_imagePath.setIcon(new ImageIcon(EditBlog.class.getResource("/images/settingsIcon32x32.png")));
		btnEdit_imagePath.setBounds(360, 201, 53, 39);
		contentPane.add(btnEdit_imagePath);
		
		btnEdit_imagePathOK = new JButton("");
		btnEdit_imagePathOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtImagePath.setEditable(false);
				btnEdit_imagePath.setVisible(true);
				btnEdit_imagePath.setEnabled(true);
				btnEdit_imagePathOK.setVisible(false);
				btnEdit_imagePathOK.setEnabled(false);
				
				newImagePath = txtImagePath.getText();
				System.out.println(newImagePath);
			}
		});
		btnEdit_imagePathOK.setEnabled(false);
		btnEdit_imagePathOK.setVisible(false);
		btnEdit_imagePathOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnEdit_imagePathOK.setBackground(SystemColor.menu);
		btnEdit_imagePathOK.setBounds(360, 201, 53, 39);
		contentPane.add(btnEdit_imagePathOK);
		
		btnEdit_header = new JButton("");
		btnEdit_header.setIcon(new ImageIcon(EditBlog.class.getResource("/images/settingsIcon32x32.png")));
		btnEdit_header.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHeader.setEditable(true);
				btnEdit_header.setVisible(false);
				btnEdit_header.setEnabled(false);
				btnEdit_headerOK.setVisible(true);
				btnEdit_headerOK.setEnabled(true);
			}
		});
		btnEdit_header.setBounds(360, 275, 53, 39);
		contentPane.add(btnEdit_header);
		
		btnEdit_headerOK = new JButton("");
		btnEdit_headerOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtHeader.setEditable(false);
				btnEdit_header.setVisible(true);
				btnEdit_header.setEnabled(true);
				btnEdit_headerOK.setVisible(false);
				btnEdit_headerOK.setEnabled(false);
				
				newHeader = txtHeader.getText();
				System.out.println(newHeader);
			}
		});
		btnEdit_headerOK.setEnabled(false);
		btnEdit_headerOK.setVisible(false);
		btnEdit_headerOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnEdit_headerOK.setBackground(SystemColor.menu);
		btnEdit_headerOK.setBounds(360, 275, 53, 39);
		contentPane.add(btnEdit_headerOK);
		
		btnEdit_contentText = new JButton("");
		btnEdit_contentText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneContentText.setEditable(true);
				btnEdit_contentText.setVisible(false);
				btnEdit_contentText.setEnabled(false);
				btnEdit_contentTextOK.setVisible(true);
				btnEdit_contentTextOK.setEnabled(true);
			}

		});
		btnEdit_contentText.setIcon(new ImageIcon(EditBlog.class.getResource("/images/settingsIcon32x32.png")));
		btnEdit_contentText.setBounds(360, 484, 53, 39);
		contentPane.add(btnEdit_contentText);
		
		btnEdit_contentTextOK = new JButton("");
		btnEdit_contentTextOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneContentText.setEditable(false);
				btnEdit_contentText.setVisible(true);
				btnEdit_contentText.setEnabled(true);
				btnEdit_contentTextOK.setVisible(false);
				btnEdit_contentTextOK.setEnabled(false);
				
				newContentText = textPaneContentText.getText();
				System.out.println(newContentText);
			}
		});
		btnEdit_contentTextOK.setEnabled(false);
		btnEdit_contentTextOK.setVisible(false);
		btnEdit_contentTextOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnEdit_contentTextOK.setBackground(SystemColor.menu);
		btnEdit_contentTextOK.setBounds(360, 484, 53, 39);
		contentPane.add(btnEdit_contentTextOK);
		
		btnEdit_description = new JButton("");
		btnEdit_description.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneShortDescription.setEditable(true);
				btnEdit_description.setVisible(false);
				btnEdit_description.setEnabled(false);
				btnEdit_descriptionOK.setVisible(true);
				btnEdit_descriptionOK.setEnabled(true);
				
			}
		});
		btnEdit_description.setIcon(new ImageIcon(EditBlog.class.getResource("/images/settingsIcon32x32.png")));
		btnEdit_description.setBounds(360, 349, 53, 39);
		contentPane.add(btnEdit_description);
		
		btnEdit_descriptionOK = new JButton("");
		btnEdit_descriptionOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneShortDescription.setEditable(false);
				btnEdit_description.setVisible(true);
				btnEdit_description.setEnabled(true);
				btnEdit_descriptionOK.setVisible(false);
				btnEdit_descriptionOK.setEnabled(false);
				
				newDescription = textPaneShortDescription.getText();
				System.out.println(newDescription);
			}
		});
		btnEdit_descriptionOK.setEnabled(false);
		btnEdit_descriptionOK.setVisible(false);
		btnEdit_descriptionOK.setIcon(new ImageIcon(Profile.class.getResource("/images/settingsIconOK32x32.png")));
		btnEdit_descriptionOK.setBackground(SystemColor.menu);
		btnEdit_descriptionOK.setBounds(360, 349, 53, 39);
		contentPane.add(btnEdit_descriptionOK);
		
		JLabel lblContentText = new JLabel("Content text");
		lblContentText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContentText.setBounds(71, 459, 146, 30);
		contentPane.add(lblContentText);
		
		JLabel lblShortDescription = new JLabel("Short description");
		lblShortDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShortDescription.setBounds(71, 324, 146, 30);
		contentPane.add(lblShortDescription);
		
		JLabel lblHeader = new JLabel("Header");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeader.setBounds(71, 250, 100, 30);
		contentPane.add(lblHeader);
		
		JLabel lblImagePath = new JLabel("Image path");
		lblImagePath.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImagePath.setBounds(71, 174, 100, 30);
		contentPane.add(lblImagePath);
	}
}

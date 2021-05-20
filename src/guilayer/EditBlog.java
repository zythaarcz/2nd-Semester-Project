package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import controllayer.ManageBlogController;
import controllayer.ManageVideoController;
import libs.DirectoryPaths;
import modellayer.Blog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class EditBlog extends JFrame {

	private JPanel contentPane;
	private JTextField txtHeader;
	private JButton btnEdit_header;
	private JButton btnEdit_contentText;
	private JButton btnEdit_description;
	private JButton btnEdit_headerOK;
	private JButton btnEdit_contentTextOK;
	private JButton btnEdit_descriptionOK;
	
	private JTextPane textPaneShortDescription;
	private JTextPane textPaneContentText;
	private JLabel pathLbl;
	
	private File selectedPicture = null;
	
	private String newImagePath;
	private String newHeader;
	private String newContentText;
	private String newDescription;
	
	private AllBlogsEmployee allBlogs;
	private ManageBlogController manageBlogController;
	

	/**
	 * Create the frame.
	 */
	public EditBlog(Blog blog) {
		manageBlogController = new ManageBlogController();
		
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
		scrollPane.setBounds(70, 484, 269, 139);
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
				if(newHeader == null && newDescription == null
						&& newImagePath == null && newContentText == null) {
					JOptionPane.showMessageDialog(contentPane, "You did not changed any data, please check again!");
				} else {
					newHeader = txtHeader.getText();
					newDescription = textPaneShortDescription.getText();
					newImagePath = pathLbl.getText();
					newContentText = textPaneContentText.getText();
					manageBlogController.updateBlogInformation(blog.getId(), newImagePath, newHeader, newContentText, newDescription);
					JOptionPane.showMessageDialog(contentPane, "The information about the blog was successfully updated.");
				}
			}
		});
		btnConfirmEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmEdit.setBackground(new Color(255, 208, 32));
		btnConfirmEdit.setBounds(231, 658, 97, 33);
		contentPane.add(btnConfirmEdit);
		
		txtHeader = new JTextField();
		txtHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHeader.setColumns(10);
		txtHeader.setText(blog.getHeader());
		txtHeader.setBounds(70, 275, 269, 43);
		txtHeader.setEditable(false);
		contentPane.add(txtHeader);
		
		textPaneContentText = new JTextPane();
		textPaneContentText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneContentText.setText(blog.getContentText());
		textPaneContentText.setBounds(71, 484, 290, 139);
		textPaneContentText.setEditable(false);
		scrollPane.setViewportView(textPaneContentText);
		
		textPaneShortDescription = new JTextPane();
		textPaneShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneShortDescription.setText(blog.getShortDescription());
		textPaneShortDescription.setBounds(70, 349, 269, 100);
		textPaneShortDescription.setEditable(false);
		contentPane.add(textPaneShortDescription);
		
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
		btnEdit_header.setBounds(339, 275, 43, 43);
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
		btnEdit_headerOK.setBounds(339, 275, 43, 43);
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
		btnEdit_contentText.setBounds(339, 484, 43, 43);
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
		btnEdit_contentTextOK.setBounds(339, 484, 43, 43);
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
		btnEdit_description.setBounds(339, 349, 43, 43);
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
		btnEdit_descriptionOK.setBounds(339, 349, 43, 43);
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
		lblHeader.setBounds(70, 250, 100, 30);
		contentPane.add(lblHeader);
		
		JLabel lblImagePath = new JLabel("Image path");
		lblImagePath.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImagePath.setBounds(70, 174, 100, 30);
		contentPane.add(lblImagePath);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedPicture = selectPicture();
				if(selectedPicture != null) {
					newImagePath = selectedPicture.getPath();
					pathLbl.setText(newImagePath);
				}
			}
		});
		btnBrowse.setRolloverEnabled(false);
		btnBrowse.setForeground(Color.BLACK);
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowse.setBackground(new Color(255, 208, 32));
		btnBrowse.setBounds(266, 202, 95, 31);
		contentPane.add(btnBrowse);
		
		pathLbl = new JLabel("select the image for blog..");
		pathLbl.setText(blog.getImagePath());
		pathLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pathLbl.setBounds(70, 204, 201, 26);
		contentPane.add(pathLbl);
	}
	
	private File selectPicture() {
		File picture = null;
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("png", "jpg", "jpeg");
        fc.setFileFilter(filter);
		
		
		
		fc.showOpenDialog(this);
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			picture = fc.getSelectedFile();
		}

		return picture;
		
	}
	
	private String copyPicture(File picture) {
		File destination = new File(System.getProperty("user.dir"), DirectoryPaths.BLOG_IMAGES);
		
		try {
			FileUtils.copyFileToDirectory(picture, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination + "\\" +  "\\" + picture.getName();
	}
}

package guilayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controllayer.ManageBlogController;
import libs.DirectoryPaths;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import org.apache.commons.io.FileUtils;

public class CreateBlog extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldHeader;
	private JTextPane textPaneShortDescription;
	private JTextPane textPaneContentText;
	private JLabel pathLbl;

	private File selectedPicture = null;

	private String imagePathString;
	private String headerString;
	private String shortDescriptionString;
	private String contentTextString;

	private JLabel errorIconImagePath;
	private JLabel errorIconHeader;
	private JLabel errorIconShortDescription;
	private JLabel errorIconContentText;

	private CancelCreateBlog cancelCreateBlog;

	private SideBarEmployee sideBarEmployee;

	private ManageBlogController manageBlogController;

	/**
	 * Create the frame.
	 */
	public CreateBlog() {
		cancelCreateBlog = new CancelCreateBlog(this);
		cancelCreateBlog.setVisible(false);
		manageBlogController = new ManageBlogController();
		imagePathString = "";

		setResizable(false);
		setTitle("Create blog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setAutoscrolls(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 462, 300, 141);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		contentPane.add(scrollPane);

		sideBarEmployee = new SideBarEmployee();
		sideBarEmployee.setSize(0, 740);
		sideBarEmployee.setVisible(false);
		contentPane.add(sideBarEmployee);
		contentPane.setComponentZOrder(sideBarEmployee, 0);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/logo.png")));
		logo.setBounds(130, 28, 287, 111);
		contentPane.add(logo);

		pathLbl = new JLabel("select the image for blog..");
		pathLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pathLbl.setBounds(80, 187, 201, 26);
		contentPane.add(pathLbl);

		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedPicture = selectPicture();
				if (selectedPicture != null) {
					imagePathString = selectedPicture.getPath();
					pathLbl.setText(imagePathString);
				} else {
					imagePathString = "";
				}
			}
		});
		btnBrowse.setRolloverEnabled(false);
		btnBrowse.setForeground(Color.BLACK);
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBrowse.setBackground(new Color(255, 208, 32));
		btnBrowse.setBounds(275, 183, 95, 31);
		contentPane.add(btnBrowse);

		textFieldHeader = new JTextField();
		textFieldHeader.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldHeader.setColumns(10);
		textFieldHeader.setBounds(70, 249, 300, 43);
		contentPane.add(textFieldHeader);

		textPaneShortDescription = new JTextPane();
		textPaneShortDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneShortDescription.setBounds(70, 327, 300, 100);
		contentPane.add(textPaneShortDescription);

		JLabel lblImagePath = new JLabel("Image path");
		lblImagePath.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblImagePath.setBounds(70, 146, 100, 30);
		contentPane.add(lblImagePath);

		JLabel lblHeader = new JLabel("Header");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHeader.setBounds(70, 224, 100, 30);
		contentPane.add(lblHeader);

		JLabel lblShortDescription = new JLabel("Short description");
		lblShortDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShortDescription.setBounds(70, 302, 146, 30);
		contentPane.add(lblShortDescription);

		JButton btnCreateBlog = new JButton("Create blog");
		btnCreateBlog.setRolloverEnabled(false);
		btnCreateBlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewBlog();
			}
		});
		btnCreateBlog.setForeground(Color.BLACK);
		btnCreateBlog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateBlog.setBackground(new Color(255, 208, 32));
		btnCreateBlog.setBounds(123, 613, 200, 31);
		contentPane.add(btnCreateBlog);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setRolloverEnabled(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelCreateBlog();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(255, 208, 32));
		btnCancel.setBounds(123, 654, 200, 31);
		contentPane.add(btnCancel);

		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				((JPanel) sideBarEmployee).setVisible(true);
				sideBarEmployee.runSidebar();
			}
		});
		sidebarButton.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 45, 39);
		contentPane.add(sidebarButton);

		errorIconImagePath = new JLabel("");
		errorIconImagePath.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/iconError32px.png")));
		errorIconImagePath.setBounds(380, 171, 32, 43);
		errorIconImagePath.setVisible(false);
		contentPane.add(errorIconImagePath);

		errorIconHeader = new JLabel("");
		errorIconHeader.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/iconError32px.png")));
		errorIconHeader.setBounds(380, 249, 32, 43);
		errorIconHeader.setVisible(false);
		contentPane.add(errorIconHeader);

		errorIconShortDescription = new JLabel("");
		errorIconShortDescription.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/iconError32px.png")));
		errorIconShortDescription.setBounds(380, 327, 32, 43);
		errorIconShortDescription.setVisible(false);
		contentPane.add(errorIconShortDescription);

		errorIconContentText = new JLabel("");
		errorIconContentText.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/iconError32px.png")));
		errorIconContentText.setBounds(380, 462, 32, 42);
		errorIconContentText.setVisible(false);
		contentPane.add(errorIconContentText);

		JLabel lblContentText = new JLabel("Content text");
		lblContentText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContentText.setBounds(70, 437, 146, 30);
		contentPane.add(lblContentText);

		textPaneContentText = new JTextPane();
		textPaneContentText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPaneContentText.setBounds(70, 462, 300, 141);
		scrollPane.setViewportView(textPaneContentText);
	}

	private void createNewBlog() {
		headerString = textFieldHeader.getText();
		shortDescriptionString = textPaneShortDescription.getText();
		contentTextString = textPaneContentText.getText();
		boolean isImagePathValid = validateStrings(imagePathString, errorIconImagePath);
		boolean isHeaderValid = validateStrings(headerString, errorIconHeader);
		boolean isShortDescriptionValid = validateStrings(shortDescriptionString, errorIconShortDescription);
		boolean isContentTextValid = validateStrings(contentTextString, errorIconContentText);

		if (isImagePathValid && isHeaderValid && isShortDescriptionValid && isContentTextValid) {

			String newImagePath = copyPicture(selectedPicture);
			manageBlogController.createBlog(newImagePath, headerString, contentTextString, shortDescriptionString,
					LocalDate.now());

			JOptionPane.showMessageDialog(contentPane, "Blog was successfully created!");

			imagePathString = "";
			textFieldHeader.setText("");
			textPaneShortDescription.setText("");
			textPaneContentText.setText("");
			pathLbl.setText("select the image for blog..");
		}
	}

	private void cancelCreateBlog() {
		cancelCreateBlog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		cancelCreateBlog.setLocationRelativeTo(this);
		cancelCreateBlog.setVisible(true);
	}

	private boolean validateStrings(String line, JLabel label) {
		boolean isValid = true;

		if (line.equals("")) {
			label.setVisible(true);
			isValid = false;
		} else {
			label.setVisible(false);
		}

		return isValid;
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
		File destination = new File(DirectoryPaths.BLOG_IMAGES);

		try {
			FileUtils.copyFileToDirectory(picture, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return destination + "\\" + "\\" + picture.getName();
	}
}

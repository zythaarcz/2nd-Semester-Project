package guilayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllayer.AuthenticationController;
import controllayer.DietConsultationController;
import modellayer.AuthenticatedUser;
import modellayer.PersonTypes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;

public class DietConsultation extends JFrame implements PropertyChangeListener {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField companyNameTextField;
	private JTextField reasonTextField;
	private JFormattedTextField dateTextField;

	private AuthenticationController authenticationController;
	private DietConsultationController dietConsultationController;
	private SideBarCustomer sideBarCustomer;
	/**
	 * Create the frame.
	 */
	public DietConsultation() {
		authenticationController = new AuthenticationController();
		dietConsultationController = new DietConsultationController();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Book diet consultation");
		contentPane.setLayout(null);
		
		sideBarCustomer = new SideBarCustomer();
		sideBarCustomer.setSize(0, 740);
		sideBarCustomer.setVisible(false);
		contentPane.add(sideBarCustomer);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(DietConsultation.class.getResource("/images/logo.png")));
		logo.setBounds(71, 27, 300, 115);
		contentPane.add(logo);
		
		JLabel BookDietConsultationLabel = new JLabel("Book diet consultation");
		BookDietConsultationLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		BookDietConsultationLabel.setBounds(39, 176, 370, 17);
		contentPane.add(BookDietConsultationLabel);
		
		JLabel firstNameLabel = new JLabel("First name");
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		firstNameLabel.setBounds(39, 210, 370, 17);
		contentPane.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstNameTextField.setText(AuthenticatedUser.getInstance().getCurrentUser().getFirstName());
		firstNameTextField.setEditable(false);
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(39, 230, 216, 43);
		contentPane.add(firstNameTextField);
		
		JLabel lastNameLabel = new JLabel("Last name");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameLabel.setBounds(39, 284, 380, 17);
		contentPane.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastNameTextField.setText(AuthenticatedUser.getInstance().getCurrentUser().getLastName());
		lastNameTextField.setEditable(false);
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(39, 304, 216, 43);
		contentPane.add(lastNameTextField);
		
		JLabel companyNameLabel = new JLabel("Company name");
		companyNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		companyNameLabel.setBounds(39, 358, 380, 17);
		contentPane.add(companyNameLabel);
		
		companyNameTextField = new JTextField();
		companyNameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
			companyNameTextField.setText(authenticationController.getCustomer().getCompany());
		}
		companyNameTextField.setEditable(false);
		companyNameTextField.setColumns(10);
		companyNameTextField.setBounds(39, 378, 216, 43);
		contentPane.add(companyNameTextField);
		
		JLabel errorIconImagePath = new JLabel("");
		errorIconImagePath.setIcon(new ImageIcon(CreateBlog.class.getResource("/images/iconError32px.png")));
		errorIconImagePath.setBounds(265, 526, 32, 43);
		errorIconImagePath.setVisible(false);
		contentPane.add(errorIconImagePath);
		
		JLabel reasonLabel = new JLabel("Reason for consultation");
		reasonLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		reasonLabel.setBounds(39, 506, 380, 17);
		contentPane.add(reasonLabel);
		
		reasonTextField = new JTextField();
		reasonTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reasonTextField.setColumns(10);
		reasonTextField.setBounds(39, 526, 216, 43);
		contentPane.add(reasonTextField);
		
		JLabel availableDateLabel = new JLabel("Choose available date");
		availableDateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		availableDateLabel.setBounds(39, 432, 370, 17);
		contentPane.add(availableDateLabel);
		
		dateTextField = new JFormattedTextField();
		dateTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateTextField.setPreferredSize(new Dimension(130, 30));
		dateTextField.setValue(new Date()); //curent date
		dateTextField.setBounds(39, 452, 216, 43);
		contentPane.add(dateTextField);
		
		CalendarWindow calendarWindow = new CalendarWindow();
		calendarWindow.setUndecorated(true);
		calendarWindow.addPropertyChangeListener(this);
		
		JButton chooseButton = new JButton("Choose");
		chooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calendarWindow.setLocation(dateTextField.getLocationOnScreen().x, dateTextField.getLocationOnScreen().y + dateTextField.getHeight());
				Date selectedDate = (Date) dateTextField.getValue();
				calendarWindow.resetSelection(selectedDate);
				
				calendarWindow.setVisible(true);
			}
		});
		chooseButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chooseButton.setBackground(new Color(255, 208, 32));
		chooseButton.setBounds(277, 452, 94, 43);
		contentPane.add(chooseButton);
		
		JButton bookConsultationButton = new JButton("Book consultation");
		bookConsultationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reason = reasonTextField.getText();
				if(validateString(reason, errorIconImagePath)) {
					Date date = (Date) dateTextField.getValue();
		            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		            
		            if(LocalDate.now().isBefore(localDate)) {
		            	boolean wasCreated = dietConsultationController.createDietConsultation(localDate, reason);

						if(wasCreated) {
							JOptionPane.showMessageDialog(contentPane, "The meeting was created.");		
							HomepageCustomer homepageCustomer = new HomepageCustomer();
							homepageCustomer.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(contentPane, "We are sorry, but another customer booked the meeting before you.\nTry another date.");
						}
		            } else {
		            	JOptionPane.showMessageDialog(contentPane, "You can not chose past date.");
		            }
				} else {
					JOptionPane.showMessageDialog(contentPane, "You must fill in the reason of diet meeting");
				}
			}
		});
		bookConsultationButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookConsultationButton.setBackground(new Color(255, 208, 32));
		bookConsultationButton.setBounds(255, 624, 171, 38);
		contentPane.add(bookConsultationButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setRolloverEnabled(false);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AuthenticatedUser.getInstance().getCurrentUser().getPersonType() == PersonTypes.Customer) {
					HomepageCustomer homepage = new HomepageCustomer();
					homepage.setVisible(true);
					dispose();
				} else {
					HomepageEmployee homepage = new HomepageEmployee();
					homepage.setVisible(true);
					dispose();
				}
				
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBackground(new Color(255, 208, 32));
		cancelButton.setBounds(100, 624, 145, 38);
		contentPane.add(cancelButton);
		
		
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JPanel) sideBarCustomer).setVisible(true);
				sideBarCustomer.runSidebar();
			}
		});
		sidebarButton.setIcon(new ImageIcon(DietConsultation.class.getResource("/images/sidebarIcon35px.png")));
		sidebarButton.setOpaque(false);
		sidebarButton.setForeground(Color.BLACK);
		sidebarButton.setBorderPainted(false);
		sidebarButton.setBackground(Color.LIGHT_GRAY);
		sidebarButton.setBounds(10, 10, 43, 39);
		contentPane.add(sidebarButton);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//get the selected date from the calendar control and set it to the text field
		if (evt.getPropertyName().equals("selectedDate")) {
            
			java.util.Calendar cal = (java.util.Calendar)evt.getNewValue();
			Date selDate =  cal.getTime();
			dateTextField.setValue(selDate);
		}
		
	}
	
	private boolean validateString(String line, JLabel label) {
		boolean isValid = true;
		
		if(line.equals("")) {
			label.setVisible(true);
			isValid = false;
		} else {
			label.setVisible(false);
		} 
		
		return isValid;
	}
}
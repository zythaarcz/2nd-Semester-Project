package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.util.Date;
import java.awt.event.ActionEvent;

public class DietConsultation extends JFrame implements PropertyChangeListener {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField companyNameTextField;
	private JTextField reasonTextField;
	private SideBarCustomer sidebar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietConsultation frame = new DietConsultation();
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
	public DietConsultation() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Book diet consultation");
		contentPane.setLayout(null);
		
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
		firstNameLabel.setBounds(39, 215, 370, 17);
		contentPane.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setColumns(10);
		firstNameTextField.setBounds(39, 242, 216, 28);
		contentPane.add(firstNameTextField);
		
		JLabel lastNameLabel = new JLabel("Last name");
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lastNameLabel.setBounds(39, 280, 380, 17);
		contentPane.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(39, 307, 216, 28);
		contentPane.add(lastNameTextField);
		
		JLabel companyNameLabel = new JLabel("Company name");
		companyNameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		companyNameLabel.setBounds(39, 345, 380, 17);
		contentPane.add(companyNameLabel);
		
		companyNameTextField = new JTextField();
		companyNameTextField.setColumns(10);
		companyNameTextField.setBounds(39, 372, 216, 28);
		contentPane.add(companyNameTextField);
		
		JLabel reasonLabel = new JLabel("Reason for consultation");
		reasonLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		reasonLabel.setBounds(39, 482, 380, 17);
		contentPane.add(reasonLabel);
		
		reasonTextField = new JTextField();
		reasonTextField.setColumns(10);
		reasonTextField.setBounds(39, 509, 216, 28);
		contentPane.add(reasonTextField);
		
		JLabel availableDateLabel = new JLabel("Choose available date");
		availableDateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		availableDateLabel.setBounds(39, 420, 370, 17);
		contentPane.add(availableDateLabel);
		
		JFormattedTextField dateTextField = new JFormattedTextField();
		dateTextField.setPreferredSize(new Dimension(130, 30));
		dateTextField.setValue(new Date()); //curent date
		dateTextField.setBounds(39, 447, 216, 25);
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
		chooseButton.setBounds(281, 447, 94, 25);
		contentPane.add(chooseButton);
		
		JButton bookConsultationButton = new JButton("Book consultation");
		bookConsultationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet.");
			}
		});
		bookConsultationButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bookConsultationButton.setBackground(new Color(255, 208, 32));
		bookConsultationButton.setBounds(255, 624, 171, 38);
		contentPane.add(bookConsultationButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Not implemented yet.");
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBackground(new Color(255, 208, 32));
		cancelButton.setBounds(100, 624, 145, 38);
		contentPane.add(cancelButton);
		
		SideBarCustomer sidebar = new SideBarCustomer();
		sidebar.setSize(0, 740);
		contentPane.add(sidebar);
		sidebar.setVisible(false);
		
		JButton sidebarButton = new JButton("");
		sidebarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sidebar.setVisible(true);
				sidebar.setSize(225, 740);
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
			//dateTextField.setValue(selDate);
		}
		
	}
	}

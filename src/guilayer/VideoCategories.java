package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VideoCategories extends JFrame {

	private JPanel contentPane;
	private JLabel logoImage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VideoCategories frame = new VideoCategories();
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
	public VideoCategories() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(5, 5, 439, 717);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{60, 305, 49, 0};
		gbl_panel.rowHeights = new int[]{44, 74, 70, 43, 45, 50, 50, 50, 50, 50, 50, 50, 50, 0, 50, 50};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		logoImage = new JLabel(new ImageIcon(VideoCategories.class.getResource("/images/logo.png")));
		GridBagConstraints gbc_logoImage = new GridBagConstraints();
		gbc_logoImage.anchor = GridBagConstraints.NORTHEAST;
		gbc_logoImage.insets = new Insets(0, 0, 5, 5);
		gbc_logoImage.gridx = 1;
		gbc_logoImage.gridy = 1;
		panel.add(logoImage, gbc_logoImage);
		
		JLabel lblNewLabel = new JLabel("All categories");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_7 = new JButton("All videos");
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_7.gridx = 1;
		gbc_btnNewButton_7.gridy = 5;
		panel.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("Stretch exercises");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 1;
		gbc_btnNewButton_6.gridy = 6;
		panel.add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Warm-up");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 7;
		panel.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Quick 5-minute exercises");
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 8;
		panel.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Boost your focus");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 9;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Back exercises");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 10;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Neck exercises");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 11;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Lower body exercises");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 12;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_8 = new JButton("Meditation exercises");
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_8.gridx = 1;
		gbc_btnNewButton_8.gridy = 14;
		panel.add(btnNewButton_8, gbc_btnNewButton_8);
	}
}

package guilayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Color;

public class VideoCategoriesEmployee extends JFrame {

	private JPanel contentPane;
	private JLabel logoImage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VideoCategoriesEmployee frame = new VideoCategoriesEmployee();
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
	public VideoCategoriesEmployee() {
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
		gbl_panel.rowHeights = new int[]{44, 74, 70, 43, 45, 50, 50, 50, 50, 50, 50, 50, 50, 0, 50, 50, 50};
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
		
		JLabel lblAllCategories = new JLabel("All categories");
		lblAllCategories.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GridBagConstraints gbc_lblAllCategories = new GridBagConstraints();
		gbc_lblAllCategories.insets = new Insets(0, 0, 5, 5);
		gbc_lblAllCategories.gridx = 1;
		gbc_lblAllCategories.gridy = 3;
		panel.add(lblAllCategories, gbc_lblAllCategories);
		
		JButton btnAllVideos = new JButton("All videos");
		GridBagConstraints gbc_btnAllVideos = new GridBagConstraints();
		gbc_btnAllVideos.insets = new Insets(0, 0, 5, 5);
		gbc_btnAllVideos.gridx = 1;
		gbc_btnAllVideos.gridy = 5;
		panel.add(btnAllVideos, gbc_btnAllVideos);
		
		JButton btnStrechExercise = new JButton("Stretch exercises");
		GridBagConstraints gbc_btnStrechExercise = new GridBagConstraints();
		gbc_btnStrechExercise.fill = GridBagConstraints.BOTH;
		gbc_btnStrechExercise.insets = new Insets(0, 0, 5, 5);
		gbc_btnStrechExercise.gridx = 1;
		gbc_btnStrechExercise.gridy = 6;
		panel.add(btnStrechExercise, gbc_btnStrechExercise);
		
		JButton btnWarmUp = new JButton("Warm-up");
		GridBagConstraints gbc_btnWarmUp = new GridBagConstraints();
		gbc_btnWarmUp.fill = GridBagConstraints.BOTH;
		gbc_btnWarmUp.insets = new Insets(0, 0, 5, 5);
		gbc_btnWarmUp.gridx = 1;
		gbc_btnWarmUp.gridy = 7;
		panel.add(btnWarmUp, gbc_btnWarmUp);
		
		JButton btnQuickExercise = new JButton("Quick 5-minute exercises");
		GridBagConstraints gbc_btnQuickExercise = new GridBagConstraints();
		gbc_btnQuickExercise.fill = GridBagConstraints.BOTH;
		gbc_btnQuickExercise.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuickExercise.gridx = 1;
		gbc_btnQuickExercise.gridy = 8;
		panel.add(btnQuickExercise, gbc_btnQuickExercise);
		
		JButton btnBoostFocus = new JButton("Boost your focus");
		GridBagConstraints gbc_btnBoostFocus = new GridBagConstraints();
		gbc_btnBoostFocus.fill = GridBagConstraints.BOTH;
		gbc_btnBoostFocus.insets = new Insets(0, 0, 5, 5);
		gbc_btnBoostFocus.gridx = 1;
		gbc_btnBoostFocus.gridy = 9;
		panel.add(btnBoostFocus, gbc_btnBoostFocus);
		
		JButton btnBackExercise = new JButton("Back exercises");
		GridBagConstraints gbc_btnBackExercise = new GridBagConstraints();
		gbc_btnBackExercise.fill = GridBagConstraints.BOTH;
		gbc_btnBackExercise.insets = new Insets(0, 0, 5, 5);
		gbc_btnBackExercise.gridx = 1;
		gbc_btnBackExercise.gridy = 10;
		panel.add(btnBackExercise, gbc_btnBackExercise);
		
		JButton btnNeckExercise = new JButton("Neck exercises");
		GridBagConstraints gbc_btnNeckExercise = new GridBagConstraints();
		gbc_btnNeckExercise.fill = GridBagConstraints.BOTH;
		gbc_btnNeckExercise.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeckExercise.gridx = 1;
		gbc_btnNeckExercise.gridy = 11;
		panel.add(btnNeckExercise, gbc_btnNeckExercise);
		
		JButton btnLowerBodyExercise = new JButton("Lower body exercises");
		GridBagConstraints gbc_btnLowerBodyExercise = new GridBagConstraints();
		gbc_btnLowerBodyExercise.fill = GridBagConstraints.BOTH;
		gbc_btnLowerBodyExercise.insets = new Insets(0, 0, 5, 5);
		gbc_btnLowerBodyExercise.gridx = 1;
		gbc_btnLowerBodyExercise.gridy = 12;
		panel.add(btnLowerBodyExercise, gbc_btnLowerBodyExercise);
		
		JButton btnMeditationExercise = new JButton("Meditation exercises");
		GridBagConstraints gbc_btnMeditationExercise = new GridBagConstraints();
		gbc_btnMeditationExercise.fill = GridBagConstraints.BOTH;
		gbc_btnMeditationExercise.insets = new Insets(0, 0, 5, 5);
		gbc_btnMeditationExercise.gridx = 1;
		gbc_btnMeditationExercise.gridy = 14;
		panel.add(btnMeditationExercise, gbc_btnMeditationExercise);
		
		JButton btnAddNewCategory = new JButton("Add new category");
		btnAddNewCategory.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnAddNewCategory = new GridBagConstraints();
		gbc_btnAddNewCategory.fill = GridBagConstraints.BOTH;
		gbc_btnAddNewCategory.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddNewCategory.gridx = 1;
		gbc_btnAddNewCategory.gridy = 15;
		panel.add(btnAddNewCategory, gbc_btnAddNewCategory);
	}
}

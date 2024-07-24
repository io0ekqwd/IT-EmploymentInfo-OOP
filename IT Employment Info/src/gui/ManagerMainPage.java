package gui;

import javax.swing.JPanel;

import controller.MainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ManagerMainPage extends JPanel {
	private MainFrame main;
	private ImageIcon img1, img2, img3;
	public ManagerMainPage(MainFrame main) {
		setLayout(null);
		this.setSize(700, 400);
		this.main = main;
		
		
		JLabel lblManagerPage = new JLabel("Manager Page");
		lblManagerPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblManagerPage.setBounds(297, 11, 115, 21);
		add(lblManagerPage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(SystemColor.controlHighlight);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?","Logout", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.showLogin();
				}
				else
					return;
			}
		});
		btnLogout.setBounds(248, 308, 207, 60);
		add(btnLogout);
		
		JButton btnApplicantPage = new JButton("Applicant Page");
		btnApplicantPage.setBackground(SystemColor.controlHighlight);
		btnApplicantPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showManagerGUI();
			}
		});
		btnApplicantPage.setBounds(43, 56, 164, 38);
		add(btnApplicantPage);
		
		JButton btnShortlistPage = new JButton("Shortlist Page");
		btnShortlistPage.setBackground(SystemColor.controlHighlight);
		btnShortlistPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showShortGUI();
			}
		});
		btnShortlistPage.setBounds(275, 56, 155, 38);
		add(btnShortlistPage);
		
		JButton btnJobPage = new JButton("Job Page");
		btnJobPage.setBackground(SystemColor.controlHighlight);
		btnJobPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showJobGUI();
			}
		});
		btnJobPage.setBounds(493, 56, 170, 38);
		add(btnJobPage);
		
		this.img1 = new ImageIcon("images/icons8-profile-100.png");
		JLabel lblNewLabel = new JLabel(this.img1);
		lblNewLabel.setBounds(65, 116, 119, 156);
		add(lblNewLabel);
		
		this.img2 = new ImageIcon("images/icons8-shortlist-64.png");
		JLabel lblNewLabel_1 = new JLabel(this.img2);
		lblNewLabel_1.setBounds(286, 128, 135, 142);
		add(lblNewLabel_1);
		
		this.img3 = new ImageIcon("images/icons8-job-100.png");
		JLabel lblNewLabel_2 = new JLabel(this.img3);
		lblNewLabel_2.setBounds(505, 128, 155, 142);
		add(lblNewLabel_2);
	}
}

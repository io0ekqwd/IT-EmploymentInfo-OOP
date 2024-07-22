package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.ApplicantDetails;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DetailPage extends JPanel {
	private MainFrame main;
	private int index;
	private ApplicantDetails det;
	
	public DetailPage(MainFrame main, int ind, ApplicantDetails det) {
		this.main = main;
		this.index = ind;
		this.det = det;
		setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(174, 56, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(174, 81, 46, 14);
		add(lblAge);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setBounds(174, 181, 102, 14);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(174, 106, 46, 14);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(174, 206, 102, 14);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(174, 131, 89, 14);
		add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(174, 156, 46, 14);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(10, 275, 143, 14);
		add(lblPSkills);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String p = main.getController().getID();
			if (p.equals("p1"))
				main.showManagerGUI();
			if (p.equals("p2"))
				main.showShortGUI();
			if (p.equals("p3"))
				main.showJobGUI();
			main.getController().clearID();
			}
			});
		
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		
		JLabel lblNameL = new JLabel("");
		lblNameL.setBounds(216, 56, 115, 14);
		add(lblNameL);
		lblNameL.setText(det.getName());
		
		JLabel lblAgeL = new JLabel("Test");
		lblAgeL.setBounds(216, 81, 46, 14);
		add(lblAgeL);
		lblAgeL.setText(String.valueOf(det.getAge()));
		
		JLabel lblPhoneL = new JLabel("");
		lblPhoneL.setBounds(267, 181, 74, 14);
		add(lblPhoneL);
		lblPhoneL.setText(det.getPhone());
		
		JLabel lblEmailL = new JLabel("");
		lblEmailL.setBounds(216, 106, 83, 14);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblAddressL = new JLabel("");
		lblAddressL.setBounds(244, 206, 115, 14);
		add(lblAddressL);
		lblAddressL.setText(det.getAddress());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(226, 131, 143, 14);
		add(lblPosL);
		lblPosL.setText(det.getPosition());
		
		JLabel lblStatusL = new JLabel("Test");
		lblStatusL.setBounds(230, 156, 46, 14);
		add(lblStatusL);
		lblPosL.setText(det.getStatus());
		
		JLabel lblPSkillsL = new JLabel("");
		lblPSkillsL.setBounds(113, 275, 107, 14);
		add(lblPSkillsL);
		lblPSkillsL.setText(det.getSkills().getPskills());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(216, 275, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel lblISkillsL = new JLabel("");
		lblISkillsL.setBounds(310, 275, 115, 14);
		add(lblISkillsL);
		lblISkillsL.setText(det.getSkills().getIskills());
		
		JLabel label = new JLabel("<image here>");
		label.setBounds(10, 45, 154, 154);
		add(label);
	}
}

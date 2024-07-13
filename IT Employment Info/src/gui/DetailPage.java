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
		lblName.setBounds(10, 58, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 83, 46, 14);
		add(lblAge);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setBounds(10, 108, 102, 14);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 133, 46, 14);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 158, 102, 14);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 184, 89, 14);
		add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 209, 46, 14);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(10, 234, 143, 14);
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
		lblNameL.setBounds(51, 58, 115, 14);
		add(lblNameL);
		lblNameL.setText(det.getName());
		
		JLabel lblAgeL = new JLabel("");
		lblAgeL.setBounds(66, 83, 83, 14);
		add(lblAgeL);
		
		JLabel lblPhoneL = new JLabel("");
		lblPhoneL.setBounds(99, 108, 74, 14);
		add(lblPhoneL);
		lblPhoneL.setText(det.getPhone());
		
		JLabel lblEmailL = new JLabel("");
		lblEmailL.setBounds(66, 133, 83, 14);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblAddressL = new JLabel("");
		lblAddressL.setBounds(66, 158, 115, 14);
		add(lblAddressL);
		lblAddressL.setText(det.getAddress());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(66, 184, 143, 14);
		add(lblPosL);
		lblPosL.setText(det.getPosition());
		
		JLabel lblStatusL = new JLabel("");
		lblStatusL.setBounds(66, 209, 46, 14);
		add(lblStatusL);
		lblPosL.setText(det.getStatus());
		
		JLabel lblPSkillsL = new JLabel("");
		lblPSkillsL.setBounds(129, 234, 107, 14);
		add(lblPSkillsL);
		lblPSkillsL.setText(det.getSkills().getPskills());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(10, 259, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel lblISkillsL = new JLabel("");
		lblISkillsL.setBounds(107, 259, 115, 14);
		add(lblISkillsL);
		lblISkillsL.setText(det.getSkills().getIskills());
	}
}

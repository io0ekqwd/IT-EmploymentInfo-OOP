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
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class DetailPageJob extends JPanel {
	private MainFrame main;
	private int index;
	private ApplicantDetails det;
	
	public DetailPageJob(MainFrame main, int ind, ApplicantDetails det) {
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
		
		JLabel lblPositionA = new JLabel("Applied Position:");
		lblPositionA.setBounds(174, 131, 126, 14);
		add(lblPositionA);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(174, 156, 46, 14);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(10, 275, 143, 14);
		add(lblPSkills);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
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
		
		JLabel lblAgeL = new JLabel("");
		lblAgeL.setBounds(204, 81, 46, 14);
		add(lblAgeL);
		lblAgeL.setText(String.valueOf(det.getAge()));
		
		JLabel lblPhoneL = new JLabel("");
		lblPhoneL.setBounds(267, 181, 74, 14);
		add(lblPhoneL);
		lblPhoneL.setText(det.getPhone());
		
		JLabel lblEmailL = new JLabel("");
		lblEmailL.setBounds(216, 106, 143, 14);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(310, 131, 143, 14);
		add(lblPosL);
		lblPosL.setText(det.getAPosition());
		
		JLabel lblStatusL = new JLabel("");
		lblStatusL.setBounds(216, 156, 153, 14);
		add(lblStatusL);
		lblStatusL.setText(det.getStatus());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(216, 275, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel label = new JLabel("<image here>");
		label.setBounds(10, 45, 154, 154);
		add(label);
		
		JTextArea textAddress = new JTextArea();
		textAddress.setForeground(SystemColor.desktop);
		textAddress.setEditable(false);
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAddress.setBounds(226, 206, 133, 56);
		textAddress.setOpaque(false);
		add(textAddress);
		textAddress.setText(det.getAddress());
		
		JTextArea textPSkills = new JTextArea();
		textPSkills.setEditable(false);
		textPSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPSkills.setBounds(137, 273, 126, 56);
		textPSkills.setOpaque(false);
		add(textPSkills);
		textPSkills.setText(det.getSkills().getPskills());
		
		JTextArea textISkills = new JTextArea();
		textISkills.setEditable(false);
		textISkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textISkills.setBounds(317, 273, 133, 56);
		textISkills.setOpaque(false);
		add(textISkills);
		textISkills.setText(det.getSkills().getIskills());
	}
}

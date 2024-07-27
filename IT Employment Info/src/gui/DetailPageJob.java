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
		main.setSize(600,400);
		setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(174, 58, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(360, 58, 46, 14);
		add(lblAge);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setBounds(174, 133, 102, 14);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(174, 83, 46, 14);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(174, 158, 102, 14);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Applied Position:");
		lblPosition.setBounds(308, 83, 115, 14);
		add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(174, 108, 46, 14);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(79, 245, 115, 14);
		add(lblPSkills);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showJobGUI();
			}
			});
		
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		
		JLabel lblNameL = new JLabel("");
		lblNameL.setBounds(215, 58, 115, 14);
		add(lblNameL);
		lblNameL.setText(det.getName());
		
		JLabel lblAgeL = new JLabel("");
		lblAgeL.setBounds(393, 58, 46, 14);
		add(lblAgeL);
		lblAgeL.setText(String.valueOf(det.getAge()));
		
		JLabel lblPhoneL = new JLabel("");
		lblPhoneL.setBounds(268, 133, 74, 14);
		add(lblPhoneL);
		lblPhoneL.setText(det.getPhone());
		
		JLabel lblEmailL = new JLabel("");
		lblEmailL.setBounds(215, 83, 143, 14);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(433, 83, 143, 14);
		add(lblPosL);
		lblPosL.setText(det.getAPosition());
		
		JLabel lblStatusL = new JLabel("");
		lblStatusL.setBounds(215, 108, 153, 14);
		add(lblStatusL);
		lblStatusL.setText(det.getStatus());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(317, 245, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel label = new JLabel("             <image here>");
		label.setBounds(10, 45, 154, 154);
		add(label);
		
		JTextArea textAddress = new JTextArea();
		textAddress.setForeground(SystemColor.desktop);
		textAddress.setEditable(false);
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAddress.setBounds(197, 243, 133, 56);
		textAddress.setOpaque(false);
		add(textAddress);
		textAddress.setText(det.getAddress());
		
		JTextArea textPSkills = new JTextArea();
		textPSkills.setEditable(false);
		textPSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPSkills.setBounds(237, 158, 126, 56);
		textPSkills.setOpaque(false);
		add(textPSkills);
		textPSkills.setText(det.getSkills().getPskills());
		
		JTextArea textISkills = new JTextArea();
		textISkills.setEditable(false);
		textISkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textISkills.setBounds(423, 243, 133, 56);
		textISkills.setOpaque(false);
		add(textISkills);
		textISkills.setText(det.getSkills().getIskills());
		
		JLabel lblHiredPosition = new JLabel("Hired Position:");
		lblHiredPosition.setBounds(342, 108, 79, 14);
		add(lblHiredPosition);
		
		
		JLabel textHPos = new JLabel("");
		textHPos.setBounds(441, 108, 89, 14);
		add(textHPos);
		textHPos.setText(det.getHPosition());
		
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(375, 133, 46, 14);
		add(lblSalary);
		
		
		JLabel textSalary = new JLabel("");
		textSalary.setBounds(430, 133, 46, 14);
		add(textSalary); 
		textSalary.setText(String.valueOf(det.getSalary()));
		
	}
}

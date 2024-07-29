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
		lblAge.setBounds(174, 83, 46, 14);
		add(lblAge);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setBounds(174, 108, 102, 14);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(174, 133, 46, 14);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(174, 208, 102, 14);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Applied Position:");
		lblPosition.setBounds(174, 183, 115, 14);
		add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(174, 158, 46, 14);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(10, 273, 115, 14);
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
			main.getController().clearID();
			}
			});
		
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		
		JLabel lblNameL = new JLabel("");
		lblNameL.setBounds(215, 58, 115, 14);
		add(lblNameL);
		lblNameL.setText(det.getName());
		
		JLabel lblAgeL = new JLabel("");
		lblAgeL.setBounds(225, 83, 46, 14);
		add(lblAgeL);
		lblAgeL.setText(String.valueOf(det.getAge()));
		
		JLabel lblPhoneL = new JLabel("");
		lblPhoneL.setBounds(281, 108, 74, 14);
		add(lblPhoneL);
		lblPhoneL.setText(det.getPhone());
		
		JLabel lblEmailL = new JLabel("");
		lblEmailL.setBounds(212, 133, 143, 14);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(286, 183, 143, 14);
		add(lblPosL);
		lblPosL.setText(det.getAPosition());
		
		JLabel lblStatusL = new JLabel("");
		lblStatusL.setBounds(222, 158, 153, 14);
		add(lblStatusL);
		lblStatusL.setText(det.getStatus());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(158, 273, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel label = new JLabel("             <image here>");
		label.setBounds(10, 45, 154, 154);
		add(label);
		
		JTextArea textAddress = new JTextArea();
		textAddress.setForeground(SystemColor.desktop);
		textAddress.setEditable(false);
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAddress.setBounds(222, 206, 133, 56);
		textAddress.setOpaque(false);
		add(textAddress);
		textAddress.setText(det.getAddress());
		
		JTextArea textPSkills = new JTextArea();
		textPSkills.setEditable(false);
		textPSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPSkills.setBounds(10, 289, 126, 56);
		textPSkills.setOpaque(false);
		add(textPSkills);
		textPSkills.setText(det.getSkills().getPskills());
		
		JTextArea textISkills = new JTextArea();
		textISkills.setEditable(false);
		textISkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textISkills.setBounds(156, 289, 133, 56);
		textISkills.setOpaque(false);
		add(textISkills);
		textISkills.setText(det.getSkills().getIskills());
		
		JLabel lblExperience = new JLabel("Experience:");
		lblExperience.setBounds(281, 273, 102, 14);
		add(lblExperience);
		
		JTextArea textExp = new JTextArea();
		textExp.setEditable(false);
		textExp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textExp.setOpaque(false);
		textExp.setBounds(281, 286, 115, 59);
		add(textExp);
		//textExp.setText(det.getExp());
		
		JLabel lblHiredPosition = new JLabel("Hired Position:");
		lblHiredPosition.setBounds(337, 58, 92, 14);
		add(lblHiredPosition);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(372, 83, 46, 14);
		add(lblSalary);
		
		JLabel lblHPos = new JLabel("New label");
		lblHPos.setBounds(439, 58, 46, 14);
		add(lblHPos);
		lblHPos.setText(det.getHPosition());
		
		JLabel lblSal = new JLabel("New label");
		lblSal.setBounds(439, 83, 46, 14);
		add(lblSal);
		lblSal.setText(String.valueOf(det.getSalary()));
		
		
	}
}

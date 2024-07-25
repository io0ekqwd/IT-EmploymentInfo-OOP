package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;
import data.ApplicantDetails;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffUpdate extends JPanel{
	private MainFrame main;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textPosition;
	private JTextField textStatus;
	private JTextArea textPSkills;
	private JTextArea textISkills;
	private JTextArea textAddress;
	private int index;
	private ApplicantDetails det;
	public HRStaffUpdate(MainFrame main, int ind, ApplicantDetails det) {
		setLayout(null);
		this.index = ind;
		this.det = det;
		this.main = main;
		
		JButton button = new JButton("Logout");
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
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
		button.setBounds(570, 9, 108, 49);
		add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showHRStaffApplicantPage();
			}
		});
		button_1.setBounds(10, 9, 116, 49);
		add(button_1);
		
		JLabel lblUpdateApplicantPage = new JLabel("Update Applicant Page");
		lblUpdateApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUpdateApplicantPage.setBounds(285, 9, 161, 25);
		add(lblUpdateApplicantPage);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(363, 57, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Age:");
		label_1.setBounds(373, 82, 27, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Phone Number:");
		label_2.setBounds(312, 113, 97, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setBounds(363, 140, 56, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Address:");
		label_4.setBounds(421, 232, 56, 16);
		add(label_4);
		
		JLabel label_5 = new JLabel("Position:");
		label_5.setBounds(353, 169, 56, 16);
		add(label_5);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(SystemColor.controlHighlight);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				int age = Integer.valueOf(textAge.getText());
				String email = textEmail.getText();
				String phone = textPhone.getText();
				String address = textAddress.getText();
				String position = textPosition.getText();
				String ps = textPSkills.getText();
				String is = textISkills.getText();
				String status = textStatus.getText();
				main.getController().editApplicant(index, det, name, age, email, phone, address, position, ps, is, status);
				main.showHRStaffApplicantPage();
				textName.setText("");
				textAge.setText("");
				textEmail.setText("");
				textPhone.setText("");
				textAddress.setText("");
				textPosition.setText("");
				textPSkills.setText("");
				textISkills.setText("");
				textStatus.setText("");
				
			}
		});
		btnUpdate.setBounds(421, 348, 108, 49);
		add(btnUpdate);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(421, 54, 86, 20);
		add(textName);
	    textName.setText(det.getName()); 
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(421, 80, 86, 20);
		add(textAge);
		textAge.setText(String.valueOf(det.getAge())); 
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(421, 111, 86, 20);
		add(textPhone);
		textPhone.setText(det.getPhone()); 
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(421, 140, 116, 22);
		add(textEmail);
	    textEmail.setText(det.getEmail());
		
		textPosition = new JTextField();
		textPosition.setColumns(10);
		textPosition.setBounds(421, 167, 116, 22);
		add(textPosition);
		textPosition.setText(det.getAPosition());
		
		JLabel label_7 = new JLabel("Status:");
		label_7.setBounds(363, 198, 56, 16);
		add(label_7);
		
		textStatus = new JTextField();
		textStatus.setColumns(10);
		textStatus.setBounds(421, 194, 116, 22);
		add(textStatus);
		textStatus.setText(det.getStatus()); 
		
		JLabel label_6 = new JLabel("Programming skills:\r\n\r\n");
		label_6.setBounds(193, 232, 161, 16);
		add(label_6);
		
		JLabel lblIndustrySkills = new JLabel("Industry skills:");
		lblIndustrySkills.setBounds(193, 329, 116, 16);
		add(lblIndustrySkills);
		
		textPSkills = new JTextArea();
		textPSkills.setBounds(193, 252, 175, 70);
		add(textPSkills);
		textPSkills.setText(det.getSkills().getPskills()); 
		
		textISkills = new JTextArea();
		textISkills.setBounds(193, 348, 175, 50);
		add(textISkills);
		textISkills.setText(det.getSkills().getIskills()); 
		
		textAddress = new JTextArea();
		textAddress.setBounds(421, 252, 203, 77);
		add(textAddress);
		textAddress.setText(det.getAddress()); 
		
		JLabel label_8 = new JLabel("<Image>");
		label_8.setBounds(146, 110, 46, 14);
		add(label_8);
			 
	}
}

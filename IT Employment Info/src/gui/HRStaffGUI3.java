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

public class HRStaffGUI3 extends JPanel{
	private MainFrame main;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textAddress;
	private JTextField textPosition;
	private JTextField textPSkills;
	private JTextField textStatus;
	private JTextField textISkills;
	private int index;
	private ApplicantDetails det;
	public HRStaffGUI3(MainFrame main, int ind, ApplicantDetails det) {
		setLayout(null);
		this.index = ind;
		this.det = det;
		this.main = main;
		
		JButton button = new JButton("Logout");
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
		button.setBounds(341, 13, 97, 25);
		add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showHRStaffGUI();
			}
		});
		button_1.setBounds(12, 13, 97, 25);
		add(button_1);
		
		JLabel lblUpdateApplicantPage = new JLabel("Update Applicant Page");
		lblUpdateApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUpdateApplicantPage.setBounds(146, 17, 163, 16);
		add(lblUpdateApplicantPage);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(12, 51, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Age:");
		label_1.setBounds(12, 78, 27, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("Phone Number:");
		label_2.setBounds(12, 107, 97, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setBounds(12, 136, 56, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Address:");
		label_4.setBounds(12, 165, 56, 16);
		add(label_4);
		
		JLabel label_5 = new JLabel("Position:");
		label_5.setBounds(12, 194, 56, 16);
		add(label_5);
		
		JButton btnUpdate = new JButton("Update");
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
		btnUpdate.setBounds(12, 223, 108, 49);
		add(btnUpdate);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(111, 48, 86, 20);
		add(textName);
	    textName.setText(det.getName()); 
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(111, 76, 86, 20);
		add(textAge);
		textAge.setText(String.valueOf(det.getAge())); 
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(111, 104, 86, 20);
		add(textPhone);
		textPhone.setText(det.getPhone()); 
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(111, 133, 116, 22);
		add(textEmail);
	    textEmail.setText(det.getEmail()); 
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(111, 162, 116, 22);
		add(textAddress);
		textAddress.setText(det.getAddress()); 
		
		textPosition = new JTextField();
		textPosition.setColumns(10);
		textPosition.setBounds(111, 191, 116, 22);
		add(textPosition);
		textPosition.setText(det.getPosition()); 
		
		textPSkills = new JTextField();
		textPSkills.setColumns(10);
		textPSkills.setBounds(239, 78, 161, 34);
		add(textPSkills);
	    textPSkills.setText(det.getSkills().getPskills());
		
		JLabel label_7 = new JLabel("Status:");
		label_7.setBounds(239, 194, 56, 16);
		add(label_7);
		
		textStatus = new JTextField();
		textStatus.setColumns(10);
		textStatus.setBounds(285, 191, 116, 22);
		add(textStatus);
		textStatus.setText(det.getStatus()); 
		
		JLabel label_6 = new JLabel("Programming skills:\r\n\r\n");
		label_6.setBounds(239, 51, 161, 16);
		add(label_6);
		
		JLabel lblIndustrySkills = new JLabel("Industry skills:");
		lblIndustrySkills.setBounds(239, 118, 116, 16);
		add(lblIndustrySkills);
		
		textISkills = new JTextField();
		textISkills.setBounds(239, 136, 161, 42);
		add(textISkills);
		textISkills.setColumns(10);
		textISkills.setText(det.getSkills().getIskills());
			 
	}
}

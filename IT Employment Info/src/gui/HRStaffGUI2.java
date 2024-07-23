package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Skills;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HRStaffGUI2 extends JPanel{
	private MainFrame main;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textAddress;
	private JTextField textPostition;
	private JTextField textPS;
	private JTextField textStatus;
	private JTextField textIS;
	public HRStaffGUI2(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				int age = Integer.valueOf(textAge.getText());
				String email = textEmail.getText();
				String phone = textPhone.getText();
				String address = textAddress.getText();
				String position = textPostition.getText();
				String ps = textPS.getText();
				String is = textIS.getText();
				String status = textStatus.getText();
				main.getController().addApplicant(name, age, email, phone, address, position, ps, is, status);
				//test
				textName.setText("");
				textAge.setText("");
				textEmail.setText("");
				textPhone.setText("");
				textAddress.setText("");
				textPostition.setText("");
				textPS.setText("");
				textIS.setText("");
				textStatus.setText("");
				
			}
		});
		btnAdd.setBounds(34, 240, 108, 49);
		add(btnAdd);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?","Logout", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.showLogin();
				}
				else
					return;
			}
		});
		btnLogout.setBounds(329, 9, 97, 25);
		add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffGUI();
			}
		});
		btnBack.setBounds(10, 9, 97, 25);
		add(btnBack);
		
		JLabel lblAddApplicantPage = new JLabel("Add Applicant Page");
		lblAddApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddApplicantPage.setBounds(153, 4, 141, 25);
		add(lblAddApplicantPage);
		
		textName = new JTextField();
		textName.setBounds(102, 47, 86, 20);
		add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(102, 77, 86, 20);
		add(textAge);
		textAge.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 47, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 74, 27, 16);
		add(lblAge);
		
		textPhone = new JTextField();
		textPhone.setBounds(102, 104, 86, 20);
		add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone Number:");
		lblPhoneNo.setBounds(10, 106, 97, 16);
		add(lblPhoneNo);
		
		textEmail = new JTextField();
		textEmail.setBounds(102, 138, 116, 22);
		add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 141, 56, 16);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 170, 56, 16);
		add(lblAddress);
		
		textAddress = new JTextField();
		textAddress.setBounds(102, 173, 116, 22);
		add(textAddress);
		textAddress.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 211, 56, 16);
		add(lblPosition);
		
		textPostition = new JTextField();
		textPostition.setBounds(102, 208, 116, 22);
		add(textPostition);
		textPostition.setColumns(10);
		
		JLabel lblSkills = new JLabel("Programming skills:\r\n\r\n");
		lblSkills.setBounds(219, 49, 161, 16);
		add(lblSkills);
		
		textPS = new JTextField();
		textPS.setBounds(219, 67, 161, 40);
		add(textPS);
		textPS.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(230, 211, 56, 16);
		add(lblStatus);
		
		textStatus = new JTextField();
		textStatus.setBounds(275, 208, 116, 22);
		add(textStatus);
		textStatus.setColumns(10);
		
		JLabel lblIndustrySkills = new JLabel("Industry skills:");
		lblIndustrySkills.setBounds(229, 120, 82, 16);
		add(lblIndustrySkills);
		
		textIS = new JTextField();
		textIS.setBounds(230, 138, 150, 40);
		add(textIS);
		textIS.setColumns(10);
	}
}

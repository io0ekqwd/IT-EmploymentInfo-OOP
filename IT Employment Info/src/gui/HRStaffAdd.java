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
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffAdd extends JPanel{
	private MainFrame main;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textPostition;
	private JTextField textStatus;
	private JTextArea textPS;
	private JTextArea textIS;
	private JTextArea textAddress;
	public HRStaffAdd(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(SystemColor.controlHighlight);
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
				main.showHRStaffApplicantPage();
				/*textName.setText("");
				textAge.setText("");
				textEmail.setText("");
				textPhone.setText("");
				textAddress.setText("");
				textPostition.setText("");
				textPS.setText("");
				textIS.setText("");
				textStatus.setText("");*/
				
			}
		});
		btnAdd.setBounds(421, 348, 108, 49);
		add(btnAdd);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(SystemColor.controlHighlight);
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
		btnLogout.setBounds(570, 9, 108, 49);
		add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffApplicantPage();
			}
		});
		btnBack.setBounds(10, 9, 116, 49);
		add(btnBack);
		
		JLabel lblAddApplicantPage = new JLabel("Add Applicant Page");
		lblAddApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddApplicantPage.setBounds(285, 9, 141, 25);
		add(lblAddApplicantPage);
		
		textName = new JTextField();
		textName.setBounds(421, 54, 86, 20);
		add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(421, 80, 86, 20);
		add(textAge);
		textAge.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(363, 57, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(373, 82, 27, 16);
		add(lblAge);
		
		textPhone = new JTextField();
		textPhone.setBounds(421, 107, 86, 20);
		add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone Number:");
		lblPhoneNo.setBounds(312, 111, 97, 16);
		add(lblPhoneNo);
		
		textEmail = new JTextField();
		textEmail.setBounds(421, 135, 116, 22);
		add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(363, 140, 56, 16);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(421, 232, 56, 16);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(353, 168, 56, 16);
		add(lblPosition);
		
		textPostition = new JTextField();
		textPostition.setBounds(421, 165, 116, 22);
		add(textPostition);
		textPostition.setColumns(10);
		
		JLabel lblSkills = new JLabel("Programming skills:\r\n\r\n");
		lblSkills.setBounds(193, 232, 161, 16);
		add(lblSkills);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(363, 197, 56, 16);
		add(lblStatus);
		
		textStatus = new JTextField();
		textStatus.setBounds(419, 192, 118, 22);
		add(textStatus);
		textStatus.setColumns(10);
		
		JLabel lblIndustrySkills = new JLabel("Industry skills:");
		lblIndustrySkills.setBounds(193, 329, 82, 16);
		add(lblIndustrySkills);
		
		textPS = new JTextArea();
		textPS.setBounds(193, 252, 182, 69);
		add(textPS);
		
		textIS = new JTextArea();
		textIS.setBounds(193, 348, 182, 49);
		add(textIS);
		
		textAddress = new JTextArea();
		textAddress.setBounds(421, 252, 209, 69);
		add(textAddress);
		
		JLabel label = new JLabel("<Image>");
		label.setBounds(146, 110, 46, 14);
		add(label);
	}
}

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
		btnAdd.setBackground(Color.LIGHT_GRAY);
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
				main.showHRStaffGUI();
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
		btnAdd.setBounds(254, 339, 108, 49);
		add(btnAdd);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.LIGHT_GRAY);
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
		btnBack.setBackground(Color.LIGHT_GRAY);
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
		textName.setBounds(254, 54, 86, 20);
		add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(254, 82, 86, 20);
		add(textAge);
		textAge.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(217, 57, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(227, 82, 27, 16);
		add(lblAge);
		
		textPhone = new JTextField();
		textPhone.setBounds(254, 107, 86, 20);
		add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone Number:");
		lblPhoneNo.setBounds(166, 109, 97, 16);
		add(lblPhoneNo);
		
		textEmail = new JTextField();
		textEmail.setBounds(253, 136, 116, 22);
		add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(217, 138, 56, 16);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(217, 232, 56, 16);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(198, 168, 56, 16);
		add(lblPosition);
		
		textPostition = new JTextField();
		textPostition.setBounds(253, 165, 116, 22);
		add(textPostition);
		textPostition.setColumns(10);
		
		JLabel lblSkills = new JLabel("Programming skills:\r\n\r\n");
		lblSkills.setBounds(10, 232, 161, 16);
		add(lblSkills);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(207, 195, 56, 16);
		add(lblStatus);
		
		textStatus = new JTextField();
		textStatus.setBounds(254, 192, 118, 22);
		add(textStatus);
		textStatus.setColumns(10);
		
		JLabel lblIndustrySkills = new JLabel("Industry skills:");
		lblIndustrySkills.setBounds(10, 323, 82, 16);
		add(lblIndustrySkills);
		
		textPS = new JTextArea();
		textPS.setBounds(10, 247, 182, 69);
		add(textPS);
		
		textIS = new JTextArea();
		textIS.setBounds(10, 339, 182, 49);
		add(textIS);
		
		textAddress = new JTextArea();
		textAddress.setBounds(217, 247, 209, 69);
		add(textAddress);
		
		JLabel label = new JLabel("<Image>");
		label.setBounds(51, 110, 46, 14);
		add(label);
	}
}

package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MainFrame;
import data.Skills;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
	private JTextField textPosition;
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
				String position = textPosition.getText();
				String ps = textPS.getText();
				String is = textIS.getText();
				String status = textStatus.getText();
				main.getController().addApplicant(name, age, email, phone, address, position, ps, is, status);
				System.out.println(address);
				System.out.println(ps);
				System.out.println(is);
				main.showHRStaffApplicantPage();
			}
		});
		btnAdd.setBounds(464, 84, 86, 49);
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
		textName.setBounds(310, 67, 116, 20);
		add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setBounds(310, 98, 116, 20);
		add(textAge);
		textAge.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(267, 70, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(273, 100, 27, 16);
		add(lblAge);
		
		textPhone = new JTextField();
		textPhone.setBounds(310, 127, 116, 20);
		add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone Number:");
		lblPhoneNo.setBounds(216, 129, 98, 16);
		add(lblPhoneNo);
		
		textEmail = new JTextField();
		textEmail.setBounds(310, 158, 116, 22);
		add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(267, 161, 46, 16);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 228, 56, 16);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Applied Position:");
		lblPosition.setBounds(210, 195, 116, 16);
		add(lblPosition);
		
		textPosition = new JTextField();
		textPosition.setBounds(310, 192, 116, 22);
		add(textPosition);
		textPosition.setColumns(10);
		
		JLabel lblSkills = new JLabel("Programming skills:\r\n\r\n");
		lblSkills.setBounds(10, 333, 161, 16);
		add(lblSkills);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(257, 228, 56, 16);
		add(lblStatus);
		
		textStatus = new JTextField();
		textStatus.setBounds(310, 225, 116, 22);
		add(textStatus);
		textStatus.setColumns(10);
		
		JLabel lblIndustrySkills = new JLabel("Industry skills:");
		lblIndustrySkills.setBounds(216, 333, 82, 16);
		add(lblIndustrySkills);
		
		textPS = new JTextArea();
		textPS.setBounds(10, 350, 182, 69);
		add(textPS);
		
		textIS = new JTextArea();
		textIS.setBounds(10, 247, 182, 81);
		add(textIS);
		
		textAddress = new JTextArea();
		textAddress.setBounds(217, 350, 209, 69);
		add(textAddress);
		
		JLabel label = new JLabel("<Image>");
		label.setBounds(31, 69, 161, 159);
		add(label);
		
		JButton btnReader = new JButton("Read");
		btnReader.setBackground(SystemColor.controlHighlight);
		btnReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
				chooser.setFileFilter(filter);
				chooser.showOpenDialog(chooser);
				chooser.setVisible(true);
				if(chooser.getSelectedFile() == null)
					return;
				File file = new File(chooser.getSelectedFile().toString());
				try {
					Scanner scanner = new Scanner(file);
				    String name = scanner.next();
				    String age = scanner.next();
				    String phone = scanner.next();
				    String email = scanner.next();
				    String pos = scanner.next();
				    String status = scanner.next();
				    scanner.close();
				    textName.setText(name);
				    textAge.setText(age);
				    textPhone.setText(phone);
				    textEmail.setText(email);
				    textPosition.setText(pos);
				    textStatus.setText(status);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		btnReader.setBounds(578, 84, 86, 49);
		add(btnReader);
		
		JButton btnAddImage = new JButton("Add Image");
		btnAddImage.setBackground(SystemColor.controlHighlight);
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddImage.setBounds(464, 144, 200, 49);
		add(btnAddImage);
	}
}

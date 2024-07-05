package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.MainFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HRStaffGUI2 extends JPanel{
	private MainFrame main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public HRStaffGUI2(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n = textField_2.getText();
				String ps = textField.getText();
				String is = textField_1.getText();
				main.getController().addProfile(n, ps, is);
			}
		});
		btnAdd.setBounds(34, 264, 73, 25);
		add(btnAdd);
		
		JButton btnLogout = new JButton("Logout");
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
		
		textField = new JTextField();
		textField.setBounds(43, 59, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(43, 101, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("PS");
		lblName.setBounds(10, 62, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("is");
		lblAge.setBounds(10, 104, 46, 14);
		add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(247, 104, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
	}
}

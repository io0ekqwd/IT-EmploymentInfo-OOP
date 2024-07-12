package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class Login extends JPanel{
	private JTextField textField;
	private MainFrame main;
	private JLabel lblLoginStatus;
	private JPasswordField passwordField;
	private JRadioButton rdbtnStaff;
	private JRadioButton rdbtnManager;
	
	public Login(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginScreen.setBounds(151, 11, 136, 31);
		add(lblLoginScreen);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(103, 127, 67, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(103, 163, 67, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(201, 125, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = textField.getText();
				String pwd = String.valueOf(passwordField.getPassword()) ;
				boolean validity = main.getController().verifyUser(n, pwd);
				if (validity == true) {
					String r = main.getController().verifyRole();
					if (r == "Staff"&& rdbtnStaff.isSelected())
						main.showHRStaffGUI();
					else if (r == "Manager" && rdbtnManager.isSelected())
						main.showMMainGUI();
					else if (r == "Admin")
						System.out.println("Admin");//Placeholder
					    
					else
						lblLoginStatus.setText("Invalid Role Selection.");    
				}
				else
					lblLoginStatus.setText("<html>Invalid Username or Password.<br>Please Try Again.<html>");
			}
		});
	
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(198, 217, 89, 23);
		add(btnLogin);
		
		this.lblLoginStatus = new JLabel("");
		this.lblLoginStatus.setBounds(176, 251, 187, 37);
		add(lblLoginStatus);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 162, 86, 18);
		passwordField.setEchoChar('*');
		add(passwordField);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected())
					passwordField.setEchoChar((char)0);
				else 
					passwordField.setEchoChar('*');
			}
		});
		chckbxShowPassword.setBounds(189, 187, 123, 23);
		add(chckbxShowPassword);
		
		this.rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnStaff.isSelected())
					rdbtnManager.setSelected(false);
			}
		});
		this.rdbtnStaff.setBounds(111, 60, 109, 23);
		add(this.rdbtnStaff);
		
		this.rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnManager.isSelected())
					rdbtnStaff.setSelected(false);
			}
		});
		this.rdbtnManager.setBounds(241, 60, 109, 23);
		add(this.rdbtnManager);
		
		this.main.getController().addUser();
	}
}

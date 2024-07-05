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

public class Login extends JPanel{
	private JTextField textField;
	private MainFrame main;
	private JLabel lblLoginStatus;
	private JPasswordField passwordField;
	
	public Login(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginScreen.setBounds(151, 11, 136, 31);
		add(lblLoginScreen);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setBounds(76, 89, 67, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBounds(76, 141, 67, 14);
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(201, 87, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = textField.getText();
				String pwd = String.valueOf(passwordField.getPassword()) ;
				boolean validity = main.getController().verifyUser(n, pwd);
				if (validity == true) {
					String r = main.getController().verifyRole(n,pwd);
					if (r == "Staff")
						main.showHRStaffGUI();
					else if (r == "Manager")
						main.showMMainGUI();
					else if (r == "Admin")
						//Placeholder
						System.out.println("Admin");
					    //Placeholder
					else
					    lblLoginStatus.setText("Invalid Role. Please contact Administrator");
					    
				}
				else
					lblLoginStatus.setText("Invalid Username or Password. Please try again.");
			}
		});
	
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(201, 209, 89, 23);
		add(btnLogin);
		
		this.lblLoginStatus = new JLabel("");
		this.lblLoginStatus.setBounds(103, 259, 337, 14);
		add(lblLoginStatus);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 141, 86, 18);
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
		chckbxShowPassword.setBounds(190, 166, 123, 23);
		add(chckbxShowPassword);
		
		this.main.getController().addUser();
	}
}

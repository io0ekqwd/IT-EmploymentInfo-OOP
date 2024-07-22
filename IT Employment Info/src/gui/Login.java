package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Login extends JPanel{
	private JTextField textField;
	private MainFrame main;
	private JPasswordField passwordField;
	private JRadioButton rdbtnStaff;
	private JRadioButton rdbtnManager;
	private ImageIcon img;
	
	public Login(MainFrame main) {
		setBackground(Color.LIGHT_GRAY);
		this.main = main;
		setLayout(null);
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setBounds(160, 22, 136, 31);
		lblLoginScreen.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblLoginScreen);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(103, 127, 67, 14);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(103, 163, 67, 14);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(201, 125, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(201, 217, 89, 23);
		
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
						JOptionPane.showMessageDialog(main, "Invalid Role Selection. Please try again.");   
				}
				else
					JOptionPane.showMessageDialog(main, "Invalid Username and Password. Please try again.");
			}
		});
	
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 162, 86, 18);
		passwordField.setEchoChar('*');
		add(passwordField);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setBackground(Color.WHITE);
		chckbxShowPassword.setBounds(189, 187, 123, 23);
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected())
					passwordField.setEchoChar((char)0);
				else 
					passwordField.setEchoChar('*');
			}
		});
		chckbxShowPassword.setOpaque(false);
		add(chckbxShowPassword);
		
		this.rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setBackground(Color.WHITE);
		rdbtnStaff.setBounds(100, 70, 109, 23);
		rdbtnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnStaff.isSelected())
					rdbtnManager.setSelected(false);
			}
		});
		this.rdbtnStaff.setOpaque(false);
		add(this.rdbtnStaff);
		
		this.rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setBackground(Color.WHITE);
		rdbtnManager.setBounds(272, 70, 109, 23);
		rdbtnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnManager.isSelected())
					rdbtnStaff.setSelected(false);
			}
		});
		this.rdbtnManager.setOpaque(false);
		add(this.rdbtnManager);
		
		this.img = new ImageIcon("images/Gradient.png");
		JLabel lblNewLabel = new JLabel(this.img);
		lblNewLabel.setBounds(-34, -86, 520, 589);
		add(lblNewLabel);
		
		this.main.getController().addUser();
	}
}

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
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Panel;

public class Login extends JPanel{
	private JTextField textField;
	private MainFrame main;
	private JPasswordField passwordField;
	private JRadioButton rdbtnStaff;
	private JRadioButton rdbtnManager;
	private ImageIcon img, img2, img3;
	
	public Login(MainFrame main) {
		setForeground(SystemColor.desktop);
		setBackground(SystemColor.textHighlight);
		this.main = main;
		this.setSize(700,500);
		setLayout(null);
		
		/*this.rdbtnStaff = new JRadioButton("Staff");
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
		add(this.rdbtnManager);*/
		
		this.img = new ImageIcon("images/gradient3.jpg");
		this.img2 = new ImageIcon("images/user.png");
		this.img3 = new ImageIcon("images/lock.png");
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 255, 255, 255));
		panel.setBounds(141, 37, 402, 382);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(103, 89, 58, 16);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(103, 159, 55, 16);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLoginScreen = new JLabel("Login");
		lblLoginScreen.setBounds(172, 32, 55, 25);
		panel.add(lblLoginScreen);
		lblLoginScreen.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.setFont(new Font("Open Sans", Font.PLAIN, 11));
		chckbxShowPassword.setBounds(142, 225, 159, 23);
		panel.add(chckbxShowPassword);
		chckbxShowPassword.setBackground(Color.WHITE);
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxShowPassword.isSelected())
					passwordField.setEchoChar((char)0);
				else 
					passwordField.setEchoChar('*');
			}
		});
		chckbxShowPassword.setOpaque(false);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(142, 256, 110, 32);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBackground(SystemColor.control);
		panel.add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = textField.getText();
				String pwd = String.valueOf(passwordField.getPassword()) ;
				boolean validity = main.getController().verifyUser(n, pwd);
				if (validity == true) {
					String r = main.getController().getRole();
					if (r == "Staff")
						main.showHRStaffMainPage();
					else if (r == "Manager")
						main.showMMainGUI();
					else if (r == "Admin")
						System.out.println("Admin");//Placeholder
				}
				else
					JOptionPane.showMessageDialog(main, "Invalid Username and Password. Please try again.");
			}
		});
		
			btnLogin.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setBounds(103, 116, 209, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 186, 209, 32);
		panel.add(passwordField);
		passwordField.setEchoChar('*');
		
		JLabel lblNewLabel_1 = new JLabel(this.img2);
		lblNewLabel_1.setBounds(41, 116, 46, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(this.img3);
		lblNewLabel_2.setBounds(41, 186, 46, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel(this.img);
		lblNewLabel.setBounds(-14, -35, 797, 631);
		add(lblNewLabel);
		
		this.main.getController().addUser();
	}
}

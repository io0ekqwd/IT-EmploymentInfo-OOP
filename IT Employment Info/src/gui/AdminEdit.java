package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.MainFrame;
import data.User;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class AdminEdit {
	JFrame frame = new JFrame();
	private JTextField textUser;
	private JTextField textPwd;
	private JComboBox cbRole;
	private String[] role = {"Staff", "Manager"};
	private MainFrame main;
	private User user;
	private int index;
	
	public AdminEdit(MainFrame main, int index, User user){
		this.main = main;
		this.index = index;
		this.user = user;
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setSize(450,300);
		frame.setTitle("Add User");
		frame.setLocationRelativeTo(main);
		
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(132, 60, 73, 24);
		frame.getContentPane().add(lblUsername);
		
		textUser = new JTextField();
		textUser.setBounds(200, 62, 86, 20);
		frame.getContentPane().add(textUser);
		textUser.setColumns(10);
		textUser.setText(user.getUsername());
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(134, 91, 71, 25);
		frame.getContentPane().add(lblPassword);
		
		textPwd = new JTextField();
		textPwd.setBounds(200, 93, 86, 20);
		frame.getContentPane().add(textPwd);
		textPwd.setColumns(10);
		textPwd.setText(user.getPassword());
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setBounds(160, 127, 46, 14);
		frame.getContentPane().add(lblRole);
		
		this.cbRole = new JComboBox(role);
		cbRole.setBounds(200, 124, 86, 20);
		frame.getContentPane().add(cbRole);
		cbRole.setSelectedItem(user.getRole());
		
		JButton btnAdd = new JButton("Edit");
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textUser.getText();
				String pwd = textPwd.getText();
				String role = String.valueOf(cbRole.getSelectedItem());
				main.getController().editUser(index, user, username, pwd, role);
				main.getController().writeFile();
				frame.dispose();
				main.showAdminPage();
			}
		});
		btnAdd.setBounds(101, 164, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnBack.setBounds(237, 164, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblAddUser = new JLabel("Edit User");
		lblAddUser.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddUser.setBounds(186, 11, 86, 24);
		frame.getContentPane().add(lblAddUser);
		
	}
}

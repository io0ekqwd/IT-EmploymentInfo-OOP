package gui;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainFrame;
import data.ApplicantDetails;
import data.User;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Panel;
import java.awt.Color;


public class AdminEdit extends JPanel {
	private JTextField textUser;
	private JTextField textPwd;
	private JComboBox cbRole;
	private String[] role = {"Staff", "Manager"};
	private MainFrame main;
	private int index;
	private User user;
	
	public AdminEdit(MainFrame main, int index, User user){
		this.main = main;
		this.user = user;
	    this.index = index;
		setLayout(null);
			
			JLabel lblAddUser = new JLabel("Edit User");
			lblAddUser.setBounds(301, 45, 121, 48);
			add(lblAddUser);
			lblAddUser.setFont(new Font("Tahoma", Font.BOLD, 18));
			
				JLabel lblUsername = new JLabel("Username:");
				lblUsername.setBounds(229, 143, 76, 30);
				add(lblUsername);
				lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				textUser = new JTextField();
				textUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textUser.setBounds(315, 144, 121, 30);
				add(textUser);
				textUser.setBackground(Color.WHITE);
				textUser.setColumns(10);
				textUser.setText(user.getUsername());
				
				textPwd = new JTextField();
				textPwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textPwd.setBounds(315, 195, 121, 30);
				add(textPwd);
				textPwd.setColumns(10);
				textPwd.setText(user.getPassword());
				
				JLabel lblPassword = new JLabel("Password:");
				lblPassword.setBounds(229, 194, 76, 30);
				add(lblPassword);
				lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JButton btnEdit = new JButton("Edit");
				btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnEdit.setBounds(179, 321, 81, 37);
				add(btnEdit);
				btnEdit.setBackground(SystemColor.controlHighlight);
				
				this.cbRole = new JComboBox(this.role);
				cbRole.setBackground(Color.WHITE);
				cbRole.setFont(new Font("Tahoma", Font.PLAIN, 15));
				cbRole.setBounds(313, 250, 86, 30);
				add(cbRole);
				cbRole.setSelectedItem(user.getRole());
				
				JLabel lblRole = new JLabel("Role:");
				lblRole.setBounds(255, 250, 49, 30);
				add(lblRole);
				lblRole.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
				JButton btnBack = new JButton("Back");
				btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnBack.setBounds(425, 321, 81, 37);
				add(btnBack);
				btnBack.setBackground(SystemColor.controlHighlight);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						main.showAdminPage();
					}
				});
				btnEdit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String username = textUser.getText();
						String pwd = textPwd.getText();
						String role = String.valueOf(cbRole.getSelectedItem());
						//Loops through array to check status of each textfield
						JTextField[] textFields = {textUser, textPwd};
						boolean emptyStatus = false;
						for(int i=0;i<textFields.length;i++){
							JTextField textField = textFields[i];
							if(textField.getText().isEmpty()){
								emptyStatus = true;
								break;
							}
						}
						//Blocks saving of incomplete details
						if(emptyStatus!=true){
						main.getController().editUser(index, user, username, pwd, role);
						main.getController().writeFile();
						main.showAdminPage();
					}
						else
							JOptionPane.showMessageDialog(main, "Please fill in all user details.");
					}
					
				});
		
	}
}

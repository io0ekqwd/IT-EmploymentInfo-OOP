package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminPage extends JPanel{
	private JTable table;
	private DefaultTableModel model;
	private MainFrame main;
	private User[] users;
	private int index;

	
	public AdminPage(MainFrame main){
		setLayout(null);
		this.main = main;
		
		this.model = new DefaultTableModel();
		model.addColumn("Username");
		model.addColumn("Role");
		
		JLabel lblAdminPage = new JLabel("Admin Page");
		lblAdminPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminPage.setBounds(293, 24, 123, 26);
		add(lblAdminPage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 75, 507, 226);
		add(scrollPane);
		
		this.table = new JTable(model);
		scrollPane.setViewportView(table);
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.setBackground(SystemColor.controlHighlight);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showAdminAdd();
			}
		});
		btnAddUser.setBounds(122, 366, 109, 35);
		add(btnAddUser);
		
		//Delete User
		JButton btnDeleteUser = new JButton("Delete");
		btnDeleteUser.setBackground(SystemColor.controlHighlight);
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = table.getSelectedRow();//Get the row index
				if(index == -1)
					return;
				model.removeRow(index);//Remove row from table
				User u = users[index];//Find user in array
				main.getController().deleteUser(index, u);//Delete User
				main.getController().writeFile();//Write changes to json
			}
		});
		btnDeleteUser.setBounds(456, 366, 109, 35);
		add(btnDeleteUser);
		
		//Edit user
		JButton btnEdit = new JButton("Manage");
		btnEdit.setBackground(SystemColor.controlHighlight);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = table.getSelectedRow();
				if(index == -1)
					return;
				User u = users[index];
				main.showAdminEdit(index, u);
			}
		});
		btnEdit.setBounds(287, 366, 109, 35);
		add(btnEdit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(SystemColor.controlHighlight);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
	                if (opt == 0) {
	                    main.showLogin();
	                } else {
	                    return;
	                }
			}
		});
		btnLogout.setBounds(583, 19, 89, 40);
		add(btnLogout);
		
		this.populateUserList();
	}
	
	//Populate list with user profiles
	public void populateUserList(){
		this.users = main.getController().getUserList();
		for(int i=0;i<users.length;i++){
			User op = users[i];
			model.addRow(new Object[]{op.getUsername(), op.getRole()});
		}
		this.table.setModel(model);
	}
}

package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.ApplicantDetails;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HRStaffGUI extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	public HRStaffGUI(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 54, 450, 189);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(this.appList);
		
		JLabel lblApplicantPage = new JLabel("Applicant Page");
		lblApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApplicantPage.setBounds(173, 11, 93, 14);
		add(lblApplicantPage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLogin();
			}
		});
		btnLogout.setBounds(334, 8, 89, 23);
		add(btnLogout);
		
		JButton btnViewlist = new JButton("List");
		btnViewlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnViewlist.setBounds(279, 266, 125, 23);
		add(btnViewlist);
		
		JButton btnAddApplicant = new JButton("Add");
		btnAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffGUI2();
			}
		});
		btnAddApplicant.setBounds(10, 266, 76, 23);
		add(btnAddApplicant);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(91, 266, 76, 23);
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(177, 266, 76, 23);
		add(btnDelete);
		
		this.populateAppDList();
	}
	//Test
	private void populateAppDList() {
		this.AppD = this.main.getController().getAppList();
		DefaultListModel model = new DefaultListModel();
		for (int i=0; i<AppD.length;i++)
		{
			ApplicantDetails det = AppD[i];
			model.addElement(det.getName());
			/*model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());*/
		}
		this.appList.setModel(model);
	} 
}

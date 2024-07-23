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
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HRStaffMain extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	private String p = "p1";
	public HRStaffMain(MainFrame main) {
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
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?","Logout", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.showLogin();
				}
				else
					return;
			}
		});
		btnLogout.setBounds(334, 8, 89, 23);
		add(btnLogout);
		
		JButton btnAddApplicant = new JButton("Add Applicant\r\n");
		btnAddApplicant.setBackground(Color.LIGHT_GRAY);
		btnAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffGUI2();
			}
		});
		btnAddApplicant.setBounds(0, 266, 155, 25);
		add(btnAddApplicant);
		
		JButton btnUpdateApplicant = new JButton("Update Applicant");
		btnUpdateApplicant.setBackground(Color.LIGHT_GRAY);
		btnUpdateApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails det = AppD[index];
				main.showHRStaffGUI3(index, det);
			}
		});
		btnUpdateApplicant.setBounds(285, 266, 155, 25);
		add(btnUpdateApplicant);
		
		JButton btnDeleteApplicant = new JButton("Delete Applicant");
		btnDeleteApplicant.setBackground(Color.LIGHT_GRAY);
		btnDeleteApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure to delete?","Delete", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().deleteProf(index);
					populateAppDList();
				}
				else
					return;
			}
		});
		btnDeleteApplicant.setBounds(144, 302, 155, 25);
		add(btnDeleteApplicant);
		
		this.populateAppDList();
	}
	//Test
	private void populateAppDList() {
		main.getController().addID(p);
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

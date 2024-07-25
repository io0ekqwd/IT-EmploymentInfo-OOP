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
import java.awt.SystemColor;

public class HRStaffApplicantPage extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	private String p = "p1";
	public HRStaffApplicantPage(MainFrame main) {
		this.main = main;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 72, 450, 189);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(appList);
		
		JLabel lblApplicantPage = new JLabel("Applicant Page");
		lblApplicantPage.setBounds(305, 29, 93, 14);
		lblApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblApplicantPage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(569, 13, 102, 46);
		btnLogout.setBackground(SystemColor.controlHighlight);
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
		add(btnLogout);
		
		JButton btnAddApplicant = new JButton("Add Applicant\r\n");
		btnAddApplicant.setBounds(129, 274, 155, 42);
		btnAddApplicant.setBackground(SystemColor.controlHighlight);
		btnAddApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffAdd();
			}
		});
		add(btnAddApplicant);
		
		JButton btnUpdateApplicant = new JButton("Update Applicant");
		btnUpdateApplicant.setBounds(424, 274, 155, 42);
		btnUpdateApplicant.setBackground(SystemColor.controlHighlight);
		btnUpdateApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails det = AppD[index];
				main.showHRStaffUpdate(index, det);
			}
		});
		add(btnUpdateApplicant);
		
		JButton btnDeleteApplicant = new JButton("Delete Applicant");
		btnDeleteApplicant.setBounds(282, 329, 155, 42);
		btnDeleteApplicant.setBackground(SystemColor.controlHighlight);
		btnDeleteApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to delete?","Delete", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().deleteProf(index);
					populateAppDList();
				}
				else
					return;
			}
		});
		add(btnDeleteApplicant);
		
		JButton btnBackButton = new JButton("Back");
		btnBackButton.setBounds(32, 13, 102, 46);
		btnBackButton.setBackground(SystemColor.controlHighlight);
		btnBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showHRStaffMainPage();
			}
		});
		add(btnBackButton);
		
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

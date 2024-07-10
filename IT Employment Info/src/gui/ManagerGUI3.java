package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.ApplicantDetails;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class ManagerGUI3 extends JPanel{
	private ApplicantDetails AppD[];
	private MainFrame main;
	private JList appList;
	
	public ManagerGUI3(MainFrame main) {
		setLayout(null);
		this.main = main;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 54, 450, 189);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(this.appList);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLogin();
			}
		});
		btnLogout.setBounds(330, 8, 89, 23);
		add(btnLogout);
		
		JLabel lblJobOfferPage = new JLabel("Job Offer Page");
		lblJobOfferPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJobOfferPage.setBounds(177, 11, 99, 14);
		add(lblJobOfferPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMMainGUI();
			}
		});
		btnBack.setBounds(36, 8, 89, 23);
		add(btnBack);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = appList.getSelectedIndex();
				if (index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.showDetailPage(index, app);
			}
		});
		btnViewProfile.setBounds(10, 344, 140, 23);
		add(btnViewProfile);
		
		JButton btnCountApplicants = new JButton("Count Applicants");
		btnCountApplicants.setBounds(280, 344, 160, 23);
		add(btnCountApplicants);
		this.populateAppDList();
	}
	//Test
	private void populateAppDList() {
		this.AppD = this.main.getController().getJobList();
		DefaultListModel model = new DefaultListModel();
		for (int i=0; i<AppD.length;i++)
		{
			ApplicantDetails op = AppD[i];
			model.addElement(op.getName());
			//model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());
		}
		this.appList.setModel(model);
	} 
	//Test
	public void showMMainGUI() {
		this.main.showMMainGUI();
	}
}

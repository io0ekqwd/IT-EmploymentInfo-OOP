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

public class ManagerGUI extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	private String p="";
	
	public ManagerGUI(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.setSize(450, 400);
		
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
		
		JButton btnShortlist = new JButton("Shortlist");
		btnShortlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				main.getController().shortlistApp(index);
				populateAppDList();
			}
		});
		btnShortlist.setBounds(279, 328, 125, 23);
		add(btnShortlist);
		/*
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.getController().addName();
				populateAppDList();
			}
		});
		btnTest.setBounds(177, 33, 89, 23);
		add(btnTest);
		*/
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMMainGUI();
			}
		});
		btnBack.setBounds(29, 8, 89, 23);
		add(btnBack);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = "p1";
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.showDetailPage(index, app);
			}
		});
		btnViewProfile.setBounds(29, 328, 125, 23);
		add(btnViewProfile);
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				p = "p1";
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.getController().deleteProf(index);
				populateAppDList();
				
			}
		});
		button.setBounds(29, 294, 126, 23);
		add(button);
		
		this.populateAppDList();
	}
	
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
	
	public void showMMainGUI() {
		this.main.showMMainGUI();
	}
}

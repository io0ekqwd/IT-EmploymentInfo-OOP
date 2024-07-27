package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

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

public class ManagerApplicant extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	private String p="p1";
	
	public ManagerApplicant(MainFrame main) {
		setLayout(null);
		this.main = main;
		main.setSize(700, 500);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 54, 668, 217);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(this.appList);
		
		JLabel lblApplicantPage = new JLabel("Applicant Page");
		lblApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApplicantPage.setBounds(293, 10, 125, 26);
		add(lblApplicantPage);
		
		JButton btnLogout = new JButton("Logout");
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
		btnLogout.setBounds(571, 8, 107, 35);
		add(btnLogout);
		
		JButton btnShortlist = new JButton("Shortlist");
		btnShortlist.setBackground(SystemColor.controlHighlight);
		btnShortlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to shortlist?","Shortlist", JOptionPane.YES_NO_OPTION);
				if(opt == 0)
				{
					ApplicantDetails det = AppD[index];
					main.getController().shortlistApp(index, det);
					populateAppDList();
				}
				else
					return;
			}
		});
		btnShortlist.setBounds(474, 299, 140, 50);
		add(btnShortlist);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMMainGUI();
			}
		});
		btnBack.setBounds(10, 8, 107, 35);
		add(btnBack);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.showDetailPage(index, app);
			}
		});
		btnViewProfile.setBounds(276, 373, 135, 50);
		add(btnViewProfile);
		
		JButton button = new JButton("Delete");
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		button.setBounds(85, 299, 135, 50);
		add(button);
		
		this.populateAppDList();
	}
	
	private void populateAppDList() {
		//main.getController().addID(p);
		this.AppD = this.main.getController().getAppList();
		DefaultListModel model = new DefaultListModel();
		for (int i=0; i<AppD.length;i++)
		{
			ApplicantDetails det = AppD[i];
			if (det.getShortlist() == false && det.getJob() == false)
				model.addElement(det.getName());
			/*model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());*/
		}
		this.appList.setModel(model);
	} 
	
	public void showMMainGUI() {
		this.main.showMMainGUI();
	}
}

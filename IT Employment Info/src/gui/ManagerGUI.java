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
		
		JButton btnShortlist = new JButton("Shortlist");
		btnShortlist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to shortlist?","Shortlist", JOptionPane.YES_NO_OPTION);
				if(opt == 0)
				{
					main.getController().shortlistApp(index);
					populateAppDList();
				}
				else
					return;
			}
		});
		btnShortlist.setBounds(279, 328, 125, 23);
		add(btnShortlist);
		
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

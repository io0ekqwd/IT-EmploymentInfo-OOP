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
import javax.swing.JTable;

public class ManagerGUI2 extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	public ManagerGUI2(MainFrame main) {
		setLayout(null);
		this.main = main;
		//test
		
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
		btnLogout.setBounds(337, 8, 89, 23);
		add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMMainGUI();
			}
		});
		
		btnBack.setBounds(22, 8, 89, 23);
		add(btnBack);
		
		JLabel lblShortlistPage = new JLabel("Shortlist Page");
		lblShortlistPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShortlistPage.setBounds(177, 11, 89, 14);
		add(lblShortlistPage);
		
		JButton btnGiveOffer = new JButton("Give Offer");
		btnGiveOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				main.getController().giveJob(index);
				populateSAppDList();
			}
		});
		btnGiveOffer.setBounds(312, 266, 138, 23);
		add(btnGiveOffer);
		
		JButton btnScheduleInterview = new JButton("Schedule Interview");
		btnScheduleInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnScheduleInterview.setBounds(136, 266, 166, 23);
		add(btnScheduleInterview);
		
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
		btnViewProfile.setBounds(0, 266, 126, 23);
		add(btnViewProfile);
		this.populateSAppDList();
	}
	//Test
	private void populateSAppDList() {
		this.AppD = this.main.getController().getSAppList();
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

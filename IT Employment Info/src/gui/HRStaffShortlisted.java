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
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffShortlisted extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnScheduleInterview;
	private String p = "p2";

	public HRStaffShortlisted(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.setSize(700, 500);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 76, 450, 189);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(appList);
		appList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					int index = appList.getSelectedIndex();
					if (index == -1) 
						return;
					ApplicantDetails app = AppD[index];
					if(app.getInterviewDetails()!=null)
					{
						btnScheduleInterview.setText("Reschedule Interview");
						lblNewLabel.setText(app.getInterviewDetails().getDay()+" "+app.getInterviewDetails().getMonth()+" "+app.getInterviewDetails().getYear());
					    lblNewLabel_1.setText(app.getInterviewDetails().getVenue());
					}
					else 
					{
						btnScheduleInterview.setText("Schedule Interview");
						lblNewLabel.setText("(Please schedule date)");
						lblNewLabel_1.setText("(Please schedule venue)");
					}
				}
			}
		});
		
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
		btnLogout.setBounds(569, 13, 102, 46);
		add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffMainPage();
			}
		});
		
		btnBack.setBounds(32, 13, 102, 46);
		add(btnBack);
		
		JLabel lblShortlistPage = new JLabel("Shortlist Page");
		lblShortlistPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShortlistPage.setBounds(305, 29, 93, 14);
		add(lblShortlistPage);
		
		this.btnScheduleInterview = new JButton("Schedule Interview");
		btnScheduleInterview.setBackground(SystemColor.controlHighlight);
		btnScheduleInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = appList.getSelectedIndex();
				ApplicantDetails det = AppD[index];
				main.showSchedulePage(index, det);
			}
		});
		this.btnScheduleInterview.setBounds(254, 357, 192, 46);
		add(this.btnScheduleInterview);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				int index = appList.getSelectedIndex();
				if (index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.showDetailPage(index, app);
			}
		});
		btnViewProfile.setBounds(85, 362, 146, 37);
		add(btnViewProfile);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(130, 287, 46, 14);
		add(lblDate);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setBounds(130, 328, 46, 14);
		add(lblVenue);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(178, 315, 173, 37);
		add(lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(168, 278, 192, 37);
		add(lblNewLabel_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(SystemColor.controlHighlight);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to delete?","Delete", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().deleteProf(index);
					btnScheduleInterview.setText("Schedule Interview");
					lblNewLabel.setText("(Please schedule date)");
					lblNewLabel_1.setText("(Please schedule venue)");
					populateSAppDList();
				}
				else
					return;
			}
		});
		btnDelete.setBounds(477, 362, 146, 37);
		add(btnDelete);
		this.populateSAppDList();
	}
	//Test
	private void populateSAppDList() {
		main.getController().addID(p);
		this.AppD = this.main.getController().getAppList();
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

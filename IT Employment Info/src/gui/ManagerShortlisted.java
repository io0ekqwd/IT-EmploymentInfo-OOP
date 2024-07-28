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

public class ManagerShortlisted extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private int index;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnScheduleInterview;
	private String p = "p2";
	private JLabel lblNewLabel_2;

	public ManagerShortlisted(MainFrame main) {
		setLayout(null);
		this.main = main;
		main.setSize(700,500);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 53, 654, 189);
		add(scrollPane);
		
		this.appList = new JList();
		appList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					index = appList.getSelectedIndex();
					if (index == -1) 
						return;
					ApplicantDetails app = AppD[index];
					if(app.getInterviewDetails()!=null)
					{
						btnScheduleInterview.setText("Reschedule Interview");
						lblNewLabel.setText(app.getInterviewDetails().getDay()+" "+app.getInterviewDetails().getMonth()+" "+app.getInterviewDetails().getYear());
					    lblNewLabel_1.setText(app.getInterviewDetails().getVenue());
					    lblNewLabel_2.setText(String.valueOf(app.getInterviewDetails().getHour())+":"+String.valueOf(app.getInterviewDetails().getMin()));
					}
					else 
					{
						btnScheduleInterview.setText("Schedule Interview");
						lblNewLabel.setText("(Please schedule date)");
						lblNewLabel_1.setText("(Please schedule venue)");
						lblNewLabel_2.setText("(Please schedule date)");
					}
				}
			}
		});
		scrollPane.setViewportView(appList);
		
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
		btnLogout.setBounds(585, 8, 89, 34);
		add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMMainGUI();
			}
		});
		
		btnBack.setBounds(22, 8, 126, 34);
		add(btnBack);
		
		JLabel lblShortlistPage = new JLabel("Shortlist Page");
		lblShortlistPage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblShortlistPage.setBounds(286, 11, 120, 25);
		add(lblShortlistPage);
		
		JButton btnGiveOffer = new JButton("Give Offer");
		btnGiveOffer.setBackground(SystemColor.controlHighlight);
		btnGiveOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to give offer?","Job Offer", JOptionPane.YES_NO_OPTION);
				if(opt == 0)
				{
					ApplicantDetails det = AppD[index];
					main.getController().giveJob(det);
					btnScheduleInterview.setText("Schedule Interview");
					lblNewLabel.setText("(Please schedule date)");
					lblNewLabel_1.setText("(Please schedule venue)");
					lblNewLabel_2.setText("(Please schedule date)");
					main.showJobGUI();
				}
				else
					return;
			}
		});
		btnGiveOffer.setBounds(476, 384, 203, 62);
		add(btnGiveOffer);
		
		this.btnScheduleInterview = new JButton("Schedule Interview");
		btnScheduleInterview.setBackground(SystemColor.controlHighlight);
		btnScheduleInterview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				int pIndex = appList.getSelectedIndex();
				if (pIndex == -1)
					return;
				ApplicantDetails app = AppD[pIndex];
				index = main.getController().getProfIndex(app);
				main.showSchedulePage(index, app);
			}
		});
		this.btnScheduleInterview.setBounds(508, 253, 166, 23);
		add(this.btnScheduleInterview);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				int pIndex = appList.getSelectedIndex();
				if (pIndex == -1)
					return;
				ApplicantDetails app = AppD[pIndex];
				index = main.getController().getProfIndex(app);
				main.showDetailPage(index, app); 
			}
		});
		btnViewProfile.setBounds(10, 384, 191, 62);
		add(btnViewProfile);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(207, 253, 52, 23);
		add(lblDate);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVenue.setBounds(207, 287, 46, 23);
		add(lblVenue);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(269, 253, 199, 23);
		add(lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(273, 287, 195, 23);
		add(lblNewLabel_1);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBackground(SystemColor.controlHighlight);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails det = AppD[index];
				int opt = JOptionPane.showConfirmDialog(main, "Do you want to undo?","Undo", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().undoShort(det);
					btnScheduleInterview.setText("Schedule Interview");
					lblNewLabel.setText("(Please schedule date)");
					lblNewLabel_1.setText("(Please schedule venue)");
					lblNewLabel_2.setText("(Please schedule date)");
					populateSAppDList();
				}
				else
					return;
				
			}
		});
		btnUndo.setBounds(226, 384, 228, 62);
		add(btnUndo);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTime.setBounds(207, 322, 46, 23);
		add(lblTime);
		
		this.lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(273, 321, 195, 24);
		add(lblNewLabel_2);
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

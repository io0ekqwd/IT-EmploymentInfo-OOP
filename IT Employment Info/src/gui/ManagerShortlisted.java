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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ManagerShortlisted extends JPanel{
	private ApplicantDetails[] AppD;
	private MainFrame main;
	private JList appList;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private String p = "p2";
	private JLabel lblNewLabel_2;
	private int index;
	private JTextField searchBox;
	private DefaultListModel model;
	private ApplicantDetails[] AppDFiltered;

	public ManagerShortlisted(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.model = new DefaultListModel();
		main.setSize(700,500);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 53, 439, 189);
		add(scrollPane);
		
		this.appList = new JList();
		appList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()){
					index = appList.getSelectedIndex();
					if (index == -1) 
						return;
					ApplicantDetails app = AppDFiltered[index];
					if(app.getInterviewDetails()!=null)
					{
						lblNewLabel.setText(app.getInterviewDetails().getDay()+" "+app.getInterviewDetails().getMonth()+" "+app.getInterviewDetails().getYear());
					    lblNewLabel_1.setText(app.getInterviewDetails().getVenue());
					    lblNewLabel_2.setText(String.valueOf(app.getInterviewDetails().getHour())+":"+String.valueOf(app.getInterviewDetails().getMin()));
					}
					else 
					{
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
		btnLogout.setBounds(569, 8, 110, 34);
		add(btnLogout);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showMMainGUI();
			}
		});
		
		btnBack.setBounds(22, 8, 110, 34);
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
					ApplicantDetails det = AppDFiltered[index];
					main.getController().giveJob(det);
					main.getController().writeFile(); // Write applicant profile to json file
					main.showJobGUI();
				}
				else
					return;
			}
		});
		btnGiveOffer.setBounds(476, 384, 203, 62);
		add(btnGiveOffer);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				int pIndex = appList.getSelectedIndex();
				if (pIndex == -1)
					return;
				ApplicantDetails app = AppDFiltered[pIndex];
				index = main.getController().getProfIndex(app);
				main.showDetailPage(index, app); 
			}
		});
		btnViewProfile.setBounds(10, 384, 191, 62);
		add(btnViewProfile);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(207, 282, 52, 23);
		add(lblDate);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVenue.setBounds(207, 316, 46, 23);
		add(lblVenue);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(269, 282, 199, 23);
		add(lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(273, 316, 195, 23);
		add(lblNewLabel_1);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBackground(SystemColor.controlHighlight);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails det = AppDFiltered[index];
				int opt = JOptionPane.showConfirmDialog(main, "Do you want to undo?","Undo", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().undoShort(det);
					main.getController().writeFile(); // Write applicant profile to json file
					lblNewLabel.setText("");
					lblNewLabel_1.setText("");
					lblNewLabel_2.setText("");
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
		lblTime.setBounds(207, 350, 46, 23);
		add(lblTime);
		
		this.lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(273, 349, 195, 24);
		add(lblNewLabel_2);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch.setBounds(226, 253, 46, 14);
		add(lblSearch);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchFilter();
				if(searchBox.getText().isEmpty()){
					lblNewLabel.setText("");
					lblNewLabel_1.setText("");
					lblNewLabel_2.setText("");
				}
			}
		});
		searchBox.setBounds(286, 251, 148, 20);
		add(searchBox);
		searchBox.setColumns(10);
		this.populateSAppDList();
	}
	
	private void populateSAppDList() {
		this.AppD = this.main.getController().getSAppList();
		this.AppDFiltered = this.AppD;
		model.clear();
		for (int i=0; i<AppDFiltered.length;i++)
		{
			ApplicantDetails op = AppDFiltered[i];
			model.addElement(op.getName());
			//model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());
		}
		this.appList.setModel(model);
	}
	
	private void searchFilter() {
		String search = searchBox.getText();
		lblNewLabel.setText("");
		lblNewLabel_1.setText("");
		lblNewLabel_2.setText("");
		DefaultListModel filter = new DefaultListModel();
		ArrayList<ApplicantDetails> items =  new ArrayList<ApplicantDetails>();
		ArrayList<ApplicantDetails> filteredItems =  new ArrayList<ApplicantDetails>();
		for(int i=0;i<AppD.length;i++)
			items.add(AppD[i]);
		for(int i=0;i<items.size();i++){
			ApplicantDetails op = items.get(i);
			String listItem = "";
			listItem = op.getName();
			if(listItem.toLowerCase().contains(search.toLowerCase())){
				filter.addElement(listItem);
				filteredItems.add(op);
			}
			AppDFiltered = filteredItems.toArray(new ApplicantDetails[filteredItems.size()]);
			this.appList.setModel(filter);
		}
	}
}

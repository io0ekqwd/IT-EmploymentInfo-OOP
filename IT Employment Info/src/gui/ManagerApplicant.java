package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ManagerApplicant extends JPanel{
	private ApplicantDetails[] AppD;//Array to hold object from vector
	private MainFrame main; //Reference to MainFrame
	private JList appList;
	private int index;
	private String p="p1";//Page identifier
	private ApplicantDetails[] AppDFiltered;//Array to 
	private JTextField searchBox;
	private DefaultListModel model;
	
	//Initialise panel
	public ManagerApplicant(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.model = new DefaultListModel();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 54, 463, 217);
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
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?","Logout", JOptionPane.YES_NO_OPTION);//Confirm whether to logout
				if(opt==0)
				{
					main.showLogin();//Go back to login page
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
				index = appList.getSelectedIndex();//Get index of applicant within list
				if (index == -1)
					return; //Blocks null selection
				ApplicantDetails det = AppDFiltered[index];//Find profile from filtered AppD
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to shortlist?","Shortlist", JOptionPane.YES_NO_OPTION); //Confirm whether to shortlist or not
				if(opt == 0)
				{
					main.getController().shortlistApp(det);//Shortlist applicant
					 main.getController().writeFile(); // Write applicant profile to json file
					populateAppDList();//Refresh applicant list
				}
				else
					return;
			}
		});
		btnShortlist.setBounds(459, 325, 140, 50);
		add(btnShortlist);
		
		//Button to return to main menu
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showMMainGUI();
			}
		});
		btnBack.setBounds(10, 8, 107, 35);
		add(btnBack);
		
		//Button to view profile of selected applicant
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);//Add page identifier to datastorage
				int pIndex = appList.getSelectedIndex();
				if (pIndex == -1)
					return;
				ApplicantDetails app = AppDFiltered[pIndex];
				index = main.getController().getProfIndex(app);
				main.showDetailPage(index, app);
			}
		});
		btnViewProfile.setBounds(270, 325, 140, 50);
		add(btnViewProfile);
		
		//Button to delete applicants who failed shortlist
		JButton button = new JButton("Delete");
		button.setBackground(SystemColor.controlHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails det = AppDFiltered[index];
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to delete?","Delete", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().deleteProf(det);
				    main.getController().writeFile(); // Write applicant profile to json file
					populateAppDList();
				}
				else
					return;
			}
		});
		button.setBounds(81, 325, 140, 50);
		add(button);
		
		//Search bar 
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch.setBounds(214, 282, 46, 20);
		add(lblSearch);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchFilter();
			}
		});
		searchBox.setBounds(270, 282, 148, 20);
		add(searchBox);
		searchBox.setColumns(10);
		//Call method to fill JList
		this.populateAppDList();
	}
	
	//Populate JList with applicant profiles
	private void populateAppDList() {
		this.AppD = this.main.getController().getMAppList();
		model.clear();
		this.AppDFiltered = this.AppD;
		for (int i=0; i<AppDFiltered.length;i++)
		{
			ApplicantDetails det = AppDFiltered[i];
		    model.addElement(det.getName() + "          " + det.getAPosition());
		}
		this.appList.setModel(model);
	} 
	//Method to filter JList
	private void searchFilter() {
		String search = searchBox.getText();
		DefaultListModel filter = new DefaultListModel();
		ArrayList<ApplicantDetails> items =  new ArrayList<ApplicantDetails>();
		ArrayList<ApplicantDetails> filteredItems =  new ArrayList<ApplicantDetails>();
		for(int i=0;i<AppD.length;i++)
			items.add(AppD[i]);
		for(int i=0;i<items.size();i++){
			ApplicantDetails op = items.get(i);
			String listItem = "";
			listItem = op.getName() +"          "+op.getAPosition();
			if(listItem.toLowerCase().contains(search.toLowerCase())){
				filter.addElement(listItem);
				filteredItems.add(op);
			}
			AppDFiltered = filteredItems.toArray(new ApplicantDetails[filteredItems.size()]);
			this.appList.setModel(filter);
		}
	}
}

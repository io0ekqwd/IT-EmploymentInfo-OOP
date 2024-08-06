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
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ManagerJob extends JPanel{
	private JButton btnAddSalary;
	private ApplicantDetails AppD[];
	private ApplicantDetails AppDFiltered[];
	private MainFrame main;
	private JList appList;
	private String p = "p3";
	private int index;
	private JTextField textField;
	private int sal;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField searchBox;
	private DefaultListModel model;
	
	public ManagerJob(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.model = new DefaultListModel();
		main.setSize(700,500);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 52, 470, 165);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(appList);
		
		//Button to logout
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
		btnLogout.setBounds(559, 8, 99, 33);
		add(btnLogout);
		
		JLabel lblJobOfferPage = new JLabel("Job Offer Page");
		lblJobOfferPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJobOfferPage.setBounds(304, 16, 99, 14);
		add(lblJobOfferPage);
		
		//Button to return to menu
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showMMainGUI();
			}
		});
		btnBack.setBounds(10, 8, 114, 33);
		add(btnBack);
		
		//View profile
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pIndex = appList.getSelectedIndex();
				if (pIndex == -1)
					return;
				ApplicantDetails app = AppDFiltered[pIndex];
				index = main.getController().getProfIndex(app);
				main.showDetailPageJob(index, app);
			}
		});
		btnViewProfile.setBounds(99, 350, 219, 50);
		add(btnViewProfile);
		
		JButton btnCountApplicants = new JButton("Count Applicants");
		btnCountApplicants.setBackground(SystemColor.controlHighlight);
		btnCountApplicants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = main.getController().getCount(); //Get count of new hires from datastorage
				JOptionPane.showMessageDialog(main, "Number of new hires: " + cnt);
			}
		});
		btnCountApplicants.setBounds(99, 402, 219, 56);
		add(btnCountApplicants);
		
		//Undo job offer
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
					main.getController().undoJob(det);
					main.getController().writeFile(); // Write applicant profile to json file
					populateAppDList();
				}
				else
					return;
			}
		});
		btnUndo.setBounds(99, 296, 219, 50);
		add(btnUndo);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalary.setBounds(124, 241, 99, 50);
		add(lblSalary);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(177, 252, 110, 33);
		add(textField);
		textField.setColumns(10);
		
		this.btnAddSalary = new JButton("Add Salary");
		btnAddSalary.setBackground(SystemColor.controlHighlight);
		btnAddSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pIndex = appList.getSelectedIndex();//Find index of applicant within list
				if(pIndex == -1)
					return;
				ApplicantDetails app = AppDFiltered[pIndex];
				if(textField.getText().isEmpty() == true)
					JOptionPane.showMessageDialog(main, "Please add salary");
				else
				{
					sal = Integer.valueOf(textField.getText());
			        main.getController().addSalary(app, sal);
			        main.getController().writeFile(); // Write applicant profile to json file
				    textField.setText("");
				}
				if(textField_1.getText().isEmpty()&&textField.getText().isEmpty()){
		        	populateAppDList();
			        searchBox.setText("");
		        }
		        else
		        	populateSearchedAppDList();  
			}
		});
		this.btnAddSalary.setBounds(328, 296, 241, 50);
		add(this.btnAddSalary);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setBounds(373, 411, 160, 36);
		add(lblNewLabel);
		
		JLabel lblHiredPosition = new JLabel("Hired Position:");
		lblHiredPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHiredPosition.setBounds(323, 241, 114, 50);
		add(lblHiredPosition);
		
		textField_1 = new JTextField();
		textField_1.setBounds(417, 252, 140, 33);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add Hired Position");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pIndex = appList.getSelectedIndex();
				if(pIndex == -1)
					return;
				ApplicantDetails app = AppDFiltered[pIndex];
				if(textField_1.getText().isEmpty() == true)
					JOptionPane.showMessageDialog(main, "Please add hired position");
				else
				{
					String hp = textField_1.getText();
			        main.getController().addHPos(app, hp);
			        main.getController().writeFile(); // Write applicant profile to json file
			        textField_1.setText("");
			        //Prevents search reset until salary and hired position is filled
			        if(textField_1.getText().isEmpty()&&textField.getText().isEmpty()){
			        	populateAppDList();
				        searchBox.setText("");
			        }
			        else
			        	populateSearchedAppDList();
				}
			}
		});
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.setBounds(328, 350, 241, 50);
		add(btnAdd);
		
		//Search bar
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch.setBounds(233, 228, 46, 14);
		add(lblSearch);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchFilter();
			}
		});
		searchBox.setBounds(289, 225, 148, 20);
		add(searchBox);
		searchBox.setColumns(10);
		this.populateAppDList();
	}
	
	//Method to execute search
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
			if(op.getSalary() == 0 && op.getHPosition() == null)
				listItem = op.getName();
		    else if(op.getHPosition() == null && op.getSalary() != 0)
				listItem = op.getName()+"          "+"$"+op.getSalary();
		    else if(op.getSalary() == 0 && op.getHPosition() != null)
		    	listItem = op.getName()+"          "+op.getHPosition();
		    else
		    	listItem = op.getName()+"          "+op.getHPosition()+"          "+"$"+op.getSalary();
			
			if(listItem.toLowerCase().contains(search.toLowerCase())){
				filter.addElement(listItem);
				filteredItems.add(op);
			}
			AppDFiltered = filteredItems.toArray(new ApplicantDetails[filteredItems.size()]);
			this.appList.setModel(filter);
		}
	}
	
	//Populate JList with profiles
	private void populateAppDList() {
		this.AppD = this.main.getController().getJAppList();
		this.AppDFiltered = this.AppD;
		model.clear();
		for (int i=0; i<AppD.length;i++)
		{
			ApplicantDetails op = AppD[i];
			if(op.getSalary() == 0 && op.getHPosition() == null)
				model.addElement(op.getName());
		    else if(op.getHPosition() == null && op.getSalary() != 0)
				model.addElement(op.getName()+"          "+op.getSalary());
		    else if(op.getSalary() == 0 && op.getHPosition() != null)
		    	model.addElement(op.getName()+"          "+op.getHPosition());
		    else
		    	model.addElement(op.getName()+"          "+op.getHPosition()+"          "+"$"+op.getSalary());
			//model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());
		}
		this.appList.setModel(model);
	} 
	
	//Populate JList with filtered results when still adding salary and hired position
	private void populateSearchedAppDList() {
		model.clear();
		for (int i=0; i<AppDFiltered.length;i++)
		{
			ApplicantDetails op = AppDFiltered[i];
			if(op.getSalary() == 0 && op.getHPosition() == null)
				model.addElement(op.getName());
		    else if(op.getHPosition() == null && op.getSalary() != 0)
				model.addElement(op.getName()+"          "+op.getSalary());
		    else if(op.getSalary() == 0 && op.getHPosition() != null)
		    	model.addElement(op.getName()+"          "+op.getHPosition());
		    else
		    	model.addElement(op.getName()+"          "+op.getHPosition()+"          "+"$"+op.getSalary());
			//model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());
		}
		this.appList.setModel(model);
	} 
}

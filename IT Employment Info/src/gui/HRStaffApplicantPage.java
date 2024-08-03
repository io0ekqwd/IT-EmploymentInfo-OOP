package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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

public class HRStaffApplicantPage extends JPanel {
    private ApplicantDetails[] AppD; //Array to hold applicant profiles
    private JList appList; // List to display applicants
    private int index; // Index of the selected applicant
	private ApplicantDetails[] AppDFiltered; //Array to hold filtered applicant profiles after search
	private JTextField searchBox;
	private DefaultListModel model;
	private MainFrame main;

    //Initialise panel
    public HRStaffApplicantPage(MainFrame main) {
        this.main = main;
        this.model = new DefaultListModel();
        setLayout(null);
        
        //Scroll pane to hold the list of applicants
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(129, 72, 450, 189);
        add(scrollPane);
        
        this.appList = new JList();
        scrollPane.setViewportView(appList);
        
        //Label for the page title
        JLabel lblApplicantPage = new JLabel("Applicant Page");
        lblApplicantPage.setBounds(305, 29, 93, 14);
        lblApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lblApplicantPage);
        
        //Logout button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(569, 13, 102, 46);
        btnLogout.setBackground(SystemColor.controlHighlight);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    main.showLogin();
                } else {
                    return;
                }
            }
        });
        add(btnLogout);
        
        //Button to add applicant profile
        JButton btnAddApplicant = new JButton("Add Applicant");
        btnAddApplicant.setBounds(129, 322, 155, 42);
        btnAddApplicant.setBackground(SystemColor.controlHighlight);
        btnAddApplicant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffAdd();
            }
        });
        add(btnAddApplicant);
        
        //Button to update applicant profile
        JButton btnUpdateApplicant = new JButton("Update Applicant");
        btnUpdateApplicant.setBounds(424, 322, 155, 42);
        btnUpdateApplicant.setBackground(SystemColor.controlHighlight);
        btnUpdateApplicant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                index = appList.getSelectedIndex();
                if (index == -1) {
                    return;
                }
                ApplicantDetails det = AppDFiltered[index];
                main.showHRStaffUpdate(index, det);
            }
        });
        add(btnUpdateApplicant);
        
        //Button to delete applicant
        JButton btnDeleteApplicant = new JButton("Delete Applicant");
        btnDeleteApplicant.setBounds(282, 378, 146, 42);
        btnDeleteApplicant.setBackground(SystemColor.controlHighlight);
        btnDeleteApplicant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                index = appList.getSelectedIndex();
                if (index == -1) {
                    return;
                }
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to delete?", "Delete", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    ApplicantDetails det = AppDFiltered[index];
                    main.getController().deleteProf(det);
                    main.getController().writeFile(); // Write applicant profile to json file
                    populateAppDList(); // Refresh applicant list
                } else {
                    return;
                }
            }
        });
        add(btnDeleteApplicant);
        
        //Button to return to HR Staff main menu
        JButton btnBackButton = new JButton("Back");
        btnBackButton.setBounds(32, 13, 102, 46);
        btnBackButton.setBackground(SystemColor.controlHighlight);
        btnBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                main.showHRStaffMainPage();
            }
        });
        add(btnBackButton);
        
        //Search bar to search for applicant
        JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch.setBounds(246, 284, 46, 14);
		add(lblSearch);
		
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchFilter();
			}
		});
		searchBox.setBounds(305, 282, 148, 20);
		add(searchBox);
		searchBox.setColumns(10);
        this.populateAppDList(); // Populate the applicant list
    }

    //Populate JList with applicant profile
    private void populateAppDList() {
        this.AppD = this.main.getController().getAppList(); // Get the list of applicants from the controller
        this.AppDFiltered = this.AppD;
        model.clear();
        for (int i = 0; i < AppDFiltered.length; i++) {
            ApplicantDetails det = AppDFiltered[i];
            model.addElement(det.getName()+"          "+det.getAPosition()); // Add applicant names to the model
        }
        this.appList.setModel(model); // Set the model for the JList
    } 
    
    //Apply search filter to JList
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

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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffShortlisted extends JPanel {
    private ApplicantDetails[] AppD; // Array to hold shortlisted applicant details
    private MainFrame main; // Reference to the main frame
    private JList appList; // JList to display applicants
    private int index; // Index of the selected applicant
    private JLabel lblNewLabel; // Label to display interview date
    private JLabel lblNewLabel_1; // Label to display interview venue
    private JLabel lblNewLabel_2; // Label to display interview time
    private JButton btnScheduleInterview; // Button to schedule/reschedule interview
    private String p = "p3"; //ID for profile viewing
	private JTextField searchBox;
	private ApplicantDetails[] AppDFiltered;
	private DefaultListModel model;

    //Initialise panel
    public HRStaffShortlisted(MainFrame main) {
        setLayout(null);
        this.main = main;
        this.model = new DefaultListModel();
        main.setSize(700, 500);
        
        //Scroll pane for the applicant list
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(120, 76, 450, 189);
        add(scrollPane);
        
        //JList for displaying applicants
        this.appList = new JList();
        scrollPane.setViewportView(appList);
        appList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    int index = appList.getSelectedIndex();
                    if (index == -1)
                        return;
                    ApplicantDetails app = AppDFiltered[index];
                    if (app.getInterviewDetails() != null) {
                        btnScheduleInterview.setText("Reschedule Interview");
                        lblNewLabel.setText(app.getInterviewDetails().getDay() + " " + app.getInterviewDetails().getMonth() + " " + app.getInterviewDetails().getYear());
                        lblNewLabel_1.setText(app.getInterviewDetails().getVenue());
                        lblNewLabel_2.setText(app.getInterviewDetails().getHour() + ":" + app.getInterviewDetails().getMin());
                    } else {
                        btnScheduleInterview.setText("Schedule Interview");
                        lblNewLabel.setText("(Please schedule date)");
                        lblNewLabel_1.setText("(Please schedule venue)");
                        lblNewLabel_2.setText("(Please schedule time)");
                    }
                }
            }
        });
        
        //Logout button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBackground(SystemColor.controlHighlight);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    main.showLogin(); // Show the login page on logout
                } else {
                    return;
                }
            }
        });
        btnLogout.setBounds(569, 13, 102, 46);
        add(btnLogout);
        
        //Button to return to the main menu
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(SystemColor.controlHighlight);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffMainPage(); 
            }
        });
        btnBack.setBounds(32, 13, 102, 46);
        add(btnBack);
        
        //Label for the page title
        JLabel lblShortlistPage = new JLabel("Shortlist Page");
        lblShortlistPage.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblShortlistPage.setBounds(305, 29, 93, 14);
        add(lblShortlistPage);
        
        //Button to schedule/reschedule interview
        this.btnScheduleInterview = new JButton("Schedule Interview");
        btnScheduleInterview.setBackground(SystemColor.controlHighlight);
        btnScheduleInterview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pIndex = appList.getSelectedIndex();
                if (pIndex == -1)
                    return;
                ApplicantDetails app = AppDFiltered[pIndex];
                index = main.getController().getProfIndex(app);
                main.showSchedulePage(index, app); // Show the schedule page for the selected applicant
            }
        });
        this.btnScheduleInterview.setBounds(377, 407, 192, 37);
        add(this.btnScheduleInterview);
        
        //Button to view the profile of the selected applicant
        JButton btnViewProfile = new JButton("View Profile");
        btnViewProfile.setBackground(SystemColor.controlHighlight);
        btnViewProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.getController().addID(p); //Add page index to be used to identity where to return to
                int index = appList.getSelectedIndex();
                if (index == -1)
                    return;
                ApplicantDetails app = AppDFiltered[index];
                main.showDetailPage(index, app);
            }
        });
        btnViewProfile.setBounds(103, 407, 146, 37);
        add(btnViewProfile);
        
        //Labels for interview details 
        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblDate.setBounds(209, 301, 46, 29);
        add(lblDate);
        
        JLabel lblVenue = new JLabel("Venue:");
        lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblVenue.setBounds(209, 341, 46, 22);
        add(lblVenue);
        
        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTime.setBounds(209, 374, 56, 22);
        add(lblTime);
        
        //Labels to show date, venue and time
        this.lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(268, 301, 349, 29);
        add(lblNewLabel);
        
        this.lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(268, 341, 376, 22);
        add(lblNewLabel_1);
        
        
        this.lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(268, 374, 322, 22);
        add(lblNewLabel_2);
        
        JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch.setBounds(229, 276, 46, 20);
		add(lblSearch);
		
		//Search bar to filter applicants
		searchBox = new JTextField();
		searchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchFilter();
				if(searchBox.getText().isEmpty()){
					lblNewLabel.setText("");
					lblNewLabel_1.setText("");
					lblNewLabel_2.setText("");
					btnScheduleInterview.setText("Schedule Interview");
				}
			}
		});
		searchBox.setBounds(285, 276, 148, 20);
		add(searchBox);
		searchBox.setColumns(10);
		//Call method to populate JList
        this.populateSAppDList();
    }
    
    //Populate JList with shortlisted applicants
    private void populateSAppDList() {
        this.AppD = this.main.getController().getSAppList();
        this.AppDFiltered = this.AppD;
        model.clear();
        for (int i = 0; i < AppD.length; i++) {
            ApplicantDetails op = AppD[i];
            model.addElement(op.getName()+"          "+op.getAPosition());
        }
        this.appList.setModel(model);
    }
    //Apply search filter to JList
    private void searchFilter() {
		String search = searchBox.getText();
		lblNewLabel.setText("");
		lblNewLabel_1.setText("");
		lblNewLabel_2.setText("");
		btnScheduleInterview.setText("Schedule Interview");
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

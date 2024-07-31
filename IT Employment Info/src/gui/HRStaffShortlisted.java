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
    private String p = "p2"; // Some identifier (possibly for profile viewing)

    // Constructor to initialize the panel
    public HRStaffShortlisted(MainFrame main) {
        setLayout(null);
        this.main = main;
        main.setSize(700, 500);
        
        // Scroll pane for the applicant list
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(120, 76, 450, 189);
        add(scrollPane);
        
        // JList for displaying applicants
        this.appList = new JList();
        scrollPane.setViewportView(appList);
        appList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    int index = appList.getSelectedIndex();
                    if (index == -1)
                        return;
                    ApplicantDetails app = AppD[index];
                    if (app.getInterviewDetails() != null) {
                        btnScheduleInterview.setText("Reschedule Interview");
                        lblNewLabel.setText(app.getInterviewDetails().getDay() + " " + app.getInterviewDetails().getMonth() + " " + app.getInterviewDetails().getYear());
                        lblNewLabel_1.setText(app.getInterviewDetails().getVenue());
                        lblNewLabel_2.setText(app.getInterviewDetails().getHour() + " " + app.getInterviewDetails().getMin());
                    } else {
                        btnScheduleInterview.setText("Schedule Interview");
                        lblNewLabel.setText("(Please schedule date)");
                        lblNewLabel_1.setText("(Please schedule venue)");
                        lblNewLabel_2.setText("(Please schedule time)");
                    }
                }
            }
        });
        
        // Logout button
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
        
        // Back button to return to the main page
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(SystemColor.controlHighlight);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffMainPage(); // Show the main HR staff page
            }
        });
        btnBack.setBounds(32, 13, 102, 46);
        add(btnBack);
        
        // Label for the page title
        JLabel lblShortlistPage = new JLabel("Shortlist Page");
        lblShortlistPage.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblShortlistPage.setBounds(305, 29, 93, 14);
        add(lblShortlistPage);
        
        // Button to schedule/reschedule an interview
        this.btnScheduleInterview = new JButton("Schedule Interview");
        btnScheduleInterview.setBackground(SystemColor.controlHighlight);
        btnScheduleInterview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int pIndex = appList.getSelectedIndex();
                if (pIndex == -1)
                    return;
                ApplicantDetails app = AppD[pIndex];
                index = main.getController().getProfIndex(app);
                main.showSchedulePage(index, app); // Show the schedule page for the selected applicant
            }
        });
        this.btnScheduleInterview.setBounds(378, 407, 192, 37);
        add(this.btnScheduleInterview);
        
        // Button to view the profile of the selected applicant
        JButton btnViewProfile = new JButton("View Profile");
        btnViewProfile.setBackground(SystemColor.controlHighlight);
        btnViewProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.getController().addID(p); // Possibly to identify the profile being viewed
                int index = appList.getSelectedIndex();
                if (index == -1)
                    return;
                ApplicantDetails app = AppD[index];
                main.showDetailPage(index, app); // Show the detail page for the selected applicant
            }
        });
        btnViewProfile.setBounds(103, 407, 146, 37);
        add(btnViewProfile);
        
        // Labels for interview details (date, venue, time)
        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(140, 315, 46, 14);
        add(lblDate);
        
        JLabel lblVenue = new JLabel("Venue:");
        lblVenue.setBounds(130, 283, 46, 14);
        add(lblVenue);
        
        this.lblNewLabel = new JLabel("");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(178, 315, 173, 22);
        add(lblNewLabel);
        
        this.lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_1.setBounds(178, 273, 173, 29);
        add(lblNewLabel_1);
        
        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(140, 350, 56, 16);
        add(lblTime);
        
        this.lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setBounds(178, 350, 56, 16);
        add(lblNewLabel_2);
        
        // Populate the applicant list with shortlisted applicants
        this.populateSAppDList();
    }
    
    // Method to populate the list of shortlisted applicants
    private void populateSAppDList() {
        this.AppD = this.main.getController().getSAppList();
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < AppD.length; i++) {
            ApplicantDetails op = AppD[i];
            model.addElement(op.getName());
            //model.addElement(op.getAge() + op.getName() + op.getStatus() + op.getAddress() + op.getEmail() + op.getPhone() + op.getPosition() + op.getSkills());
        }
        this.appList.setModel(model);
    }
    
    // Method to show the main GUI (possibly not used here)
    public void showMMainGUI() {
        this.main.showMMainGUI();
    }
}

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
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffApplicantPage extends JPanel {
    private ApplicantDetails[] AppD; // Array to hold applicant details
    private MainFrame main; // Reference to the main frame
    private JList appList; // List to display applicants
    private int index; // Index of the selected applicant

    // Constructor to initialize the panel
    public HRStaffApplicantPage(MainFrame main) {
        this.main = main;
        main.setSize(700, 500); // Set the size of the main frame
        setLayout(null);
        
        // Scroll pane to hold the list of applicants
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(129, 72, 450, 189);
        add(scrollPane);
        
        this.appList = new JList();
        scrollPane.setViewportView(appList);
        
        // Label for the page title
        JLabel lblApplicantPage = new JLabel("Applicant Page");
        lblApplicantPage.setBounds(305, 29, 93, 14);
        lblApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lblApplicantPage);
        
        // Logout button
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
        
        // Button to add a new applicant
        JButton btnAddApplicant = new JButton("Add Applicant");
        btnAddApplicant.setBounds(129, 274, 155, 42);
        btnAddApplicant.setBackground(SystemColor.controlHighlight);
        btnAddApplicant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffAdd();
            }
        });
        add(btnAddApplicant);
        
        // Button to update an existing applicant
        JButton btnUpdateApplicant = new JButton("Update Applicant");
        btnUpdateApplicant.setBounds(424, 274, 155, 42);
        btnUpdateApplicant.setBackground(SystemColor.controlHighlight);
        btnUpdateApplicant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                index = appList.getSelectedIndex();
                if (index == -1) {
                    return;
                }
                ApplicantDetails det = AppD[index];
                main.showHRStaffUpdate(index, det);
            }
        });
        add(btnUpdateApplicant);
        
        // Button to delete an existing applicant
        JButton btnDeleteApplicant = new JButton("Delete Applicant");
        btnDeleteApplicant.setBounds(282, 329, 155, 42);
        btnDeleteApplicant.setBackground(SystemColor.controlHighlight);
        btnDeleteApplicant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                index = appList.getSelectedIndex();
                if (index == -1) {
                    return;
                }
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to delete?", "Delete", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    ApplicantDetails det = AppD[index];
                    main.getController().deleteProf(det);
                    populateAppDList(); // Refresh the applicant list
                } else {
                    return;
                }
            }
        });
        add(btnDeleteApplicant);
        
        // Back button
        JButton btnBackButton = new JButton("Back");
        btnBackButton.setBounds(32, 13, 102, 46);
        btnBackButton.setBackground(SystemColor.controlHighlight);
        btnBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                main.showHRStaffMainPage();
            }
        });
        add(btnBackButton);
        
        this.populateAppDList(); // Populate the applicant list
    }

    // Method to populate the applicant list
    private void populateAppDList() {
        this.AppD = this.main.getController().getAppList(); // Get the list of applicants from the controller
        DefaultListModel model = new DefaultListModel(); // Create a model for the list
        for (int i = 0; i < AppD.length; i++) {
            ApplicantDetails det = AppD[i];
            model.addElement(det.getName()); // Add applicant names to the model
            // Optionally add other details
            // model.addElement(det.getAge() + det.getName() + det.getStatus() + det.getAddress() + det.getEmail() + det.getPhone() + det.getPosition() + det.getSkills());
        }
        this.appList.setModel(model); // Set the model for the JList
    } 
}

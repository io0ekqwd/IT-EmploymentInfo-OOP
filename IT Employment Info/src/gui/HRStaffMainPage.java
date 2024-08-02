package gui;

import javax.swing.JPanel;

import controller.MainFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffMainPage extends JPanel {
    private MainFrame main; // Reference to the main frame
    private ImageIcon img1, img2, img3; // Icons for UI elements

    //Initialise panel
    public HRStaffMainPage(MainFrame main) {
        setLayout(null);
        this.setSize(700, 500); // Set the size of the panel
        this.main = main;
        
        //Label for the page title
        JLabel lblManagerPage = new JLabel("HR Staff Page");
        lblManagerPage.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblManagerPage.setBounds(282, 13, 135, 21);
        add(lblManagerPage);
        
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
        btnLogout.setBounds(259, 313, 170, 63);
        add(btnLogout);
        
        //Button to open applicant page
        JButton btnApplicantPage = new JButton("Applicant Page");
        btnApplicantPage.setBackground(SystemColor.controlHighlight);
        btnApplicantPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffApplicantPage(); // Show the Applicant Page
            }
        });
        btnApplicantPage.setBounds(50, 56, 170, 63);
        add(btnApplicantPage);
        
        //Button to open shortlist page
        JButton btnShortlistPage = new JButton("Shortlist Page");
        btnShortlistPage.setBackground(SystemColor.controlHighlight);
        btnShortlistPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffShortlisted(); // Show the Shortlist Page
            }
        });
        btnShortlistPage.setBounds(440, 56, 170, 63);
        add(btnShortlistPage);
        
        //Load and display profile image
        this.img1 = new ImageIcon("images/icons8-profile-100.png");
        JLabel lblNewLabel = new JLabel(this.img1);
        lblNewLabel.setBounds(60, 132, 119, 156);
        add(lblNewLabel);
        
        //Load and display shortlist image 
        this.img2 = new ImageIcon("images/icons8-shortlist-64.png");
        JLabel lblNewLabel_1 = new JLabel(this.img2);
        lblNewLabel_1.setBounds(451, 140, 135, 142);
        add(lblNewLabel_1);
    }
}

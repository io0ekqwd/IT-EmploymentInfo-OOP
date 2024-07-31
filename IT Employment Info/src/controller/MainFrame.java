package controller;

import java.awt.CardLayout;
import javax.swing.JFrame;

import data.ApplicantDetails;
import gui.DetailPage;
import gui.DetailPageJob;
import gui.HRStaffApplicantPage;
import gui.HRStaffMainPage;
import gui.HRStaffShortlisted;
import gui.HRStaffAdd;
import gui.HRStaffUpdate;
import gui.Login;
import gui.ManagerApplicant;
import gui.ManagerShortlisted;
import gui.ManagerJob;
import gui.ManagerMainPage;
import gui.SchedulePage;

public class MainFrame extends JFrame {
    // CardLayout for managing different panels in the frame
    private CardLayout card;
    // Controller instance to manage the application logic
    private Controller cont;

    // Constructor to set up the main frame
    public MainFrame() {
        this.card = new CardLayout();
        this.cont = new Controller();
        this.setSize(700, 500);
        this.setTitle("IT Employment Infobase");
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(this.card);
        this.showLogin();
        this.setVisible(true);
    }
    
    // Method to get the controller instance
    public Controller getController() {
        return this.cont;
    }
    
    // Method to show the login panel
    public void showLogin() {
        Login p1 = new Login(this);
        this.add(p1, "Panel 1");
        this.card.show(this.getContentPane(), "Panel 1");
    }
    
    // Method to show the manager's applicant panel
    public void showManagerGUI() {
        ManagerApplicant p2 = new ManagerApplicant(this);
        this.add(p2, "Panel 2");
        this.card.show(this.getContentPane(), "Panel 2");
    }
    
    // Method to show the manager's shortlisted applicants panel
    public void showShortGUI() {
        ManagerShortlisted p3 = new ManagerShortlisted(this);
        this.add(p3, "Panel 3");
        this.card.show(this.getContentPane(), "Panel 3");
    }

    // Method to show the manager's job offers panel
    public void showJobGUI() {
        ManagerJob p4 = new ManagerJob(this);
        this.add(p4, "Panel 4");
        this.card.show(this.getContentPane(), "Panel 4");
    }

    // Method to show the manager's main page panel
    public void showMMainGUI() {
        ManagerMainPage p5 = new ManagerMainPage(this);
        this.add(p5, "Panel 5");
        this.card.show(this.getContentPane(), "Panel 5");
    }

    // Method to show the HR staff's main page panel
    public void showHRStaffMainPage() {
        HRStaffMainPage p6 = new HRStaffMainPage(this);
        this.add(p6, "Panel 6");
        this.card.show(this.getContentPane(), "Panel 6");
    }
    
    // Method to show the HR staff's add applicant panel
    public void showHRStaffAdd() {
        HRStaffAdd p7 = new HRStaffAdd(this);
        this.add(p7, "Panel 7");
        this.card.show(this.getContentPane(), "Panel 7");
    }
    
    // Method to show the detail page for an applicant
    public void showDetailPage(int index, ApplicantDetails det) {
        DetailPage p8 = new DetailPage(this, index, det);
        this.add(p8, "Panel 8");
        this.card.show(this.getContentPane(), "Panel 8");
    }

    // Method to show the schedule page for an applicant
    public void showSchedulePage(int index, ApplicantDetails det) {
        SchedulePage p9 = new SchedulePage(this, index, det);
        this.add(p9, "Panel 9");
        this.card.show(this.getContentPane(), "Panel 9");
    }
    
    // Method to show the detail page for a job offer to an applicant
    public void showDetailPageJob(int index, ApplicantDetails det) {
        DetailPageJob p10 = new DetailPageJob(this, index, det);
        this.add(p10, "Panel 10");
        this.card.show(this.getContentPane(), "Panel 10");
    }
    
    // Method to show the HR staff's update applicant panel
    public void showHRStaffUpdate(int ind, ApplicantDetails det) {
        HRStaffUpdate p11 = new HRStaffUpdate(this, ind, det);
        this.add(p11, "Panel 11");
        this.card.show(this.getContentPane(), "Panel 11");
    }
    
    // Method to show the HR staff's applicant panel
    public void showHRStaffApplicantPage() {
        HRStaffApplicantPage p12 = new HRStaffApplicantPage(this);
        this.add(p12, "Panel 12");
        this.card.show(this.getContentPane(), "Panel 12");
    }
    
    // Method to show the HR staff's shortlisted applicants panel
    public void showHRStaffShortlisted() {
        HRStaffShortlisted p13 = new HRStaffShortlisted(this);
        this.add(p13, "Panel 13");
        this.card.show(this.getContentPane(), "Panel 13");
    }
    
    // Main method to start the application
    public static void main(String[] args) {
        MainFrame ex = new MainFrame();
    }
}

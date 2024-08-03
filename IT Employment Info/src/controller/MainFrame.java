package controller;

import java.awt.CardLayout;
import javax.swing.JFrame;

import data.ApplicantDetails;
import data.User;
import gui.AdminAdd;
import gui.AdminEdit;
import gui.AdminPage;
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
    private CardLayout card; //Initalise CardLayout for switching panels
    private Controller cont; //Instance of controller to manage app logic

    //Setup MainFrame
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
    
    //Get controller instance in panels
    public Controller getController() {
        return this.cont;
    }
    
    //Show login panel
    public void showLogin() {
        Login p1 = new Login(this);
        this.add(p1, "Panel 1");
        this.card.show(this.getContentPane(), "Panel 1");
    }
    
    //Show manager applicant page
    public void showManagerGUI() {
        ManagerApplicant p2 = new ManagerApplicant(this);
        this.add(p2, "Panel 2");
        this.card.show(this.getContentPane(), "Panel 2");
    }
    
    //Show Manager shortlist page
    public void showShortGUI() {
        ManagerShortlisted p3 = new ManagerShortlisted(this);
        this.add(p3, "Panel 3");
        this.card.show(this.getContentPane(), "Panel 3");
    }

    //Show Manager job offer page
    public void showJobGUI() {
        ManagerJob p4 = new ManagerJob(this);
        this.add(p4, "Panel 4");
        this.card.show(this.getContentPane(), "Panel 4");
    }

    //Show manager main menu
    public void showMMainGUI() {
        ManagerMainPage p5 = new ManagerMainPage(this);
        this.add(p5, "Panel 5");
        this.card.show(this.getContentPane(), "Panel 5");
    }

    //Show HR Staff main menu
    public void showHRStaffMainPage() {
        HRStaffMainPage p6 = new HRStaffMainPage(this);
        this.add(p6, "Panel 6");
        this.card.show(this.getContentPane(), "Panel 6");
    }
    
    //Show HR Staff add menu
    public void showHRStaffAdd() {
        HRStaffAdd p7 = new HRStaffAdd(this);
        this.add(p7, "Panel 7");
        this.card.show(this.getContentPane(), "Panel 7");
    }
    
    //Show details of applicants
    public void showDetailPage(int index, ApplicantDetails det) {
        DetailPage p8 = new DetailPage(this, index, det);
        this.add(p8, "Panel 8");
        this.card.show(this.getContentPane(), "Panel 8");
    }

    //Show scheduling page to schedule interviews
    public void showSchedulePage(int index, ApplicantDetails det) {
        SchedulePage p9 = new SchedulePage(this, index, det);
        this.add(p9, "Panel 9");
        this.card.show(this.getContentPane(), "Panel 9");
    }
    
    //Show details of applicants who were hired
    public void showDetailPageJob(int index, ApplicantDetails det) {
        DetailPageJob p10 = new DetailPageJob(this, index, det);
        this.add(p10, "Panel 10");
        this.card.show(this.getContentPane(), "Panel 10");
    }
    
    //Show HR Staff update menu
    public void showHRStaffUpdate(int ind, ApplicantDetails det) {
        HRStaffUpdate p11 = new HRStaffUpdate(this, ind, det);
        this.add(p11, "Panel 11");
        this.card.show(this.getContentPane(), "Panel 11");
    }
    
    //Show HR Staff applicant page
    public void showHRStaffApplicantPage() {
        HRStaffApplicantPage p12 = new HRStaffApplicantPage(this);
        this.add(p12, "Panel 12");
        this.card.show(this.getContentPane(), "Panel 12");
    }
    
    //Show HR Staff shortlist page
    public void showHRStaffShortlisted() {
        HRStaffShortlisted p13 = new HRStaffShortlisted(this);
        this.add(p13, "Panel 13");
        this.card.show(this.getContentPane(), "Panel 13");
    }
    
    //Show AdminPage panel
    public void showAdminPage() {
        AdminPage p14 = new AdminPage(this);
        this.add(p14, "Panel 14");
        this.card.show(this.getContentPane(), "Panel 14");
    }
    
    //Show AdminAdd panel
    public void showAdminAdd() {
    	AdminAdd p15 = new AdminAdd(this);
        this.add(p15, "Panel 15");
        this.card.show(this.getContentPane(), "Panel 15");
    }
    
    //Show AdminEdit panel
    public void showAdminEdit(int ind, User u) {
    	AdminEdit p16 = new AdminEdit(this, ind, u);
        this.add(p16, "Panel 16");
        this.card.show(this.getContentPane(), "Panel 16");
	}
    //Run the application
    public static void main(String[] args) {
        MainFrame ex = new MainFrame();
    }

	


}

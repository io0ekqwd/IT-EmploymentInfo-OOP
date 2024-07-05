package controller;

import java.awt.CardLayout;
import javax.swing.JFrame;

import gui.HRStaffGUI;
import gui.HRStaffGUI2;
import gui.Login;
import gui.ManagerGUI;
import gui.ManagerGUI2;
import gui.ManagerGUI3;
import gui.ManagerMainPage;

public class MainFrame extends JFrame {
	private CardLayout card;
	private Controller cont;
	public MainFrame() 
	{
		this.card = new CardLayout();
		this.cont = new Controller();
		this.setSize(450,350);
		this.setTitle("IT Employment Infobase");
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(this.card);
		this.showLogin();
		this.setVisible(true);
	}
	
	public Controller getController() {
		return this.cont;
	}
	
	public void showLogin() {
		Login p1 = new Login(this);
		this.add(p1, "Panel 1");
		this.card.show(this.getContentPane(), "Panel 1");
	}
	
	public void showManagerGUI() {
		ManagerGUI p2 = new ManagerGUI(this);
		this.add(p2, "Panel 2");
		this.card.show(this.getContentPane(), "Panel 2");
	}
	
	public void showShortGUI() {
		ManagerGUI2 p3 = new ManagerGUI2(this);
		this.add(p3, "Panel 3");
		this.card.show(this.getContentPane(), "Panel 3");
	}
	public void showJobGUI() {
		ManagerGUI3 p4 = new ManagerGUI3(this);
		this.add(p4, "Panel 4");
		this.card.show(this.getContentPane(), "Panel 4");
	}
	public void showMMainGUI() {
		ManagerMainPage p5 = new ManagerMainPage(this);
		this.add(p5, "Panel 5");
		this.card.show(this.getContentPane(), "Panel 5");
	}

	public void showHRStaffGUI() {
		HRStaffGUI p7 = new HRStaffGUI(this);
		this.add(p7, "Panel 7");
		this.card.show(this.getContentPane(), "Panel 7");
	}
	
	public void showHRStaffGUI2() {
		HRStaffGUI2 p8 = new HRStaffGUI2(this);
		this.add(p8, "Panel 8");
		this.card.show(this.getContentPane(), "Panel 8");
	}
	
	

	public static void main(String[] args) {
		MainFrame ex = new MainFrame();

	}
//test
}

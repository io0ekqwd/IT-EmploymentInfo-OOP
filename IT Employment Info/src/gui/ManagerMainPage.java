package gui;

import javax.swing.JPanel;

import controller.MainFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMainPage extends JPanel {
	private MainFrame main;
	private JComboBox cbPage;
	private String[] valArr = {"Applicant Page", "Shortlist Page", "Job Offer Page"};
	public ManagerMainPage(MainFrame main) {
		setLayout(null);
		this.main = main;
		
		JLabel lblManagerPage = new JLabel("Manager Page");
		lblManagerPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblManagerPage.setBounds(171, 11, 102, 21);
		add(lblManagerPage);
		
		this.cbPage = new JComboBox(this.valArr);
		cbPage.setBounds(143, 71, 139, 20);
		add(cbPage);
		
		JButton btnGoToPage = new JButton("Go To Page");
		btnGoToPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openPage();
			}
		});
		btnGoToPage.setBounds(154, 112, 119, 23);
		add(btnGoToPage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.showLogin();
			}
		});
		btnLogout.setBounds(154, 190, 119, 23);
		add(btnLogout);
	}
	public void openPage() {
		int pageIndex = this.cbPage.getSelectedIndex();
		if (pageIndex == 0)
			this.main.showManagerGUI();
		else if (pageIndex == 1)
			this.main.showShortGUI();
		else if (pageIndex == 2)
			this.main.showJobGUI();
	}
}

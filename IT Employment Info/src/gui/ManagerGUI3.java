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

public class ManagerGUI3 extends JPanel{
	private JButton btnAddSalary;
	private ApplicantDetails AppD[];
	private MainFrame main;
	private JList appList;
	private String p = "";
	private int index;
	private JTextField textField;
	private int sal;
	private JLabel lblNewLabel;
	
	public ManagerGUI3(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.setSize(450, 400);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 54, 450, 189);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(this.appList);
		
		JButton btnLogout = new JButton("Logout");
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
		btnLogout.setBounds(330, 8, 89, 23);
		add(btnLogout);
		
		JLabel lblJobOfferPage = new JLabel("Job Offer Page");
		lblJobOfferPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJobOfferPage.setBounds(177, 11, 99, 14);
		add(lblJobOfferPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMMainGUI();
			}
		});
		btnBack.setBounds(36, 8, 89, 23);
		add(btnBack);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = "p3";
				main.getController().addID(p);
				int index = appList.getSelectedIndex();
				if (index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.showDetailPage(index, app);
			}
		});
		btnViewProfile.setBounds(10, 344, 140, 23);
		add(btnViewProfile);
		
		JButton btnCountApplicants = new JButton("Count Applicants");
		btnCountApplicants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCountApplicants.setBounds(280, 344, 160, 23);
		add(btnCountApplicants);
		
		JButton button = new JButton("Delete");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = "p3";
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Are you sure to delete?","Delete", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					main.getController().deleteProf(index);
					populateAppDList();
				}
				else
					return;
			}
		});
		button.setBounds(10, 310, 140, 23);
		add(button);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(281, 279, 99, 14);
		add(lblSalary);
		
		textField = new JTextField();
		textField.setBounds(330, 276, 110, 20);
		add(textField);
		textField.setColumns(10);
		
		this.btnAddSalary = new JButton("Add Salary");
		btnAddSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails app = AppD[index];
				if(textField.getText().isEmpty() == true)
					lblNewLabel.setText("Please fill in salary.");
				else
				{
					sal = Integer.valueOf(textField.getText());
			        main.getController().addSalary(index, app, sal);
				    textField.setText("");
				    lblNewLabel.setText("");
				}
					
				
			populateAppDList();   
			}
		});
		this.btnAddSalary.setBounds(280, 310, 160, 23);
		add(this.btnAddSalary);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(280, 375, 160, 14);
		add(lblNewLabel);
		this.populateAppDList();
	}
	//Test
	private void populateAppDList() {
		this.AppD = this.main.getController().getJobList();
		DefaultListModel model = new DefaultListModel();
		for (int i=0; i<AppD.length;i++)
		{
			ApplicantDetails op = AppD[i];
			if(op.getSalary()!=0)
			{
				model.addElement(op.getName()+"          "+op.getPosition()+"          "+"$"+op.getSalary());
			}
			else
				model.addElement(op.getName()+"          "+op.getPosition());
			//model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());
		}
		this.appList.setModel(model);
	} 
	//Test
	public void showMMainGUI() {
		this.main.showMMainGUI();
	}
}

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
import java.awt.Color;
import java.awt.SystemColor;

public class ManagerJob extends JPanel{
	private JButton btnAddSalary;
	private ApplicantDetails AppD[];
	private MainFrame main;
	private JList appList;
	private String p = "p3";
	private int index;
	private JTextField textField;
	private int sal;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	
	public ManagerJob(MainFrame main) {
		setLayout(null);
		this.main = main;
		main.setSize(700,500);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 52, 646, 189);
		add(scrollPane);
		
		this.appList = new JList();
		scrollPane.setViewportView(appList);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(SystemColor.controlHighlight);
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
		btnLogout.setBounds(577, 8, 89, 33);
		add(btnLogout);
		
		JLabel lblJobOfferPage = new JLabel("Job Offer Page");
		lblJobOfferPage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJobOfferPage.setBounds(304, 16, 99, 14);
		add(lblJobOfferPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showMMainGUI();
			}
		});
		btnBack.setBounds(20, 8, 114, 33);
		add(btnBack);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBackground(SystemColor.controlHighlight);
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = appList.getSelectedIndex();
				if (index == -1)
					return;
				ApplicantDetails app = AppD[index];
				main.showDetailPageJob(index, app);
			}
		});
		btnViewProfile.setBounds(99, 350, 219, 50);
		add(btnViewProfile);
		
		JButton btnCountApplicants = new JButton("Count Applicants");
		btnCountApplicants.setBackground(SystemColor.controlHighlight);
		btnCountApplicants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = main.getController().getCount();
				JOptionPane.showMessageDialog(main, "Number of new hires: " + cnt);
			}
		});
		btnCountApplicants.setBounds(99, 402, 219, 56);
		add(btnCountApplicants);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBackground(SystemColor.controlHighlight);
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.getController().addID(p);
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				int opt = JOptionPane.showConfirmDialog(main, "Do you want to undo?","Undo", JOptionPane.YES_NO_OPTION);
				if(opt==0)
				{
					ApplicantDetails det = AppD[index];
					main.getController().undoJob(index,det);
					populateAppDList();
				}
				else
					return;
			}
		});
		btnUndo.setBounds(99, 296, 219, 50);
		add(btnUndo);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalary.setBounds(124, 241, 99, 50);
		add(lblSalary);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(177, 252, 110, 33);
		add(textField);
		textField.setColumns(10);
		
		this.btnAddSalary = new JButton("Add Salary");
		btnAddSalary.setBackground(SystemColor.controlHighlight);
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
		this.btnAddSalary.setBounds(328, 296, 241, 50);
		add(this.btnAddSalary);
		
		this.lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setBounds(373, 411, 160, 36);
		add(lblNewLabel);
		
		JLabel lblHiredPosition = new JLabel("Hired Position:");
		lblHiredPosition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHiredPosition.setBounds(323, 241, 114, 50);
		add(lblHiredPosition);
		
		textField_1 = new JTextField();
		textField_1.setBounds(417, 252, 140, 33);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add Hired Position");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				index = appList.getSelectedIndex();
				if(index == -1)
					return;
				ApplicantDetails app = AppD[index];
				if(textField.getText().isEmpty() == true)
					lblNewLabel.setText("Please fill in salary.");
				else
				{
					String hp = textField_1.getText();
			        main.getController().addHPos(index, app, hp);
				    textField_1.setText("");
				    //lblNewLabel.setText("");
				}
			populateAppDList();   
			}
		});
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.setBounds(328, 350, 241, 50);
		add(btnAdd);
		this.populateAppDList();
	}
	//Test
	private void populateAppDList() {
		main.getController().addID(p);
		this.AppD = this.main.getController().getAppList();
		DefaultListModel model = new DefaultListModel();
		for (int i=0; i<AppD.length;i++)
		{
			ApplicantDetails op = AppD[i];
			if(op.getShortlist() == true && op.getJob() == true)
			{
				if(op.getSalary()!=0)
				{
					model.addElement(op.getName()+"          "+op.getHPosition()+"          "+"$"+op.getSalary());
				}
				else
					model.addElement(op.getName()+"          "+op.getHPosition());
			}
			//model.addElement(op.getAge()+op.getName()+op.getStatus()+op.getAddress()+op.getEmail()+op.getPhone()+op.getPosition()+op.getSkills());
		}
		this.appList.setModel(model);
	} 
}

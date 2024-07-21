package gui;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import controller.MainFrame;
import data.ApplicantDetails;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class SchedulePage extends JPanel{
	private int index;
	private ApplicantDetails det;
	private JTextField textFieldDay;
	private JTextField textFieldYear;
	private JTextField textField;
	private MainFrame main;
	private JComboBox comboBoxMonth;
	private String[] monthArr = {"January", "Febuary", "March","April","May","June","July","August","September","October","November","December"};
	public SchedulePage(MainFrame main, int ind, ApplicantDetails det) {
		this.index = ind;
		this.det = det;
		this.main = main;
		setLayout(null);
		
		
		JLabel lblSchedulingPage = new JLabel("Scheduling Page");
		lblSchedulingPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSchedulingPage.setBounds(155, 50, 145, 25);
		add(lblSchedulingPage);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(71, 143, 56, 14);
		add(lblDate);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setBounds(71, 181, 46, 14);
		add(lblVenue);
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(117, 140, 56, 20);
		add(textFieldDay);
		textFieldDay.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textFieldDay.setText(String.valueOf(det.getInterviewDetails().getDay()));
		
		this.comboBoxMonth = new JComboBox(this.monthArr);
		this.comboBoxMonth.setBounds(183, 140, 111, 20);
		add(this.comboBoxMonth);
		if(det.getInterviewDetails()!=null)
			comboBoxMonth.setSelectedItem(det.getInterviewDetails().getMonth());
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(304, 140, 56, 20);
		add(textFieldYear);
		textFieldYear.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textFieldYear.setText(String.valueOf(det.getInterviewDetails().getYear()));
		
		textField = new JTextField();
		textField.setBounds(117, 178, 86, 20);
		add(textField);
		textField.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textField.setText(det.getInterviewDetails().getVenue());
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showShortGUI();
			}
		});
		btnBack.setBounds(26, 243, 125, 43);
		add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int d = Integer.valueOf(textFieldDay.getText());
				String m = String.valueOf(comboBoxMonth.getSelectedItem());
				int y =Integer.valueOf(textFieldYear.getText());
				String v = textField.getText();
				main.getController().scheInte(ind, det, d, m, v, y);
				main.showShortGUI();
			}
		});
		btnSave.setBounds(272, 243, 125, 43);
		add(btnSave);
	}
}

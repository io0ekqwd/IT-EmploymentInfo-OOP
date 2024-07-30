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
	private String[] ampmArr = {"AM","PM"};
	private JTextField textField_1;
	private JTextField textField_2;
	public SchedulePage(MainFrame main, int ind, ApplicantDetails det) {
		this.index = ind;
		this.det = det;
		this.main = main;
		main.setSize(450,350);
		setLayout(null);
		
		
		JLabel lblSchedulingPage = new JLabel("Scheduling Page");
		lblSchedulingPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSchedulingPage.setBounds(155, 50, 145, 25);
		add(lblSchedulingPage);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(73, 126, 56, 14);
		add(lblDate);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setBounds(73, 154, 46, 14);
		add(lblVenue);
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(117, 123, 56, 20);
		add(textFieldDay);
		textFieldDay.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textFieldDay.setText(String.valueOf(det.getInterviewDetails().getDay()));
		
		this.comboBoxMonth = new JComboBox(this.monthArr);
		this.comboBoxMonth.setBounds(183, 123, 111, 20);
		add(this.comboBoxMonth);
		if(det.getInterviewDetails()!=null)
			comboBoxMonth.setSelectedItem(det.getInterviewDetails().getMonth());
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(304, 123, 56, 20);
		add(textFieldYear);
		textFieldYear.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textFieldYear.setText(String.valueOf(det.getInterviewDetails().getYear()));
		
		textField = new JTextField();
		textField.setBounds(117, 151, 86, 20);
		add(textField);
		textField.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textField.setText(det.getInterviewDetails().getVenue());
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showHRStaffShortlisted();
			}
		});
		btnBack.setBounds(26, 243, 125, 43);
		add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(SystemColor.controlHighlight);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int d = Integer.valueOf(textFieldDay.getText());
				String m = String.valueOf(comboBoxMonth.getSelectedItem());
				int y =Integer.valueOf(textFieldYear.getText());
				String v = textField.getText();
		        int h = Integer.valueOf(textField_1.getText());
		        int min = Integer.valueOf(textField_2.getText());
		       // String ap = String.valueOf(comboBoxAMPM.getSelectedItem());
				main.getController().scheInte(ind, det, d, m, v, y, h, min);
				main.showHRStaffShortlisted();
			}
		});
		btnSave.setBounds(272, 243, 125, 43);
		add(btnSave);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(73, 186, 46, 14);
		add(lblTime);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 183, 39, 20);
		add(textField_1);
		textField_1.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textField_1.setText(String.valueOf(det.getInterviewDetails().getHour()));
		
		JLabel label = new JLabel("  :");
		label.setBounds(155, 186, 46, 14);
		add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 182, 46, 21);
		add(textField_2);
		textField_2.setColumns(10);
		if(det.getInterviewDetails()!=null)
			textField_2.setText(String.valueOf(det.getInterviewDetails().getMin()));
	}
}

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
		this.setSize(313,248);
		
		JLabel lblSchedulingPage = new JLabel("Scheduling Page");
		lblSchedulingPage.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSchedulingPage.setBounds(106, 22, 136, 25);
		add(lblSchedulingPage);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(36, 98, 56, 14);
		add(lblDate);
		
		JLabel lblVenue = new JLabel("Venue:");
		lblVenue.setBounds(36, 141, 46, 14);
		add(lblVenue);
		
		textFieldDay = new JTextField();
		textFieldDay.setBounds(79, 95, 39, 20);
		add(textFieldDay);
		textFieldDay.setColumns(10);
		
		this.comboBoxMonth = new JComboBox(this.monthArr);
		this.comboBoxMonth.setBounds(128, 95, 77, 20);
		add(this.comboBoxMonth);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(215, 95, 56, 20);
		add(textFieldYear);
		textFieldYear.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(79, 138, 86, 20);
		add(textField);
		textField.setColumns(10);
		textField.setText(det.getVenue());
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showShortGUI();
			}
		});
		btnBack.setBounds(29, 186, 89, 23);
		add(btnBack);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String d = textFieldDay.getText() + comboBoxMonth.getToolTipText() + textFieldYear.getText();
				String v = textField.getText();
				det.setDate(d);
				det.setVenue(v);
				main.getController().scheInte(ind, det);
			}
		});
		btnSave.setBounds(212, 186, 89, 23);
		add(btnSave);
	}
}

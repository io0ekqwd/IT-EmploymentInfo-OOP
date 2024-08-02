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

public class SchedulePage extends JPanel {
    private int index; // Index of the applicant
    private ApplicantDetails det; // Applicant details
    private JTextField textFieldDay; // Text field for day of the interview
    private JTextField textFieldYear; // Text field for year of the interview
    private JTextField textField; // Text field for venue
    private MainFrame main; // Reference to the main frame
    private JComboBox comboBoxMonth; // ComboBox for selecting the month
    private String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; // Array for month names
    private JTextField textField_1; // Text field for hour of the interview
    private JTextField textField_2; // Text field for minutes of the interview

    // Constructor to initialize the panel and set up components
    public SchedulePage(MainFrame main, int ind, ApplicantDetails det) {
        this.index = ind;
        this.det = det;
        this.main = main;
        setLayout(null); // Use absolute layout for positioning components

        // Label for the scheduling page title
        JLabel lblSchedulingPage = new JLabel("Scheduling Page");
        lblSchedulingPage.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSchedulingPage.setBounds(276, 51, 145, 33);
        add(lblSchedulingPage);

        // Label and text field for the day of the interview
        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblDate.setBounds(206, 180, 56, 25);
        add(lblDate);

        textFieldDay = new JTextField();
        textFieldDay.setBounds(252, 183, 56, 20);
        add(textFieldDay);
        textFieldDay.setColumns(10);
        if (det.getInterviewDetails() != null) {
            textFieldDay.setText(String.valueOf(det.getInterviewDetails().getDay())); // Set existing day value if available
        }

        // ComboBox for selecting the month
        this.comboBoxMonth = new JComboBox(this.monthArr);
        this.comboBoxMonth.setBounds(318, 183, 111, 20);
        add(this.comboBoxMonth);
        if (det.getInterviewDetails() != null) {
            comboBoxMonth.setSelectedItem(det.getInterviewDetails().getMonth()); // Set existing month value if available
        }

        // Text field for the year of the interview
        textFieldYear = new JTextField();
        textFieldYear.setBounds(439, 183, 56, 20);
        add(textFieldYear);
        textFieldYear.setColumns(10);
        if (det.getInterviewDetails() != null) {
            textFieldYear.setText(String.valueOf(det.getInterviewDetails().getYear())); // Set existing year value if available
        }

        // Text field for the venue of the interview
        JLabel lblVenue = new JLabel("Venue:");
        lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblVenue.setBounds(196, 216, 46, 17);
        add(lblVenue);

        textField = new JTextField();
        textField.setBounds(252, 215, 188, 20);
        add(textField);
        textField.setColumns(10);
        if (det.getInterviewDetails() != null) {
            textField.setText(det.getInterviewDetails().getVenue()); // Set existing venue value if available
        }

        // Back button to navigate to the shortlisted applicants page
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(SystemColor.controlHighlight);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffShortlisted(); // Show the shortlisted applicants page
            }
        });
        btnBack.setBounds(117, 318, 125, 43);
        add(btnBack);

        // Save button to save the scheduling details
        JButton btnSave = new JButton("Save");
        btnSave.setBackground(SystemColor.controlHighlight);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int d = Integer.valueOf(textFieldDay.getText()); // Get the day
                String m = String.valueOf(comboBoxMonth.getSelectedItem()); // Get the selected month
                int y = Integer.valueOf(textFieldYear.getText()); // Get the year
                String v = textField.getText(); // Get the venue
                int h = Integer.valueOf(textField_1.getText()); // Get the hour
                int min = Integer.valueOf(textField_2.getText()); // Get the minutes

                // Save scheduling details through the controller
                main.getController().scheInte(ind, det, d, m, v, y, h, min);
                main.getController().writeFile(); // Write applicant profile to json file
                main.showHRStaffShortlisted(); // Navigate back to the shortlisted applicants page
            }
        });
        btnSave.setBounds(436, 318, 125, 43);
        add(btnSave);

        // Label and text fields for the time of the interview
        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblTime.setBounds(206, 244, 46, 25);
        add(lblTime);

        textField_1 = new JTextField();
        textField_1.setBounds(252, 246, 39, 23);
        add(textField_1);
        textField_1.setColumns(10);
        if (det.getInterviewDetails() != null) {
            textField_1.setText(String.valueOf(det.getInterviewDetails().getHour())); // Set existing hour value if available
        }

        JLabel label = new JLabel("  :");
        label.setBounds(289, 250, 46, 14);
        add(label);

        textField_2 = new JTextField();
        textField_2.setBounds(304, 246, 46, 23);
        add(textField_2);
        textField_2.setColumns(10);
        if (det.getInterviewDetails() != null) {
            textField_2.setText(String.valueOf(det.getInterviewDetails().getMin())); // Set existing minutes value if available
        }
    }
}

package gui;

import javax.swing.JPanel;

import controller.MainFrame;
import data.ApplicantDetails;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Color;

public class DetailPageJob extends JPanel {
	private MainFrame main;
	private int index;
	private ApplicantDetails det;
	
	public DetailPageJob(MainFrame main, int ind, ApplicantDetails det) {
		this.main = main;
		this.index = ind;
		this.det = det;
		setLayout(null);
		
		//Labels for various applicant profile details
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(267, 70, 46, 14);
		add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(273, 100, 46, 14);
		add(lblAge);
		
		JLabel lblPhone = new JLabel("Phone Number:");
		lblPhone.setBounds(216, 129, 98, 16);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(225, 165, 46, 14);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(462, 70, 102, 14);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Applied Position:");
		lblPosition.setBounds(210, 195, 116, 16);
		add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(257, 228, 56, 16);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(23, 273, 126, 14);
		add(lblPSkills);
		
		JLabel lblExperience = new JLabel("Experience:");
		lblExperience.setBounds(429, 273, 102, 14);
		add(lblExperience);
		
		JLabel lblHiredPosition = new JLabel("Hired Position:");
		lblHiredPosition.setBounds(462, 130, 92, 14);
		add(lblHiredPosition);
		
		JLabel Salary = new JLabel("Annual Salary:");
		Salary.setBounds(462, 165, 92, 14);
		add(Salary);
		
		//Button to return to Manager Job Offer Page
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			main.showJobGUI();
			}
			});
		
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		

		//Labels to display the various applicant details
		JLabel lblNameL = new JLabel("");
		lblNameL.setBounds(310, 67, 115, 20);
		add(lblNameL);
		lblNameL.setText(det.getName());
		
		JLabel lblAgeL = new JLabel("");
		lblAgeL.setBounds(310, 98, 46, 20);
		add(lblAgeL);
		lblAgeL.setText(String.valueOf(det.getAge()));
		
		JLabel lblPhoneL = new JLabel("");
		lblPhoneL.setBounds(310, 127, 143, 20);
		add(lblPhoneL);
		lblPhoneL.setText(det.getPhone());
		
		JLabel lblEmailL = new JLabel("");
		lblEmailL.setBounds(267, 161, 221, 22);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(310, 192, 143, 22);
		add(lblPosL);
		lblPosL.setText(det.getAPosition());
		
		JLabel lblStatusL = new JLabel("");
		lblStatusL.setBounds(298, 225, 153, 22);
		add(lblStatusL);
		lblStatusL.setText(det.getStatus());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(219, 273, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel label = new JLabel("             <image here>");
		label.setBounds(31, 69, 150, 150);
		add(label);
		if(det.getImagePath()!=null){
			try {
                Image img = ImageIO.read(new File(det.getImagePath()));
                Image resizedImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(resizedImg)); // Display the image
            } catch (IOException ex) {
                System.out.println("Error loading image: " + ex.getMessage());
            }
		}
		
		JTextArea textAddress = new JTextArea();
		textAddress.setForeground(SystemColor.desktop);
		textAddress.setEditable(false);
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAddress.setBounds(520, 70, 133, 56);
		textAddress.setOpaque(false);
		add(textAddress);
		textAddress.setText(det.getAddress());
		
		JTextArea textPSkills = new JTextArea();
		textPSkills.setEditable(false);
		textPSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPSkills.setBounds(25, 286, 181, 108);
		textPSkills.setOpaque(false);
		add(textPSkills);
		textPSkills.setText(det.getSkills().getPskills());
		
		JTextArea textISkills = new JTextArea();
		textISkills.setEditable(false);
		textISkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textISkills.setBounds(216, 286, 196, 108);
		textISkills.setOpaque(false);
		add(textISkills);
		textISkills.setText(det.getSkills().getIskills());
		
		
		
		JTextArea textExp = new JTextArea();
		textExp.setText((String) null);
		textExp.setOpaque(false);
		textExp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textExp.setEditable(false);
		textExp.setBounds(425, 286, 181, 108);
		add(textExp);
		textExp.setText(det.getExp());
		
		
		
		
		
		JLabel lblHPos = new JLabel("New label");
		lblHPos.setBounds(564, 130, 126, 14);
		add(lblHPos);
		lblHPos.setText(det.getHPosition());
		
		JLabel lblSal = new JLabel("New label");
		lblSal.setBounds(563, 165, 90, 14);
		add(lblSal);
		lblSal.setText("$"+ String.valueOf(det.getSalary()));
		
		
	}
}

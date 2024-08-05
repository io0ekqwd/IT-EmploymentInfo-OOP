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

public class DetailPage extends JPanel {
	private MainFrame main;
	private int index;
	private ApplicantDetails det;
	
	public DetailPage(MainFrame main, int ind, ApplicantDetails det) {
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
		lblEmail.setBounds(216, 165, 46, 14);
		add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(420, 70, 102, 14);
		add(lblAddress);
		
		JLabel lblPosition = new JLabel("Applied Position:");
		lblPosition.setBounds(210, 195, 116, 16);
		add(lblPosition);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(257, 228, 56, 16);
		add(lblStatus);
		
		JLabel lblPSkills = new JLabel("Programming Skills:");
		lblPSkills.setBounds(31, 273, 126, 14);
		add(lblPSkills);
		
		JLabel lblExperience = new JLabel("Experience:");
		lblExperience.setBounds(450, 273, 102, 14);
		add(lblExperience);
		
		//Button to return back to previous page
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String p = main.getController().getID();
			if (p.equals("p1"))
				main.showManagerGUI();
			else if (p.equals("p2"))
				main.showShortGUI();
			else if(p.equals("p3"))
				main.showHRStaffShortlisted();
			main.getController().clearID();
			}
			});
		
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		
		//Labels to display the applicant profile
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
		lblEmailL.setBounds(257, 161, 289, 22);
		add(lblEmailL);
		lblEmailL.setText(det.getEmail());
		
		JLabel lblPosL = new JLabel("");
		lblPosL.setBounds(310, 192, 143, 22);
		add(lblPosL);
		lblPosL.setText(det.getAPosition());
		
		JLabel lblStatusL = new JLabel("");
		lblStatusL.setBounds(310, 225, 153, 22);
		add(lblStatusL);
		lblStatusL.setText(det.getStatus());
		
		JLabel lblIndustrialSkills = new JLabel("Industrial Skills:");
		lblIndustrialSkills.setBounds(244, 273, 126, 14);
		add(lblIndustrialSkills);
		
		JLabel label = new JLabel("             <image here>");
		label.setBounds(31, 69, 150, 150);
		add(label);
		if(det.getImagePath()!=null){
			try {
                Image img = ImageIO.read(new File(det.getImagePath()));
                Image resizedImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(resizedImg)); // Display the image
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		
		
		JTextArea textAddress = new JTextArea();
		textAddress.setForeground(SystemColor.desktop);
		textAddress.setEditable(false);
		textAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		textAddress.setBounds(475, 70, 215, 56);
		textAddress.setOpaque(false);
		add(textAddress);
		textAddress.setText(det.getAddress());
		
		JTextArea textPSkills = new JTextArea();
		textPSkills.setEditable(false);
		textPSkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textPSkills.setBounds(31, 286, 181, 108);
		textPSkills.setOpaque(false);
		add(textPSkills);
		textPSkills.setText(det.getSkills().getPskills());
		
		JTextArea textISkills = new JTextArea();
		textISkills.setEditable(false);
		textISkills.setFont(new Font("Tahoma", Font.BOLD, 11));
		textISkills.setBounds(244, 286, 196, 108);
		textISkills.setOpaque(false);
		add(textISkills);
		textISkills.setText(det.getSkills().getIskills());
		
		
		
		JTextArea textExp = new JTextArea();
		textExp.setText((String) null);
		textExp.setOpaque(false);
		textExp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textExp.setEditable(false);
		textExp.setBounds(447, 286, 181, 108);
		add(textExp);
		textExp.setText(det.getExp());
		
	}
}

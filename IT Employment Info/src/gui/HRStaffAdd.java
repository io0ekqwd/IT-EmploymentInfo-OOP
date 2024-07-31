package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MainFrame;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffAdd extends JPanel {
    private MainFrame main; // Reference to the main frame
    private JTextField textName;
    private JTextField textAge;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextField textPosition;
    private JTextField textStatus;
    private JTextArea textPS;
    private JTextArea textIS;
    private JTextArea textExp;
    private JTextArea textAddress;
    private ImageIcon imgI; // Image icon for the applicant's photo
    private Image img;
    private String imagePath; // Path to the applicant's photo

    // Constructor to initialize the panel
    public HRStaffAdd(MainFrame main) {
        setLayout(null);
        this.main = main;

        // Add button to add applicant details
        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(SystemColor.controlHighlight);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Collect data from text fields
                String name = textName.getText();
                int age = Integer.valueOf(textAge.getText());
                String email = textEmail.getText();
                String phone = textPhone.getText();
                String address = textAddress.getText();
                String position = textPosition.getText();
                String ps = textPS.getText();
                String is = textIS.getText();
                String status = textStatus.getText();
                String exp = textExp.getText();
                // Call controller to add applicant
                main.getController().addApplicant(name, age, email, phone, address, position, ps, is, status, exp, imagePath);
                main.getController().writeFile(); // Write applicant profile to json file
                main.showHRStaffApplicantPage(); // Show applicant page after adding
            }
        });
        btnAdd.setBounds(464, 113, 86, 49);
        add(btnAdd);

        // Logout button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBackground(SystemColor.controlHighlight);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    main.showLogin();
                } else
                    return;
            }
        });
        btnLogout.setBounds(570, 9, 108, 49);
        add(btnLogout);

        // Back button
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(SystemColor.controlHighlight);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffApplicantPage();
            }
        });
        btnBack.setBounds(10, 9, 116, 49);
        add(btnBack);

        // Label for the page title
        JLabel lblAddApplicantPage = new JLabel("Add Applicant Page");
        lblAddApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAddApplicantPage.setBounds(285, 9, 141, 25);
        add(lblAddApplicantPage);

        // Text fields for applicant details
        textName = new JTextField();
        textName.setBounds(310, 67, 116, 20);
        add(textName);
        textName.setColumns(10);

        textAge = new JTextField();
        textAge.setBounds(310, 98, 116, 20);
        add(textAge);
        textAge.setColumns(10);

        // Labels for text fields
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(267, 70, 46, 14);
        add(lblName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(273, 100, 27, 16);
        add(lblAge);

        textPhone = new JTextField();
        textPhone.setBounds(310, 127, 116, 20);
        add(textPhone);
        textPhone.setColumns(10);

        JLabel lblPhoneNo = new JLabel("Phone Number:");
        lblPhoneNo.setBounds(216, 129, 98,16);
        add(lblPhoneNo);

        textEmail = new JTextField();
        textEmail.setBounds(310, 158, 116, 22);
        add(textEmail);
        textEmail.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(267, 161, 46, 16);
        add(lblEmail);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(10, 228, 56, 16);
        add(lblAddress);

        JLabel lblPosition = new JLabel("Applied Position:");
        lblPosition.setBounds(210, 195, 116, 16);
        add(lblPosition);

        textPosition = new JTextField();
        textPosition.setBounds(310, 192, 116, 22);
        add(textPosition);
        textPosition.setColumns(10);

        JLabel lblSkills = new JLabel("Programming skills:");
        lblSkills.setBounds(10, 333, 161, 16);
        add(lblSkills);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(257, 228, 56, 16);
        add(lblStatus);

        textStatus = new JTextField();
        textStatus.setBounds(310, 225, 116, 22);
        add(textStatus);
        textStatus.setColumns(10);

        JLabel lblIndustrySkills = new JLabel("Industry skills:");
        lblIndustrySkills.setBounds(216, 333, 82, 16);
        add(lblIndustrySkills);

        textPS = new JTextArea();
        textPS.setBounds(10, 350, 182, 78);
        add(textPS);

        textIS = new JTextArea();
        textIS.setBounds(216, 350, 182, 78);
        add(textIS);

        textAddress = new JTextArea();
        textAddress.setBounds(10, 244, 182, 78);
        add(textAddress);

        // Label to display the image
        JLabel label = new JLabel(imgI);
        label.setBounds(31, 69, 161, 159);
        add(label);

        // Button to read applicant details from a file
        JButton btnReader = new JButton("Read");
        btnReader.setBackground(SystemColor.controlHighlight);
        btnReader.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");
                chooser.setFileFilter(filter);
                chooser.showOpenDialog(chooser);
                chooser.setVisible(true);
                if (chooser.getSelectedFile() == null)
                    return;
                //File file = new File(chooser.getSelectedFile().toString());
                try {
                	BufferedReader in = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                	String line;
                	try {
                		textName.setText("");
                		textAge.setText("");
                		textPhone.setText("");
                		textEmail.setText("");
                		textPosition.setText("");
                		textStatus.setText("");
                		textAddress.setText("");
                		textIS.setText("");
                		textPS.setText("");
                		textExp.setText("");
						while((line = in.readLine()) != null){
							 if (line.contains("Name")) 
		                        textName.setText(line.replace("Name:", "").trim());
		                     else if (line.contains("Age")) 
		                        textAge.setText(line.replace("Age:", "").trim());
		                     else if (line.contains("Phone Number")) 
		                        textPhone.setText(line.replace("Phone Number:", "").trim());
		                     else if (line.contains("Email")) 
		                        textEmail.setText(line.replace("Email:", "").trim());
		                     else if (line.contains("Position")) 
		                        textPosition.setText(line.replace("Position:", "").trim());
		                     else if (line.contains("Status")) 
		                        textStatus.setText(line.replace("Status:", "").trim());
		                     else if (line.contains("Address")||line.contains("."))
		                     {
		                    	 if(line.contains("Address"))
		                    	     textAddress.append(line.replace("Address:", "").trim()+"\n");
		                    	 else if(line.contains("."))
		                    		 textAddress.append(line.replace(".", "").trim()+"\n");
		                     }
		                     else if (line.contains("Programming")||line.contains(",")) 
		                     {
		                    	 if(line.contains("Programming"))
		                    		 textPS.append(line.replace("Programming Skills:", "").trim()+"\n");
		                    	 else if(line.contains(","))
		                    		 textPS.append(line.replace(",", "").trim()+"\n");
		                     }
			                    //textPS.append(line.replace("Programming Skills:", "").trim()+"\n");
		                     else if (line.contains("Indust")||line.contains("]"))
		                     {
		                    	 if(line.contains("Indust"))
		                    		 textIS.append(line.replace("Industrial Skills:", "").trim()+"\n");
		                    	 else if(line.contains("]"))
		                    		 textIS.append(line.replace("]", "").trim()+"\n");
		                     }
			                    //textIS.append(line.replace("Industrial Skills", "").trim()+"\n");
		                     else if (line.contains("Experiences")||line.contains(";"))
		                     {
		                    	 if(line.contains("Experiences"))
		                    		 textExp.append(line.replace("Experiences:", "").trim()+"\n");
		                    	 else if(line.contains(";"))
		                    		 textExp.append(line.replace(";", "").trim()+"\n");
		                     }
			                    //textExp.append(line.replace("Experiences:", "").trim()+"\n");
						}	
					}
					 catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    /*Scanner scanner = new Scanner(file);
                    String name = scanner.next();
                    String age = scanner.next();
                    String phone = scanner.next();
                    String email = scanner.next();
                    String pos = scanner.next();
                    String status = scanner.next();
                    scanner.close();
                    textName.setText(name);
                    textAge.setText(age);
                    textPhone.setText(phone);
                    textEmail.setText(email);
                    textPosition.setText(pos);
                    textStatus.setText(status);*/
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnReader.setBounds(578, 113, 86, 49);
        add(btnReader);

        // Button to add an image for the applicant
        JButton btnAddImage = new JButton("Add Image");
        btnAddImage.setBackground(SystemColor.controlHighlight);
        btnAddImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("image", "jpg", "png");
                chooser.setFileFilter(filter);
                chooser.showOpenDialog(chooser);
                chooser.setVisible(true);
                if (chooser.getSelectedFile() == null)
                    return;
                imagePath = chooser.getSelectedFile().getAbsolutePath(); // Store the image path
                imgI = new ImageIcon(imagePath);
                img = imgI.getImage();
                Image resizedImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                // Resize the image
                imgI = new ImageIcon(resizedImg);
                label.setIcon(imgI);
            }
        });
        btnAddImage.setBounds(464, 195, 200, 49);
        add(btnAddImage);
        
        JLabel lblExperience = new JLabel("Experience:");
        lblExperience.setBounds(423, 334, 98, 14);
        add(lblExperience);
        
        textExp = new JTextArea();
        textExp.setBounds(422, 350, 256, 78);
        add(textExp);
    }
}

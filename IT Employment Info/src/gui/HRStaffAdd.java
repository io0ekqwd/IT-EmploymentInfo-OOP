package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.MainFrame;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;

public class HRStaffAdd extends JPanel {
    private MainFrame main; // Reference to MainFrame
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
    private int age;
    private File open;
     

    //Initialise panel
    public HRStaffAdd(MainFrame main) {
        setLayout(null);
        this.main = main;

        //Button to add applicant details
        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(SystemColor.controlHighlight);
        btnAdd.addActionListener(new ActionListener() {
            private File open;

			public void actionPerformed(ActionEvent e) {
                //Collect details from textfields and textareas
                String name = textName.getText();
                try{
                   age = Integer.valueOf(textAge.getText());
                }
                catch(NumberFormatException e1){ //Catch instance of NumberFormatException to block non integer inputs
                	JOptionPane.showMessageDialog(main, "Please enter a valid age.");//Error message popup
                	return;
                }
                String email = textEmail.getText();
                String phone = textPhone.getText();
                String address = textAddress.getText();
                String position = textPosition.getText();
                String ps = textPS.getText();
                String is = textIS.getText();
                String status = textStatus.getText();
                String exp = textExp.getText();
                //Get empty status of textfields and textareas
                JTextField[] textFields = {textName, textAge, textEmail, textPhone, textPosition, textStatus};
                JTextArea[] textAreas = {textPS, textAddress, textIS, textExp};
                boolean textFieldsEmpty = false;
                boolean textAreasEmpty = false;
                for(int i=0;i<textFields.length;i++){
                	JTextField textField = textFields[i];
                	if(textField.getText().isEmpty()){
                		textFieldsEmpty = true;
                		break;
                	}	
                }
                for(int i=0;i<textAreas.length;i++){
                	JTextArea textArea = textAreas[i];
                	if(textArea.getText().isEmpty()){
                		textAreasEmpty = true;
                		break;
                	}	
                }
     
                //Verify empty status of textfields and textareas to block or allow add
                if(textAreasEmpty != true || textFieldsEmpty != true){
                // Call controller to add applicant
                	 try {
                	    open = new File(imagePath);//Open image file
                	    BufferedImage image = null;
                        try {
        					image = ImageIO.read(open);//Read image file
        				} catch (IOException e1) {
        					System.out.println("Error");
        				}
                        if(image!=null){
                        	String path = "profileimages/";//Set save location of image file
                        	String imageid = UUID.randomUUID().toString();//Generate unique id for image
                        	File output = new File(path, "image"+imageid+".png");//Set output and name of image
                        	try {
                        	    ImageIO.write(image, "png", output);//Create image file in save location
                        	    imagePath = output.getAbsolutePath();
                        	}	
        					catch (IOException e1) {
        						e1.printStackTrace();
        					}
                        }
                        main.getController().addApplicant(name, age, email, phone, address, position, ps, is, status, exp, imagePath);
                        main.getController().writeFile(); // Write applicant profile to json file
                        main.showHRStaffApplicantPage(); // Show applicant page after adding
     				} catch (NullPointerException e1) {
     					JOptionPane.showMessageDialog(main, "Please add image.");
     				}
                    
                   
                }
                else
                    JOptionPane.showMessageDialog(main, "Please Fill in all details.");
            }
        });
        btnAdd.setBounds(464, 113, 86, 49);
        add(btnAdd);

        //Button to logout
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

        //Button to return to applicant page
        JButton btnBack = new JButton("Back");
        btnBack.setBackground(SystemColor.controlHighlight);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.showHRStaffApplicantPage();
            }
        });
        btnBack.setBounds(10, 9, 116, 49);
        add(btnBack);

        //Label for applicant page
        JLabel lblAddApplicantPage = new JLabel("Add Applicant Page");
        lblAddApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblAddApplicantPage.setBounds(285, 9, 141, 25);
        add(lblAddApplicantPage);

        //Textfields and textareas for applicant details
        textName = new JTextField();
        textName.setBounds(310, 67, 116, 20);
        add(textName);
        textName.setColumns(10);

        textAge = new JTextField();
        textAge.setBounds(310, 98, 116, 20);
        add(textAge);
        textAge.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setBounds(310, 127, 116, 20);
        add(textPhone);
        textPhone.setColumns(10);
        
        textEmail = new JTextField();
        textEmail.setBounds(310, 158, 116, 22);
        add(textEmail);
        textEmail.setColumns(10);
        
        textPosition = new JTextField();
        textPosition.setBounds(310, 192, 116, 22);
        add(textPosition);
        textPosition.setColumns(10);
        
        textStatus = new JTextField();
        textStatus.setBounds(310, 225, 116, 22);
        add(textStatus);
        textStatus.setColumns(10);
       
        textPS = new JTextArea();
        textPS.setBounds(10, 350, 182, 78);
        add(textPS);
        
        textIS = new JTextArea();
        textIS.setBounds(216, 350, 182, 78);
        add(textIS);
        
        textAddress = new JTextArea();
        textAddress.setBounds(10, 244, 182, 78);
        add(textAddress);
        
        textExp = new JTextArea();
        textExp.setBounds(422, 350, 256, 78);
        add(textExp);

        //Labels for textfields
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(267, 70, 46, 14);
        add(lblName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(273, 100, 27, 16);
        add(lblAge);

        JLabel lblPhoneNo = new JLabel("Phone Number:");
        lblPhoneNo.setBounds(216, 129, 98,16);
        add(lblPhoneNo);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(267, 161, 46, 16);
        add(lblEmail);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(10, 228, 56, 16);
        add(lblAddress);

        JLabel lblPosition = new JLabel("Applied Position:");
        lblPosition.setBounds(210, 195, 116, 16);
        add(lblPosition);

        JLabel lblSkills = new JLabel("Programming skills:");
        lblSkills.setBounds(10, 333, 161, 16);
        add(lblSkills);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setBounds(257, 228, 56, 16);
        add(lblStatus);

        JLabel lblIndustrySkills = new JLabel("Industry skills:");
        lblIndustrySkills.setBounds(216, 333, 82, 16);
        add(lblIndustrySkills);
        
        JLabel lblExperience = new JLabel("Experience:");
        lblExperience.setBounds(423, 334, 98, 14);
        add(lblExperience);

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
		                     else if (line.contains("Address"))
		                        textAddress.append(line.replace("Address:", "").trim()+"\n");
		                     else if (line.contains("Programming")) 
			                    textPS.append(line.replace("Programming Skills:", "").trim()+"\n");
		                     else if (line.contains("Indust"))
			                    textIS.append(line.replace("Industrial Skills", "").trim()+"\n");
		                     else if (line.contains("Experiences"))
			                    textExp.append(line.replace("Experiences:", "").trim()+"\n");
						}	
					}
					 catch (IOException e) {
						e.printStackTrace();
					}
                
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnReader.setBounds(578, 113, 86, 49);
        add(btnReader);

        //Add image to applicant profile
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
                imagePath = chooser.getSelectedFile().getAbsolutePath(); //Get image path on PC
                //Set the image 
                imgI = new ImageIcon(imagePath);
                img = imgI.getImage();
                Image resizedImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); // Resize the image
                imgI = new ImageIcon(resizedImg);
                label.setIcon(imgI);
            }
        });
        btnAddImage.setBounds(464, 195, 200, 49);
        add(btnAddImage);
        
        
    }
}

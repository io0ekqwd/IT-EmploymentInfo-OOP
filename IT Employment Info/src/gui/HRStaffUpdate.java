package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import controller.MainFrame;
import data.ApplicantDetails;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HRStaffUpdate extends JPanel {
    private MainFrame main; // Reference to the main frame
    private JTextField textName; // Text field for name
    private JTextField textAge; // Text field for age
    private JTextField textPhone; // Text field for phone number
    private JTextField textEmail; // Text field for email
    private JTextField textPosition; // Text field for applied position
    private JTextField textStatus; // Text field for applicant's status
    private JTextArea textPSkills; // Text area for programming skills
    private JTextArea textISkills; // Text area for industrial skills
    private JTextArea textAddress; // Text area for address
    private int index; // Index of the applicant being updated
    private JTextArea textExp;//Text area for experience
    private ApplicantDetails det; // Applicant details to be updated
    private JLabel imageLabel; // Label to display the applicant's image
    private String imagePath; // File object for the new image
    private Image img;
	private int age;

    //Initalise panel
    public HRStaffUpdate(MainFrame main, int ind, ApplicantDetails det) {
        setLayout(null);
        this.index = ind;
        this.det = det;
        this.main = main;

        //Logout button
        JButton button = new JButton("Logout");
        button.setBackground(SystemColor.controlHighlight);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    main.showLogin(); // Show login page on logout
                } else {
                    return;
                }
            }
        });
        button.setBounds(570, 9, 108, 49);
        add(button);

        //Button to return to the applicant page
        JButton button_1 = new JButton("Back");
        button_1.setBackground(SystemColor.controlHighlight);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                main.showHRStaffApplicantPage(); // Show applicant page
            }
        });
        button_1.setBounds(10, 9, 116, 49);
        add(button_1);

        //Label for the page title
        JLabel lblUpdateApplicantPage = new JLabel("Update Applicant Page");
        lblUpdateApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUpdateApplicantPage.setBounds(285, 9, 161, 25);
        add(lblUpdateApplicantPage);

        //Labels for applicant details
        JLabel label = new JLabel("Name:");
        label.setBounds(267, 70, 46, 14);
        add(label);

        JLabel label_1 = new JLabel("Age:");
        label_1.setBounds(273, 100, 27, 16);
        add(label_1);

        JLabel label_2 = new JLabel("Phone Number:");
        label_2.setBounds(216, 129, 98, 16);
        add(label_2);

        JLabel label_3 = new JLabel("Email:");
        label_3.setBounds(267, 161, 46, 16);
        add(label_3);

        JLabel label_4 = new JLabel("Address:");
        label_4.setBounds(10, 228, 56, 16);
        add(label_4);
       
        JLabel label_6 = new JLabel("Programming skills:");
        label_6.setBounds(10, 333, 161, 16);
        add(label_6);
        
        JLabel lblIndustrySkills = new JLabel("Industry skills:");
        lblIndustrySkills.setBounds(216, 333, 116, 16);
        add(lblIndustrySkills);
        
        JLabel label_7 = new JLabel("Status:");
        label_7.setBounds(257, 228, 56, 16);
        add(label_7);

        JLabel lblAppliedPosition = new JLabel("Applied Position:");
        lblAppliedPosition.setBounds(210, 195, 116, 16);
        add(lblAppliedPosition);

        //Update button to save changes
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(SystemColor.controlHighlight);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Collect updated details
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
                String ps = textPSkills.getText();
                String is = textISkills.getText();
                String status = textStatus.getText();
                String exp = textExp.getText();

                //Get empty status of textfields and textareas
                JTextField[] textFields = {textName, textAge, textEmail, textPhone, textPosition, textStatus};
                JTextArea[] textAreas = {textPSkills, textAddress, textISkills, textExp};
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
                //Update applicant profile
                main.getController().editApplicant(index, det, name, age, email, phone, address, position, ps, is, status, exp, imagePath);
                main.getController().writeFile(); // Write to json file
                main.showHRStaffApplicantPage(); // Return to the applicant page
            }
                else
                	JOptionPane.showMessageDialog(main, "Please Fill in all details.");
          }
        });
        btnUpdate.setBounds(464, 100, 200, 49);
        add(btnUpdate);

        //Initialise textfields and textareas with data for applicant details
        textName = new JTextField();
        textName.setColumns(10);
        textName.setBounds(310, 67, 116, 20);
        add(textName);
        textName.setText(det.getName());

        textAge = new JTextField();
        textAge.setColumns(10);
        textAge.setBounds(310, 98, 116, 20);
        add(textAge);
        textAge.setText(String.valueOf(det.getAge()));

        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(310, 127, 116, 20);
        add(textPhone);
        textPhone.setText(det.getPhone());

        textEmail = new JTextField();
        textEmail.setColumns(10);
        textEmail.setBounds(310, 158, 116, 22);
        add(textEmail);
        textEmail.setText(det.getEmail());

        textPosition = new JTextField();
        textPosition.setColumns(10);
        textPosition.setBounds(310, 192, 116, 22);
        add(textPosition);
        textPosition.setText(det.getAPosition());


        textStatus = new JTextField();
        textStatus.setColumns(10);
        textStatus.setBounds(310, 225, 116, 22);
        add(textStatus);
        textStatus.setText(det.getStatus());
        
        textPSkills = new JTextArea();
        textPSkills.setBounds(10, 350, 182, 70);
        add(textPSkills);
        textPSkills.setText(det.getSkills().getPskills());

        textISkills = new JTextArea();
        textISkills.setBounds(217, 350, 209, 69);
        add(textISkills);
        textISkills.setText(det.getSkills().getIskills());

        textAddress = new JTextArea();
        textAddress.setBounds(10, 247, 182, 81);
        add(textAddress);
        textAddress.setText(det.getAddress());

        //Label to display applicant image
        imageLabel = new JLabel("<Image>");
        imageLabel.setBounds(31, 69, 161, 159); 
        add(imageLabel);

        //Load and display the existing image
        if (det.getImagePath() != null) {
            setApplicantImage(det.getImagePath());
        }

        //Button to update the applicant image
        JButton btnAddImage = new JButton("Update Image");
        btnAddImage.setBackground(SystemColor.controlHighlight);
        btnAddImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "png");
                chooser.setFileFilter(filter);
                chooser.showOpenDialog(chooser);
                chooser.setVisible(true);
                if (chooser.getSelectedFile() == null)
                    return;
                imagePath = chooser.getSelectedFile().getAbsolutePath(); // Save the selected image file
                File open = new File(imagePath);//Open image file
                BufferedImage image = null;
                try {
				    image = ImageIO.read(open);//Read image file
				} catch (IOException e1) {
					e1.printStackTrace();
				}
                if(image!=null){
                	File output = new File(det.getImagePath());//Find image file
                	try {
                	    ImageIO.write(image, "png", output);//Override image file
                	}	
					catch (IOException e1) {
						e1.printStackTrace();
					}
                	imagePath = output.getPath();
                	ImageIcon imgI = new ImageIcon(imagePath);
                	img = imgI.getImage();
                    Image resizedImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH); // Resize the image
                    imgI = new ImageIcon(resizedImg);
                    imageLabel.setIcon(imgI);
                }
            }
        });
        btnAddImage.setBounds(464, 179, 200, 49);
        add(btnAddImage);
        
        JLabel label_5 = new JLabel("Experience:");
        label_5.setBounds(437, 334, 98, 14);
        add(label_5);
        
        textExp = new JTextArea();
        textExp.setBounds(436, 350, 182, 69);
        add(textExp);
        textExp.setText(det.getExp());
    }

    //Method to set the applicant's image in the label
    private void setApplicantImage(String imagePath) {
        if (imagePath != null) {
            try {
                Image img = ImageIO.read(new File(imagePath));
                Image resizedImg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(resizedImg)); // Display the image
            } catch (IOException e) {
            	 e.printStackTrace();
            }
        }
    }
}

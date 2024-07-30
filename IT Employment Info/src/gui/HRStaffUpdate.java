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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HRStaffUpdate extends JPanel {
    private MainFrame main;
    private JTextField textName;
    private JTextField textAge;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextField textPosition;
    private JTextField textStatus;
    private JTextArea textPSkills;
    private JTextArea textISkills;
    private JTextArea textAddress;
    private int index;
    private ApplicantDetails det;
    private JLabel imageLabel;
    private File imageFile;

    public HRStaffUpdate(MainFrame main, int ind, ApplicantDetails det) {
        setLayout(null);
        this.index = ind;
        this.det = det;
        this.main = main;

        JButton button = new JButton("Logout");
        button.setBackground(SystemColor.controlHighlight);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(main, "Are you sure to logout?", "Logout", JOptionPane.YES_NO_OPTION);
                if (opt == 0) {
                    main.showLogin();
                } else {
                    return;
                }
            }
        });
        button.setBounds(570, 9, 108, 49);
        add(button);

        JButton button_1 = new JButton("Back");
        button_1.setBackground(SystemColor.controlHighlight);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                main.showHRStaffApplicantPage();
            }
        });
        button_1.setBounds(10, 9, 116, 49);
        add(button_1);

        JLabel lblUpdateApplicantPage = new JLabel("Update Applicant Page");
        lblUpdateApplicantPage.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblUpdateApplicantPage.setBounds(285, 9, 161, 25);
        add(lblUpdateApplicantPage);

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

        JLabel lblAppliedPosition = new JLabel("Applied Position:\r\n");
        lblAppliedPosition.setBounds(210, 195, 116, 16);
        add(lblAppliedPosition);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(SystemColor.controlHighlight);
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textName.getText();
                int age = Integer.valueOf(textAge.getText());
                String email = textEmail.getText();
                String phone = textPhone.getText();
                String address = textAddress.getText();
                String position = textPosition.getText();
                String ps = textPSkills.getText();
                String is = textISkills.getText();
                String status = textStatus.getText();
                String imagePath = imageFile != null ? imageFile.getAbsolutePath() : det.getImagePath();
                main.getController().editApplicant(index, det, name, age, email, phone, address, position, ps, is, status, imagePath);
                main.showHRStaffApplicantPage();
                textName.setText("");
                textAge.setText("");
                textEmail.setText("");
                textPhone.setText("");
                textAddress.setText("");
                textPosition.setText("");
                textPSkills.setText("");
                textISkills.setText("");
                textStatus.setText("");
            }
        });
        btnUpdate.setBounds(464, 84, 86, 49);
        add(btnUpdate);

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

        JLabel label_7 = new JLabel("Status:");
        label_7.setBounds(257, 228, 56, 16);
        add(label_7);

        textStatus = new JTextField();
        textStatus.setColumns(10);
        textStatus.setBounds(310, 225, 116, 22);
        add(textStatus);
        textStatus.setText(det.getStatus());

        JLabel label_6 = new JLabel("Programming skills:\r\n\r\n");
        label_6.setBounds(10, 333, 161, 16);
        add(label_6);

        JLabel lblIndustrySkills = new JLabel("Industry skills:");
        lblIndustrySkills.setBounds(216, 333, 116, 16);
        add(lblIndustrySkills);

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

        imageLabel = new JLabel("<Image>");
        imageLabel.setBounds(31, 69, 161, 159); // Adjust the size as needed
        add(imageLabel);

        // Load and resize the image
        String imagePath = det.getImagePath();
        if (imagePath != null && !imagePath.isEmpty()) {
            setApplicantImage(imagePath); // Set the existing applicant image
        }

        JButton btnAddImage = new JButton("Update Image");
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
                imageFile = chooser.getSelectedFile(); // Save the file
                try {
                    Image img = ImageIO.read(imageFile);
                    Image resizedImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Resize the image
                    imageLabel.setIcon(new ImageIcon(resizedImg));
                } catch (IOException ex) {
                    System.out.println("Error loading image: " + ex.getMessage());
                }
            }
        });
        btnAddImage.setBounds(464, 144, 200, 49);
        add(btnAddImage);
    }

    private void setApplicantImage(String imagePath) {
        if (imagePath != null && !imagePath.isEmpty()) {
            try {
                Image img = ImageIO.read(new File(imagePath));
                Image resizedImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(resizedImg));
            } catch (IOException ex) {
                System.out.println("Error loading image: " + ex.getMessage());
            }
        }
    }
}

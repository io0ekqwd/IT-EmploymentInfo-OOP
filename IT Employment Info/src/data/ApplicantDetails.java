package data;

import javax.swing.ImageIcon;

public class ApplicantDetails {

    // Attributes of the applicant
    private String name;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String Aposition; // Applied position
    private String Hposition; // Hired position
    private String status;
    private Skills skills;
    private InterviewDetails intDet; // Interview details
    private int salary;
    private boolean shortlist; // Indicates if the applicant is shortlisted
    private boolean job; // Indicates if the applicant got the job
    private ImageIcon pImg; // Profile image
    private String imagePath; // Path to the profile image

    // Getter and setter for the profile image
    public ImageIcon getImage() {
        return pImg;
    }

    public void setImage(ImageIcon pImg) {
        this.pImg = pImg;
    }

    // Getter and setter for the status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and setter for the address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and setter for the email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for the name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for the skills
    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    // Getter and setter for the interview details
    public InterviewDetails getInterviewDetails() {
        return intDet;
    }

    public void setInterviewDetails(InterviewDetails intDet) {
        this.intDet = intDet;
    }

    // Getter and setter for the phone number
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and setter for the applied position
    public String getAPosition() {
        return Aposition;
    }

    public void setAPosition(String Aposition) {
        this.Aposition = Aposition;
    }

    // Getter and setter for the hired position
    public String getHPosition() {
        return Hposition;
    }

    public void setHPosition(String Hposition) {
        this.Hposition = Hposition;
    }

    // Getter and setter for the age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and setter for the salary
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Getter and setter for the shortlist status
    public boolean getShortlist() {
        return shortlist;
    }

    public void setShortlist(boolean shortlist) {
        this.shortlist = shortlist;
    }

    // Getter and setter for the job status
    public boolean getJob() {
        return job;
    }

    public void setJob(boolean job) {
        this.job = job;
    }

    // Getter and setter for the image path
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}

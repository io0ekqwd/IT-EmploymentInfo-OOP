package controller;

import java.awt.Image;

import javax.swing.ImageIcon;

import data.ApplicantDetails;
import data.DataStorage;
import data.InterviewDetails;
import data.Skills;
import data.User;

public class Controller {
    // Create an instance of DataStorage to manage data
    private DataStorage ds = new DataStorage();
    private String tt = "";

    //Read from json files
    public void readFile() {
        this.ds.readFile();
    }
    
    //Write to json files
    public void writeFile() {
    	this.ds.writeFile();
    }

    //Add applicant into datastorage
    public void addApplicant(String n, String a, String em, String ph, String ad, String pos, String ps, String is, String status,
    		String exp, String img) { 
        Skills skill = new Skills();
        skill.setPskills(ps);
        skill.setIskills(is);
        ApplicantDetails z = new ApplicantDetails();
        z.setName(n);
        z.setAge(Integer.valueOf(a));
        z.setEmail(em);
        z.setPhone(ph);
        z.setAddress(ad);
        z.setAPosition(pos);
        z.setSkills(skill);
        z.setStatus(status);
        z.setShortlist(false);
        z.setJob(false);
        z.setImagePath(img);
        z.setExp(exp);
        this.ds.addApplicant(z);    
    }
    
    //Get list of applicants
    public ApplicantDetails[] getAppList() {
        return this.ds.getAppList();
    }
    
    //Get list of fresh applicants
    public ApplicantDetails[] getMAppList() {
        return this.ds.getMAppList();
    }
    
    //Get list of shortlisted applicants
    public ApplicantDetails[] getSAppList() {
        return this.ds.getSAppList();
    }
    
    //Get list of users
    public User[] getUserList() {
		return this.ds.getUserList();
	}
    
    //Get list of applicants with job offer
    public ApplicantDetails[] getJAppList() {
        return this.ds.getJAppList();
    }

    //Set shortlist status for applicant
    public void shortlistApp(ApplicantDetails det) {
        det.setShortlist(true);
        this.ds.managerEditApp(det);    
    }
    
    //Set job status for applicant
    public void giveJob(ApplicantDetails det) {
        det.setJob(true);
        this.ds.managerEditApp(det);    
    }
    
    //Undo Job Offer
    public void undoJob(ApplicantDetails det) {
        det.setJob(false);
        this.ds.managerEditApp(det);
    }
    
    //Undo shortlisting
    public void undoShort(ApplicantDetails det) {
        det.setShortlist(false);
        this.ds.managerEditApp(det);
    }
    
    //Verify user credientials for login
    public boolean verifyUser(String n, String pwd) {
        String real = pwd;
        String cc = "";
        User t = ds.getUser(n);
        
        if(t != null) {
            cc = t.getPassword().toString();
            tt = t.getRole().toString();
            if (real.equals(cc))
                return true;
            else
                return false;
        }
        return false;
    }

    //Get role of user
    public String getRole() {
        return tt;
    }

    //Schedule interview date for shortlisted applicants
    public void scheInte(int index, ApplicantDetails det, int d, String m, String v, int y, int h, int min) {
        InterviewDetails intdet = new InterviewDetails();
        intdet.setDay(d);
        intdet.setMonth(m);
        intdet.setYear(y);
        intdet.setVenue(v);
        intdet.setHour(h);
        intdet.setMin(min);
        det.setInterviewDetails(intdet);
        this.ds.editApplicant(index, det);
    }

    //Store pageID into datastorage
    public void addID(String p) {
        this.ds.storeID(p);
    }
    
    //Retrieve pageID from datastorage
    public String getID(){
        return this.ds.getID();
    }

    //Remove pageID from datastorage
    public void clearID() {
        this.ds.removeID();
    }

    //Delete profile from datastorage
    public void deleteProf(ApplicantDetails det) {
        this.ds.deleteProf(det);
    }

    //Add Salary for new hires
    public void addSalary(ApplicantDetails det, int s) {
        det.setSalary(s);
        int index = this.ds.getProfIndex(det);
        this.ds.editApplicant(index, det);
    }

    //Edit applicant profile for HR Staff
    public void editApplicant(int index, ApplicantDetails det, String name, int age, String email, String phone, String address, String position,
            String ps, String is, String status, String exp, String image) {
        det.setName(name);
        det.setAge(age);
        det.setEmail(email);
        det.setPhone(phone);
        det.setAddress(address);
        det.setAPosition(position);
        det.getSkills().setIskills(is);
        det.getSkills().setPskills(ps);
        det.setStatus(status);
        det.setImagePath(image);
        det.setExp(exp);
        this.ds.editApplicant(index, det);    
    }

    //Get count for new hires
    public int getCount() {
        return this.ds.getJobCount();
    }

    //Add hired position to new hires
    public void addHPos(ApplicantDetails det, String hp) {
        det.setHPosition(hp);
        int index = this.ds.getProfIndex(det);
        this.ds.editApplicant(index, det);
    }

    //Retrieve index of applicant profile within aList vector
    public int getProfIndex(ApplicantDetails det) {
        return this.ds.getProfIndex(det);
    }

    //Delete user from datastorage
	public void deleteUser(int index, User u) {
		this.ds.deleteUser(index, u);
	}

	//Add user into datastorage
	public void addUser(String username, String pwd, String role) {
		User u = new User();
		u.setUsername(username);
		u.setPassword(pwd);
		u.setRole(role);
		this.ds.addUser(u);
	}

	public void editUser(int index, User user, String username, String pwd, String role) {
		user.setUsername(username);
		user.setPassword(pwd);
		user.setRole(role);
		this.ds.editUser(index, user);
	}
}

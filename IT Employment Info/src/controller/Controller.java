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

    /* Method to add a new applicant with provided details */
    public void addApplicant(String n, int a, String em, String ph, String ad, String pos, String ps, String is, String status,
    		String exp, String img) { 
        Skills skill = new Skills();
        skill.setPskills(ps);
        skill.setIskills(is);
        ApplicantDetails z = new ApplicantDetails();
        z.setName(n);
        z.setAge(a);
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
    
    /* Method to get the list of all applicants */
    public ApplicantDetails[] getAppList() {
        return this.ds.getAppList();
    }
    
    /* Method to get the list of shortlisted applicants */
    public ApplicantDetails[] getMAppList() {
        return this.ds.getMAppList();
    }
    
    /* Method to get the list of applicants for a specific position */
    public ApplicantDetails[] getSAppList() {
        return this.ds.getSAppList();
    }
    
    /* Method to get the list of applicants who have been offered a job */
    public ApplicantDetails[] getJAppList() {
        return this.ds.getJAppList();
    }

    /* Method to mark an applicant as shortlisted */
    public void shortlistApp(ApplicantDetails det) {
        det.setShortlist(true);
        this.ds.managerEditApp(det);    
    }
    
    /* Method to mark an applicant as having been offered a job */
    public void giveJob(ApplicantDetails det) {
        det.setJob(true);
        this.ds.managerEditApp(det);    
    }
    
    /* Method to undo the job offer to an applicant */
    public void undoJob(ApplicantDetails det) {
        det.setJob(false);
        this.ds.managerEditApp(det);
    }
    
    /* Method to undo the shortlisting of an applicant */
    public void undoShort(ApplicantDetails det) {
        det.setShortlist(false);
        this.ds.managerEditApp(det);
    }
    
    /* Method to verify the user credentials */
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

    /* Method to get the role of the current user */
    public String getRole() {
        return tt;
    }

    /* Method to schedule an interview for an applicant */
    public void scheInte(int index, ApplicantDetails det, int d, String m, String v, int y, int h, int min) {
        InterviewDetails intdet = new InterviewDetails();
        intdet.setDay(d);
        intdet.setMonth(m);
        intdet.setYear(y);
        intdet.setVenue(v);
        intdet.setHour(h);
        intdet.setMin(min);
        // intdet.setAmpm(ap);
        det.setInterviewDetails(intdet);
        this.ds.editApplicant(index, det);
    }

    /* Method to store an ID */
    public void addID(String p) {
        this.ds.storeID(p);
    }
    
    /* Method to get the stored ID */
    public String getID(){
        return this.ds.getID();
    }

    /* Method to clear the stored ID */
    public void clearID() {
        this.ds.removeID();
    }

    /* Method to delete an applicant profile */
    public void deleteProf(ApplicantDetails det) {
        this.ds.deleteProf(det);
    }

    /* Method to add a salary to an applicant's profile */
    public void addSalary(ApplicantDetails det, int s) {
        det.setSalary(s);
        int index = this.ds.getProfIndex(det);
        this.ds.editApplicant(index, det);
    }

    /* Method to edit an applicant's details */
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

    /* Method to get the count of applicants who have been offered a job */
    public int getCount() {
        return this.ds.getJobCount();
    }

    /* Method to add a hired position to an applicant's profile */
    public void addHPos(ApplicantDetails det, String hp) {
        det.setHPosition(hp);
        int index = this.ds.getProfIndex(det);
        this.ds.editApplicant(index, det);
    }

    /* Method to get the index of an applicant's profile */
    public int getProfIndex(ApplicantDetails det) {
        return this.ds.getProfIndex(det);
    }
}

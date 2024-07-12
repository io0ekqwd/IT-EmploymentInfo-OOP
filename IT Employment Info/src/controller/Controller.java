package controller;
import data.ApplicantDetails;
import data.DataStorage;
import data.InterviewDetails;
import data.Skills;
import data.User;


public class Controller {
	private DataStorage ds = new DataStorage();
	private String tt= "";
	
	public void addUser() {
		User u1 = new User("HR", "PHR", "Staff");
		User u2 = new User("M", "PM", "Manager");
		User u3 = new User("A" , "ADM", "Admin");
		this.ds.addUser(u1);
		this.ds.addUser(u2);
		this.ds.addUser(u3);
		//test
	}
	
	public Controller() {
	}
	
	//Test Code
	public void addProfile(String n, String ps, String is) {
		Skills skill = new Skills();
		skill.setPskills(ps);
		skill.setIskills(is);
		ApplicantDetails prof = new ApplicantDetails();
		prof.setSkills(skill);
		prof.setName(n);
		this.ds.addName(prof);
	}
    //Test Code	
			
	public ApplicantDetails[] getAppList() {
		return this.ds.getAppList();
	}
	public ApplicantDetails[] getSAppList() {
		return this.ds.getSAppList();
	}
	public ApplicantDetails[] getJobList() {
		return this.ds.getJobList();
	}
	
	


	public void shortlistApp(int index) {
		this.ds.shortlistApp(index);
	}
	public void giveJob(int index) {
		this.ds.giveJob(index);
	}

	
	public boolean verifyUser(String n, String pwd) {
		String real = pwd;
		String cc="";
		User t= ds.getUser(n);
		if(t!=null) {
			cc = t.getPassword().toString();
			tt = t.getRole().toString();
			if (real.equals(cc))
				return true;
			else
				return false;
		}
		return false;
	}

	public String verifyRole() {
		return tt;
	}

	public void scheInte(int index, ApplicantDetails det, String d, String m, String v, int y) {
		InterviewDetails intdet = new InterviewDetails();
		intdet.setDay(d);
		intdet.setMonth(m);
		intdet.setYear(y);
		intdet.setVenue(v);
		det.setInterviewDetails(intdet);
		this.ds.addInteDate(index, det);
	}
	}

	



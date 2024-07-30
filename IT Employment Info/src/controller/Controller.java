package controller;
import javax.swing.ImageIcon;

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
	
	public void addApplicant(String n, int a, String em, String ph, String ad, String pos, String ps, String is, String status, String imagePath) 
	{ 
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
		z.setImagePath(imagePath);
		this.ds.addApplicant(z);	
	}
	
			
	public ApplicantDetails[] getAppList() {
		return this.ds.getAppList();
	}
	
	public ApplicantDetails[] getMAppList() {
		return this.ds.getMAppList();
	}
	
	public ApplicantDetails[] getSAppList() {
		return this.ds.getSAppList();
	}
	
	public ApplicantDetails[] getJAppList() {
		return this.ds.getJAppList();
	}

	public void shortlistApp(ApplicantDetails det) {
		det.setShortlist(true);
		this.ds.managerEditApp(det);	
	}
	
	public void giveJob(ApplicantDetails det) {
		det.setJob(true);
		this.ds.managerEditApp(det);	
	}
	
	public void undoJob(ApplicantDetails det) {
		det.setJob(false);
		this.ds.managerEditApp(det);
	}
	
	public void undoShort(ApplicantDetails det) {
		det.setShortlist(false);
		this.ds.managerEditApp(det);
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

	public String getRole() {
		return tt;
	}

	public void scheInte(int index, ApplicantDetails det, int d, String m, String v, int y, int h, int min) {
		InterviewDetails intdet = new InterviewDetails();
		intdet.setDay(d);
		intdet.setMonth(m);
		intdet.setYear(y);
		intdet.setVenue(v);
		intdet.setHour(h);
		intdet.setMin(min);
		//intdet.setAmpm(ap);
		det.setInterviewDetails(intdet);
		this.ds.editApplicant(index, det);
	}

	public void addID(String p) {
		this.ds.storeID(p);
		
	}
	public String getID(){
		return this.ds.getID();
	}

	public void clearID() {
		this.ds.removeID();
	}

	public void deleteProf(ApplicantDetails det) {
		this.ds.deleteProf(det);
		
	}

	public void addSalary(ApplicantDetails det, int s) {
		det.setSalary(s);
	    int index = this.ds.getProfIndex(det);
		this.ds.editApplicant(index, det);
	}

	public void editApplicant(int index, ApplicantDetails det, String name, int age, String email, String phone, String address, String position,
			String ps, String is, String status, String imagePath) {
		det.setName(name);
		det.setAge(age);
		det.setEmail(email);
		det.setPhone(phone);
		det.setAddress(address);
		det.setAPosition(position);
		det.getSkills().setIskills(is);
		det.getSkills().setPskills(ps);
		det.setStatus(status);
		det.setImagePath(imagePath);
		this.ds.editApplicant(index, det);	
	}

	public int getCount() {
		return this.ds.getJobCount();
	}

	public void addHPos(ApplicantDetails det, String hp) {
		det.setHPosition(hp);
		int index = this.ds.getProfIndex(det);
		this.ds.editApplicant(index, det);
	}

	public int getProfIndex(ApplicantDetails det) {
		return this.ds.getProfIndex(det);
	}


	/*public void readFile(){
		ObjectMapper mapper = new ObjectMapper();
	}*/

	

	
}
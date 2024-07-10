package controller;
import data.ApplicantDetails;
import data.DataStorage;
import data.Skills;
import data.User;


public class Controller {
	private DataStorage ds = new DataStorage();
	
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
		Skills skill = new Skills(ps, is);
		ApplicantDetails name = new ApplicantDetails(n, skill);
		this.ds.addName(name);
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
			if (real.equals(cc))
				return true;
			else
				return false;
		}
		return false;
	}

	public String verifyRole(String n, String pwd) {
		String r = "";
		User t = ds.getUser(n);
		if (t!= null) 
		{
			r = t.getRole().toString();
			if (r == "Staff")
				return r;
			else if (r == "Manager")
				return r;
			else if (r == "Admin")
				return r;
			else
				return null;
		}
		return null;
	}
	}

	



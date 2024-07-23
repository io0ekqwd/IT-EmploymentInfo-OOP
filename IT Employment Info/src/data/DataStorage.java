package data;

import java.util.Vector;

public class DataStorage {
	
	private Vector<User> loginInfo = new Vector<User>();
	private Vector<ApplicantDetails>aList = new Vector<ApplicantDetails>();
	private Vector<ApplicantDetails>aListShort = new Vector<ApplicantDetails>();
	private Vector<ApplicantDetails>jobList = new Vector<ApplicantDetails>();
	private Vector<String> pageID = new Vector<String>();
	
	
	
	public ApplicantDetails[] getAppList() {
		String p = getID();
		ApplicantDetails[] opArr = null;
		if(p=="p1"){
		    opArr = new ApplicantDetails[this.aList.size()];
			this.aList.toArray(opArr);
		}
		else if(p=="p2"){
			opArr = new ApplicantDetails[this.aListShort.size()];
			this.aListShort.toArray(opArr);
		}
		else if(p=="p3"){
			opArr = new ApplicantDetails[this.jobList.size()];
			this.jobList.toArray(opArr);
		}
	    removeID();
		return opArr;
	}

	//Test
	public void addName(ApplicantDetails name) {
		this.aList.add(name);
		
	}
	//Test

	public void moveProf(int index) {
		String p = getID();
		if(p=="p1"){
			this.aListShort.add(aList.elementAt(index));
			this.aList.remove(index);
		}
		else if (p=="p2"){
			this.jobList.add(aListShort.elementAt(index));
			this.aListShort.remove(index);
		}
	}
		

	public void addUser(User u) {
		this.loginInfo.add(u);
		
	}
	public User getUser(String n) {
		for(int i=0; i<loginInfo.size();i++) {
			User temp = loginInfo.get(i);
			if(temp.getUsername().equals(n)) {
				return temp;
			}
		}
		return null;
}

	public void addInteDate(int index, ApplicantDetails det) {
		this.aListShort.set(index, det);
	}

	public void storeID(String p) {
		this.pageID.add(p);
	}

	public String getID() {
		return pageID.elementAt(0);
	}

	public void removeID() {
		this.pageID.clear();
	}


	public void storeSalary(int index, ApplicantDetails det) {
		this.jobList.set(index, det);
		
	}

	public void deleteProf(int index) {
		String p = getID();
		if (p.equals("p1"))
			this.aList.remove(index);
		if (p.equals("p2"))
			this.aListShort.remove(index);
		if (p.equals("p3"))
			this.jobList.remove(index);
		removeID();
	}
	
	public void addApplicant(ApplicantDetails z) {
		this.aList.add(z);
			System.out.println("Name: " + z.getName());
			System.out.println("Age: " + z.getAge());
			System.out.println("Phone Number: " + z.getPhone());
			System.out.println("Email: " + z.getEmail());
			System.out.println("Address: " + z.getAddress());
			System.out.println("Position: " + z.getPosition());
			System.out.println("Status: " + z.getStatus());
	}

	public void editApplicant(int index, ApplicantDetails det) {
		this.aList.set(index, det);
		
	}

	public int getJobCount() {
		return this.jobList.size();
	}
	
	
}

	

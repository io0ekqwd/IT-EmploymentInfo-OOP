package data;

import java.util.Vector;

public class DataStorage {
	
	private Vector<User> loginInfo = new Vector<User>();
	private Vector<ApplicantDetails>aList = new Vector<ApplicantDetails>();
	private Vector<ApplicantDetails>aListShort = new Vector<ApplicantDetails>();
	private Vector<ApplicantDetails>jobList = new Vector<ApplicantDetails>();
	private Vector<String> pageID = new Vector<String>();
	
	
	
	public ApplicantDetails[] getAppList() {
		ApplicantDetails[] opArr = new ApplicantDetails[this.aList.size()];
		this.aList.toArray(opArr);
		return opArr;
	}

	public ApplicantDetails[] getSAppList() {
		ApplicantDetails[] opArr = new ApplicantDetails[this.aListShort.size()];
		this.aListShort.toArray(opArr);
		return opArr;
	}
	
	public ApplicantDetails[] getJobList() {
		ApplicantDetails[] opArr = new ApplicantDetails[this.jobList.size()];
		this.jobList.toArray(opArr);
		return opArr;
	}

	//Test
	public void addName(ApplicantDetails name) {
		this.aList.add(name);
		
	}
	//Test

	public void shortlistApp(int index) {
		this.aListShort.add(aList.elementAt(index));
		this.aList.remove(index);
	}

	public void giveJob(int index) {
		this.jobList.add(aListShort.elementAt(index));
		this.aListShort.remove(index);
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
}

	

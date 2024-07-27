package data;

import java.util.Vector;

public class DataStorage {
	
	private Vector<User> loginInfo = new Vector<User>();
	private Vector<ApplicantDetails>aList = new Vector<ApplicantDetails>();
	private Vector<String> pageID = new Vector<String>(1);
	
	
	
	public ApplicantDetails[] getAppList() {
		ApplicantDetails[] opArr = null;
		opArr = new ApplicantDetails[this.aList.size()];
	    this.aList.toArray(opArr);
		return opArr;
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
		this.aList.set(index, det);
	}
//ID
	public void storeID(String p) {
		this.pageID.add(p);
	}

	public String getID() {
		return pageID.elementAt(0);
	}

	public void removeID() {
		this.pageID.clear();
	}
//ID

	public void storeSalary(int index, ApplicantDetails det) {
		this.aList.set(index, det);
		
	}

	public void deleteProf(int index) {
			this.aList.remove(index);
	}
	
	public void addApplicant(ApplicantDetails z) {
		this.aList.add(z);
			/*System.out.println("Name: " + z.getName());
			System.out.println("Age: " + z.getAge());
			System.out.println("Phone Number: " + z.getPhone());
			System.out.println("Email: " + z.getEmail());
			System.out.println("Address: " + z.getAddress());
			System.out.println("Position: " + z.getPosition());
			System.out.println("Status: " + z.getStatus());*/
	}

	public void editApplicant(int index, ApplicantDetails det) {
		this.aList.set(index, det);
		
	}

	public int getJobCount() {
		int cnt = 0;
		for(int i=0;i<aList.size();i++){
			ApplicantDetails a = aList.get(i);
			if(a.getJob() == true)
				cnt++;
		}
		return cnt;
	}
	
	
}

	

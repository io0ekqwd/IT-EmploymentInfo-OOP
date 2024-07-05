package data;

public class HRStaff {

	private String username;
	private String password;
	
	public String getUsername() {
	 	 return username; 
	}
	
	public void setUsername(String username) { 
		 this.username = username; 
	}
	
	public String getPassword() {
	 	 return password; 
	}

	public void setPassword(String password) { 
		 this.password = password; 
	}
	
	public HRStaff(String u, String p){
		this.username = u;
		this.password = p;
	}
	

	public void deleteProfile(int index) { 
		// TODO Auto-generated method
	 }
	
	 
	public ApplicantDetails addProfile() { 
		// TODO Auto-generated method
		return null;
	 }
	
	 
	public void generateList() { 
		// TODO Auto-generated method
	 }
	
	public void updateProfile(ApplicantDetails appDet, int index) { 
		// TODO Auto-generated method
	 }
	
	public HRStaff() { 
		// TODO Auto-generated method
	 } 

}

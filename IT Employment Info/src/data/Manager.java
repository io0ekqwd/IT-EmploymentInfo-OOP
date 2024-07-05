package data;

public class Manager {

	
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
	
	public Manager(String u, String p) { 
		this.username = u;
		this.password = p;
	 }
	
	/*
	public void viewDetails() { 
		// TODO Auto-generated method
	 }
	
	public void generateListJO() { 
		// TODO Auto-generated method
	 }
	
	
	
	
	
	public void viewSummary() { 
		// TODO Auto-generated method
	 }
	
	public int viewTotal() { 
		// TODO Auto-generated method
		return 0;
	 } */

}

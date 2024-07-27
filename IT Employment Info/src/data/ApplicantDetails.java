package data;

import javax.swing.ImageIcon;

public class ApplicantDetails {

	
	private String name;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String Aposition;
	private String Hposition;
	private String status;
	private Skills skills;
	private InterviewDetails intDet;
	private int salary;
	private boolean shortlist;
	private boolean job;
	private ImageIcon pImg;

	public ImageIcon getImage(){
		return pImg;
	}
	public void setImage(ImageIcon pImg){
		this.pImg = pImg;
	}
	
	public String getStatus() {
	 	 return status; 
	}
	public void setStatus(String status) { 
		 this.status = status; 
	}

	public String getAddress() {
	 	 return address; 
	}
	public void setAddress(String address) { 
		 this.address = address; 
	}
	public String getEmail() {
	 	 return email; 
	}
	public void setEmail(String email) { 
		 this.email = email; 
	}
	
	public String getName() {
	 	 return name; 
	}
	
	public void setName(String name) { 
		 this.name = name; 
	}
	
	public Skills getSkills() {
	 	 return skills; 
	}
	
	public void setSkills(Skills skills) { 
		 this.skills = skills; 
	}
	
	public InterviewDetails getInterviewDetails() {
	 	 return intDet; 
	}
	
	public void setInterviewDetails(InterviewDetails intDet) { 
		 this.intDet = intDet; 
	}
	
	public String getPhone() {
	 	 return phone; 
	}
	
	public void setPhone(String phone) { 
		 this.phone = phone; 
	}
	
	public String getAPosition() {
	 	 return Aposition; 
	}
	
	public void setAPosition(String Aposition) { 
		 this.Aposition = Aposition; 
	}
	public String getHPosition() {
	 	 return Hposition; 
	}
	
	public void setHPosition(String Hposition) { 
		 this.Hposition = Hposition; 
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public boolean getShortlist() {
		return shortlist;
	}
	
	public void setShortlist(boolean shortlist) {
		this.shortlist = shortlist;
	}
	
	public boolean getJob() {
		return job;
	}
	
	public void setJob(boolean job) {
		this.job = job;
	}
}

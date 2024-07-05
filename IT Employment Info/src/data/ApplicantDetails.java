package data;

public class ApplicantDetails {

	
	private String name;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String position;
	private String status;
	private Skills skills;
	
	private String venue;
	private String date;
	
	
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
	
	public String getPhone() {
	 	 return phone; 
	}
	
	public void setPhone(String phone) { 
		 this.phone = phone; 
	}
	
	public String getPosition() {
	 	 return position; 
	}
	
	public void setPosition(String position) { 
		 this.position = position; 
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getVenue() {
	 	 return venue; 
	}
	public void setVenue(String venue) { 
		 this.venue = venue; 
	}
	
	public String getDate() {
	 	 return date; 
	}
	public void setDate(String date) { 
		 this.date = date; 
	}
	
	
	public ApplicantDetails(String n, int a, String em, String ph, String ad, String pos, Skills sk) 
	{ 
		this.name = n;
		this.age = a;
		this.email = em;
		this.phone = ph;
		this.address = ad;
		this.position = pos;
		this.skills = sk;
	}
	
	//Test
	public ApplicantDetails(String n, Skills sk) 
	{
		this.name = n;
		this.skills = sk;
	}
	//Test
}

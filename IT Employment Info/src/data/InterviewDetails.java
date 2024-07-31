package data;

public class InterviewDetails {
	
	private String venue;
	private int day;
	private String month;
	private int year;
	private int hour;
	private int min;
	//private String ampm;
	
	public String getVenue() {
	 	 return venue; 
	}
	public void setVenue(String venue) { 
		 this.venue = venue; 
	}
	/*public String getAmpm() {
	 	 return ampm; 
	}
	public void setAmpm(String ampm) { 
		 this.ampm = ampm; 
	}*/
	public int getHour() {
	 	 return hour; 
	}
	public void setHour(int hour) { 
		 this.hour = hour; 
	}
	public int getMin() {
	 	 return min; 
	}
	public void setMin(int min) { 
		 this.min = min; 
	}
	
	public int getDay() {
	 	 return day; 
	}
	public void setDay(int day) { 
		 this.day = day; 
	}
	
	public String getMonth() {
	 	 return month; 
	}
	public void setMonth(String month) { 
		 this.month = month; 
	}
	
	public int getYear() {
	 	 return year; 
	}
	public void setYear(int year) { 
		 this.year= year; 
	}

}

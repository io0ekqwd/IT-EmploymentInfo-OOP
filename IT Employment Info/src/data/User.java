package data;

public class User {

		private String username;
		private String password;
		private String role;
		
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
		
		public String getRole() {
			return role;
		}
		
		public void setRole(String role) { 
			 this.role = role; 
		}
		
		public User(String u, String p, String r){
			this.username = u;
			this.password = p;
			this.role = r;
		}

}

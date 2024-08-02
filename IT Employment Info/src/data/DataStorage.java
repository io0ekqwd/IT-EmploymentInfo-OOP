package data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataStorage {
    
    //Vectors to store user login info, applicant profile and page ID
    private Vector<User> loginInfo = new Vector<User>();
    private Vector<ApplicantDetails> aList = new Vector<ApplicantDetails>();
    private Vector<String> pageID = new Vector<String>(1);
    
    //Read user data and applicant profile from their json files
    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            //Reading user information from user.json
            loginInfo = mapper.readValue(new File("json//user.json"), new TypeReference<Vector<User>>(){});
            //Reading applicant details from applicant.json
            aList = mapper.readValue(new File("json//applicant.json"), new TypeReference<Vector<ApplicantDetails>>(){});
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Write data into the json files
    public void writeFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			//Writing user data into user.json
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("json//user.json"), loginInfo);
			//Write applicant profile into applicant.json
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("json//applicant.json"), aList);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
    //Get Applicant List for HR Staff
    public ApplicantDetails[] getAppList() {
        ApplicantDetails[] opArr = new ApplicantDetails[this.aList.size()];
        this.aList.toArray(opArr);
        return opArr;
    }
    
    //Get list of fresh applicants
    public ApplicantDetails[] getMAppList() {
        ArrayList<ApplicantDetails> arr = new ArrayList<ApplicantDetails>();
        for (int i = 0; i < aList.size(); i++) {
            ApplicantDetails det = aList.get(i);
            if (det.getShortlist() == false && det.getJob() == false) {
                arr.add(det);
            }
        }
        ApplicantDetails[] opArr = new ApplicantDetails[arr.size()];
        arr.toArray(opArr);
        return opArr;
    }
    
    //Get list of shortlisted applicants
    public ApplicantDetails[] getSAppList() {
        ArrayList<ApplicantDetails> arr = new ArrayList<ApplicantDetails>();
        for (int i = 0; i < aList.size(); i++) {
            ApplicantDetails det = aList.get(i);
            if (det.getShortlist() == true && det.getJob() == false) {
                arr.add(det);
            }
        }
        ApplicantDetails[] opArr = new ApplicantDetails[arr.size()];
        arr.toArray(opArr);
        return opArr;
    }
    
    //Get lists of applicants who have gotten job offer
    public ApplicantDetails[] getJAppList() {
        ArrayList<ApplicantDetails> arr = new ArrayList<ApplicantDetails>();
        for (int i = 0; i < aList.size(); i++) {
            ApplicantDetails det = aList.get(i);
            if (det.getShortlist() == true && det.getJob() == true) {
                arr.add(det);
            }
        }
        ApplicantDetails[] opArr = new ApplicantDetails[arr.size()];
        arr.toArray(opArr);
        return opArr;
    }
    
    //Get list of users
    public User[] getUserList() {
    	User[] opArr = new User[this.loginInfo.size()];
    	this.loginInfo.toArray(opArr);
    	return opArr;
	}
    
    //Add applicant profile to aList vector
    public void addApplicant(ApplicantDetails z) {
        this.aList.add(z);
    }
    
    //Add user info into loginInfo vector
    public void addUser(User u) {
        this.loginInfo.add(u);
    }
    
    //Check for username
    public User getUser(String n) {
        for (int i = 0; i < loginInfo.size(); i++) {
            User temp = loginInfo.get(i);
            if (temp.getUsername().equals(n)) {
                return temp;
            }
        }
        return null;
    }
    
    //Add pageID in vector
    public void storeID(String p) {
        this.pageID.add(p);
    }
    //Get pageID from vector
    public String getID() {
        return pageID.elementAt(0);
    }
    //Remove the ID from vector
    public void removeID() {
        this.pageID.clear();
    }
    
    //Delete applicant profile from vector
    public void deleteProf(ApplicantDetails det) {
        int index = this.aList.indexOf(det);
        this.aList.remove(index);
    }
    
    //Edit applicant profile in vector
    public void editApplicant(int index, ApplicantDetails det) {
        this.aList.set(index, det);
    }
    
    //Get count of applicants with job offer
    public int getJobCount() {
        int cnt = 0;
        for (int i = 0; i < aList.size(); i++) {
            ApplicantDetails a = aList.get(i);
            if (a.getJob() == true)
                cnt++;
        }
        return cnt;
    }
    
    //Edit applicant profile for shortlisting, giving job offer, hired position and salary
    public void managerEditApp(ApplicantDetails det) {
        int index = this.aList.indexOf(det);
        this.aList.set(index, det);
    }
    
    //Get index of object within aList vector
    public int getProfIndex(ApplicantDetails det) {
        return this.aList.indexOf(det);
    }
    //Delete user from loginInfo
	public void deleteUser(int index, User u) {
		this.loginInfo.remove(index);
		this.loginInfo.remove(u);
	}
	//Edit user details
	public void editUser(int index, User user) {
		this.loginInfo.set(index, user);
	}

	
}

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
    
    // Vectors to store user login information, applicant details, and page IDs
    private Vector<User> loginInfo = new Vector<User>();
    private Vector<ApplicantDetails> aList = new Vector<ApplicantDetails>();
    private Vector<String> pageID = new Vector<String>(1);
    
    // Method to read user and applicant data from JSON files
    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Reading user information from user.json
            this.loginInfo = mapper.readValue(new File("json//user.json"), new TypeReference<Vector<User>>(){});
            // Reading applicant details from applicant.json
            this.aList = mapper.readValue(new File("json//applicant.json"), new TypeReference<Vector<ApplicantDetails>>(){});
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeFile() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("json//user.json"), this.loginInfo);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("json//applicant.json"), this.aList);
		} catch (StreamWriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    // Method to get the list of all applicants
    public ApplicantDetails[] getAppList() {
        ApplicantDetails[] opArr = new ApplicantDetails[this.aList.size()];
        this.aList.toArray(opArr);
        return opArr;
    }
    
    // Method to get the list of applicants who are neither shortlisted nor given a job
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
    
    // Method to get the list of shortlisted applicants who have not been given a job
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
    
    // Method to get the list of applicants who have been given a job
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
    
    // Method to add a new applicant to the list
    public void addApplicant(ApplicantDetails z) {
        this.aList.add(z);
    }
    
    // Method to add a new user to the login information
    public void addUser(User u) {
        this.loginInfo.add(u);
    }
    
    // Method to get a user by username
    public User getUser(String n) {
        for (int i = 0; i < loginInfo.size(); i++) {
            User temp = loginInfo.get(i);
            if (temp.getUsername().equals(n)) {
                return temp;
            }
        }
        return null;
    }
    
    // Methods to manage the page ID
    public void storeID(String p) {
        this.pageID.add(p);
    }

    public String getID() {
        return pageID.elementAt(0);
    }

    public void removeID() {
        this.pageID.clear();
    }
    
    // Method to delete an applicant profile
    public void deleteProf(ApplicantDetails det) {
        int index = this.aList.indexOf(det);
        this.aList.remove(index);
    }
    
    // Method to edit an applicant's details
    public void editApplicant(int index, ApplicantDetails det) {
        this.aList.set(index, det);
    }
    
    // Method to get the count of applicants who have been given a job
    public int getJobCount() {
        int cnt = 0;
        for (int i = 0; i < aList.size(); i++) {
            ApplicantDetails a = aList.get(i);
            if (a.getJob() == true)
                cnt++;
        }
        return cnt;
    }
    
    // Method to edit applicant details managed by a manager
    public void managerEditApp(ApplicantDetails det) {
        int index = this.aList.indexOf(det);
        this.aList.set(index, det);
    }
    
    // Method to get the index of an applicant in the list
    public int getProfIndex(ApplicantDetails det) {
        return this.aList.indexOf(det);
    }

	
}

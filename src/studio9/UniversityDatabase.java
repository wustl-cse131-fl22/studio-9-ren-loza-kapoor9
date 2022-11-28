package studio9;

import java.util.HashMap;

import assignment7.Student;

public class UniversityDatabase {

private final HashMap<String, Student> name; 



	public UniversityDatabase(HashMap<String, Student> name) {
	
	this.name = name;
 }

	public void addStudent(String accountName, Student student) {
	 name.put(accountName, student);
	}

	public int getStudentCount() {
		
		return name.size();
		
	}

	public String lookupFullName(String accountName) {
		  for (String studentName: name) {
				if(name.containsKey(studentName) == false) {
					return null;	
				}
				else {
					name.put(accountName, name.get(studentName));
				}
				}
			    return accountName; 
	}

	public double getTotalBearBucks() {
		// TODO
		return 0.0;
	}
}

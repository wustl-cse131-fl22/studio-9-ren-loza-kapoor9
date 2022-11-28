package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.

 
public class Student {
	
	private String firstName ;
	private String lastName; 
	private int studentID;
	private int attemptedCredits; 
	private int passingCredits;
	private double totalGradeQualitypoints;
	private double bearBucksBalance; 
	
	
	public Student(String firstName, String lastName, int studentID) {
		this.firstName = firstName ;
		this.lastName = lastName ;
		this.studentID = studentID; 
	}
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getAttemptedCredits() {
		return attemptedCredits;
	}


	public void setAttemptedCredits(int attemptedCredits) {
		this.attemptedCredits = attemptedCredits;
	}


	public int getPassingCredits() {
		return passingCredits;
	}


	public void setPassingCredits(int passingCredits) {
		this.passingCredits = passingCredits;
	}


	public double getTotalGradeQualitypoints() {
		return totalGradeQualitypoints;
	}


	public void setTotalGradeQualitypoints(double totalGradeQualitypoints) {
		this.totalGradeQualitypoints = totalGradeQualitypoints;
	}


	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	/**
	 * returns bear bucks balance
	 * @param bearBucksBalance
	 */


	public void setBearBucksBalance(double bearBucksBalance) {
		this.bearBucksBalance = bearBucksBalance;
	}
 /**
  * above is getters and setters and this allows us to accesss and change the private instance variables 
  * @return
  */


	
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}
	
	
	public int getId() {
		return this.getStudentID();
	}
	
	/**  
	 * method return student ID number 
	 * @param grade
	 * @param credits
	 */
	
	
	public void submitGrade (double grade, int credits) {
		this.setAttemptedCredits(this.getAttemptedCredits() + credits);
		
		if (grade >= 1.7 ) {
		this.setPassingCredits(this.getPassingCredits() + credits);
	}
          this.setTotalGradeQualitypoints(this.getTotalGradeQualitypoints() + (grade * credits));
	}
	/**  
	 *  method to submit a grade for class 
	 * @return
	 */
	
	
	
	public int getTotalAttemptedCredits() {
		return this.getAttemptedCredits(); 
	}
	/**
	 *  method returns the number of attempted credits 
	 * @return
	 */
	
	public int getTotalPassingCredits() {
		return this.getPassingCredits();
	}
	/**
	 *  method returns the number of passing credits 
	 * @return
	 */
	
	public double calculateGradePointAverage() {
		return this.getTotalGradeQualitypoints()/ this.getAttemptedCredits();
	}
	
	/**
	 * method calculates the GPA
	 * @return
	 */

	
	public String getClassStanding() {
		String gradeLevel ; 
		if (this.getTotalPassingCredits() < 30) {
			gradeLevel = "First Year";
		}
		
		else if (this.getTotalPassingCredits() >= 30 && this.getTotalPassingCredits()<60) {
			gradeLevel = "Sophomore";	
		}
		
		else if  (this.getTotalPassingCredits()>=60 && this.getTotalPassingCredits() <90) {
			gradeLevel = "Junior"; 
		}
		else {
			gradeLevel= "Senior"; 
		}
		
		 return gradeLevel;
	}
	   
	/** 
	 * method calculates standing grade level 
	 * @return
	 */
	
	
	public boolean isEligibleForPhiBetaKappa() {
		boolean eligibility = true;
	if (this.getTotalPassingCredits() >= 98 && this.calculateGradePointAverage() >= 3.60 ) {
		eligibility = true; 
	}
	else if (this.getTotalPassingCredits() >= 75 && this.calculateGradePointAverage() >= 3.80) {
		eligibility = true; 
	}
	else {
		eligibility = false;
	}
	return eligibility; 
	}
	
	/**
	 *  method examines eligibility for frat
	 * @param amount
	 */

	
	public void depositBearBucks(double amount) {
		this.setBearBucksBalance(this.getBearBucksBalance() + amount);
	}
	/** 
	 * method adds bear bucks 
	 * @param amount
	 */
	
	public void deductBearBucks (double amount) {
		this.setBearBucksBalance(this.getBearBucksBalance() - amount);
	}
	/**
	 *  method withdrawals bear bucks 
	 * @return
	 */
	
	public double cashOutBearBucks(){
		double cash = this.getBearBucksBalance()- 10;
		
		if (cash <0) {
			cash = 0;
		}
		
		this.setBearBucksBalance(0);
		return cash;
	}

	/**
	 *  withdrawls all the money in the bearbucks account 
	 * @param firstName
	 * @param other
	 * @param isHyphenated
	 * @param id
	 * @return
	 */
	
	
	public Student createLegacy (String firstName, Student other, boolean isHyphenated, int id){
		 
		String nameLast; 
		
		if (isHyphenated == true) {
			nameLast = this.getLastName() + "-" + other.getLastName();
	}
		else {
			nameLast = this.getLastName();
		}
		
		
		Student legacy = new Student (firstName,nameLast, id);
		legacy.setBearBucksBalance(this.cashOutBearBucks() + other.cashOutBearBucks());
		return legacy;
	}

	 /**
	  * first checked if their name is hyphenated and updating it as it goees along
	  * then created a new student by combining the parents bear bucks
	  * method creates the legacy 
	  * legacy creates a new student 
	  */
	
	 
	 public String toString() {
		 return "Student's full name: " + this.getFullName() + " " + ", Student ID number:" + this.getId();
	 }
}
/**
 * returns full name 
 */
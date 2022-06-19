package p02;
//********************************************************************************************************
//CLASS: Student (Student.java)
//
//DESCRIPTION: This class is a superclass of Students. Each student object has the attributes Credits, first name,
//last name, and tuition. These attributes have getter and setter methods. There is also an abstract method for calculating each students tuition
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, summer 2021
//Project Number: 02
//
//AUTHOR: Thomas Zeller, tjzeller, tjzeller@asu.edu;
//		  Michael Zeller, mrzeller, mrzeller@asu.edu;
//		  Daniel King, deking4, deking4@asu.edu;
//		  Mary Crowe,  mecrowe,	mecrowe@asu.edu;
			
//********************************************************************************************************
public abstract class Student implements Comparable<Student> {//Super class for OnCampusStudent and OnlineStudent
	private int mCredits;
	private String mFirstName;
	private String mId;
	private String mLastName;
	private double mTuition;
	/**
	 * Constructor for the student class
	 * @param pId
	 * @param pFirstName
	 * @param pLastName
	 */
	public Student(String pId, String pFirstName, String pLastName) {
		mId = pId;
		mFirstName = pFirstName;
		mLastName = pLastName;
	}
	/**
	 * abstract method so the subclasses are forced to implement calcTuition
	 */
	public abstract void calcTuition();
	@Override
	public int compareTo(Student pStudent) {
		return getId().compareTo(pStudent.getId());
	}
	/**
	 * gets credits
	 * @return mCredits
	 */
	public int getCredits() {
		return mCredits;
	}
	/**
	 * gets first name
	 * @return mFirstName
	 */
	public String getFirstName() {
		return mFirstName;
	}
	/**
	 * gets Id
	 * @return mId
	 */
	public String getId() {
		return mId;
	}
	/**
	 * gets last name
	 * @return mListName
	 */
	public String getLastName() {
		return mLastName;
	}
	/**
	 * gets tuition
	 * @return mTuition
	 */
	public double getTuition() {
		return mTuition;
	}
	/**
	 * Sets credits
	 * @param pCredits
	 */
	public void setCredits(int pCredits) {
		mCredits = pCredits;
	}
	/**
	 * Sets first name
	 * @param pFirstName
	 */
	public void setFirstName(String pFirstName) {
		mFirstName = pFirstName;
	}
	/**
	 * sets id
	 * @param pId
	 */
	public void setId(String pId) {
		mId = pId;
	}
	/**
	 * sets last name
	 * @param pLastName
	 */
	public void setLastName(String pLastName) {
		mLastName = pLastName;
	}
	/**
	 * sets tuition
	 * @param pTuition
	 */
	protected void setTuition(double pTuition) {
		mTuition = pTuition;
	}
}

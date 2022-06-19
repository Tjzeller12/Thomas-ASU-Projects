package p02;
//********************************************************************************************************
//CLASS: OnlineStudent (OnlineStudent.java)
//
//DESCRIPTION: This class is a subclass of the Student class. It has one new attribute for the students technology fee.
//There is a getter and setter for this variable. There is a method that calculates the students tuition and overrides the
//calcTuition method in the Student class.
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, summer 2021
//Project Number: 02
//
//AUTHOR: Thomas Zeller, tjzeller, tjzeller@asu.edu;
//		  Michael Zeller, mrzeller, mrzeller@asu.edu;
//		  Daniel King, deking4, deking4@asu.edu;
//		  Mary Crowe,  mecrowe,	mecrowe@asu.edu;
			
//********************************************************************************************************
public class OnlineStudent extends Student{
	private boolean mTechFee;
	/**
	 * Constructor for subclass OnlineStudent
	 * @param pId
	 * @param pFirstName
	 * @param pLastName
	 */
	public OnlineStudent(String pId, String pFirstName, String pLastName) {
		super(pId, pFirstName, pLastName);
	}
	/**
	 * Calculates tuition using the Students credits and technology fee
	 */
	@Override
	public void calcTuition() {
		double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
		if (getTechFee() == true) {
			t = t + TuitionConstants.ONLINE_TECH_FEE;
		}
		setTuition(t);//sets tuition
	}
	/**
	 * checks if student has a technology fee
	 * @return mTechFee
	 */
	public boolean getTechFee() {
		return mTechFee;
	}
	/**
	 * sets technology fee
	 * @param pTechFee
	 */
	public void setTechFee(boolean pTechFee) {
		mTechFee = pTechFee;
	}
}

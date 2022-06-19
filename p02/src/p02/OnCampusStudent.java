package p02;
//********************************************************************************************************
//CLASS: OnCampusStudent (OnCampusStudent.java)
//
//DESCRIPTION: This class is a subclass of the Student class. It adds the mResident and mProgramFee instance variables.
//There is a getter and setter method for these variables. There is a method that calculates the students tuition and overrides the
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
public class OnCampusStudent extends Student{
	public static final int RESIDENT = 1;
	public static final int NON_RESIDENT = 2;
	private int mResident;
	private double mProgramFee;
	/**
	 * Constructor for the subclass OnCampusStudent
	 * @param pId
	 * @param pFirstName
	 * @param pLastName
	 */
	public OnCampusStudent(String pId, String pFirstName, String pLastName) {
		super(pId, pFirstName, pLastName);
	}
	/**
	 * calculates the students tuition based off their credits and if they are a resident or not
	 */
	@Override
	public void calcTuition() {
		double t = 0;
		if (getResidency() == RESIDENT) {//check if they are a resident and adds the cost of being a resident
			t = TuitionConstants.ONCAMP_RES_BASE;
		} else {// if they are not a resident add the cost that someone who is not a resident would have to pay
			t = TuitionConstants.ONCAMP_NONRES_BASE;
		}
		t = t + getProgramFee();//adds the program fee
		if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {// if credits are less than max credits
			t = t + (getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;// calculate cost
		}
		setTuition(t);//set the price of tuition
	}
	/**
	 * gets program fee
	 * @return mProgramFee
	 */
	public double getProgramFee() {
		return mProgramFee;
	}
	/**
	 * gets residency
	 * @return mResident
	 */
	public int getResidency() {
		return mResident;
	}
	/**
	 * sets program fee
	 * @param pProgramFee
	 */
	public void setProgramFee(double pProgramFee) {
		mProgramFee = pProgramFee;
	}
	/**
	 * sets residency
	 * @param pResident
	 */
	public void setResidency(int pResident) {
		mResident = pResident;
	}
}

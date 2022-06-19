/**
 * A brief description of what the method does.
 */
//*********************************************************************************************
// CLASS: classname (Roster.java)
//
// COURSE AND PROJECT INFO:
// CSE205 Object Oriented Programming and Data Structures, summer 2021
// Project Number: 02
//
// AUTHOR: Thomas Zeller,   tjzeller,   tjzeller@asu.edu;
//		   Michael Zeller,  mrzeller,   mrzeller@asu.edu;
//		   Daniel King,     deking4,    deking4@asu.edu;
//		   Mary Crowe,      mecrowe,    mecrowe@asu.edu;
//*********************************************************************************************
package p03;

import java.util.ArrayList;

/**
 * The Roster class encapsulates an ArrayList<Student> object named
 * mStudentList which stores the information for each student that
 * was read from "gradebook.dat" when the app started.
 */
public class Roster {

    /**
     * Declare mStudentList as ArrayList<Student>
     */
    private ArrayList<Student> mStudentList;

    /**
     * Roster()
     *
     * PSEUDOCODE: method Roster() -- Note that mStudentList was
     * already declared so we do not need to declare it here. -- What
     * we need to do here is create the ArrayList<Student> object
     * that mStudentList -- will refer to. create an
     * ArrayList<Student> object and then pass that object as the
     * argument to setStudentList() to make mStudentList refer to the
     * ArrayList end Roster
     */
    public Roster() {
        mStudentList = new ArrayList<>();
    }

    /**
     * addStudent()
     *
     * Adds pstudent to the ArrayList
     *
     * PSEUDOCODE: method addStudent(pStudent : Student) : void add
     * (will append) pStudent to mStudentList end method
     */
    public void addStudent(Student pStudent) {
        mStudentList.add(pStudent);
    }

    /**
     * getStudent()
     *
     * Searches mStudentList for a Student with pLastName.
     *
     * PSEUDOCODE: method getStudent(pLastName : String) : Student --
     * Get the index of the student in the student list index = call
     * Searcher.search(getStudentList(), pLastName) -- If index is -1
     * then no student with that last name could be found so we
     * return -- null. Otherwise, we get the Student from the student
     * list at the index and return -- the Student. if index == -1
     * then return null else return the Student object in
     * getStudentList() at index 'index' end getStudent
     */
    public Student getStudent(String pLastName) {
        int index = Searcher.search(getStudentList(), pLastName);
        if (index == -1) {
            return null;
        } else {
            return mStudentList.get(index);
        }
    }

    /**
     * getStudentList()
     *
     * Accessor method for mStudentList.
     *
     * Note: it is extremely sleazy to provide public access to the
     * entire private student list (mStudentList) in this way because
     * it gives whoever calls this method the ability to modify any
     * Student in the roster. It would be better to have the Roster
     * class implement an iterator that would permit other objects to
     * iterate over the elements of the list, but in an effort to
     * keep the project as simple as possible, I am taking the sleazy
     * route.
     *
     * If you are so inclined, by all means, implement the iterator.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;

    }

    /**
     * setStudentList()
     *
     * Mutator method for mStudentList.
     */
    private void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * sortRoster() Called to sort the roster by last name.
     *
     * PSEUDOCODE: method sortRoster() -- Note that all of the
     * methods in Sorter are class methods, so we call the sort() --
     * method on the class Sorter. call Sorter.sort() passing the
     * list of students returned from getStudentList() end sortRoster
     */
    public void sortRoster() {
        Sorter.sort(mStudentList);
    }

    /**
     * Returns a String representation of this Roster. toString()
     * methods are very handy for debugging because given access to a
     * Roster object, say named roster, then you can print the entire
     * roster in one statement: System.out.println(roster);
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) {
            result += student + "\n";
        }
        return result;
    }
}

package p02;
//********************************************************************************************************
//INTERFACE: Comparable (Comparable.java)
//
//DESCRIPTION: This interface has a compareTo method that is used to compare one Student object to another
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, summer 2021
//Project Number: 02
//
//AUTHOR: Thomas Zeller, tjzeller, tjzeller@asu.edu;
//		  Michael Zeller, mrzeller, mrzeller@asu.edu;
//		  Daniel King, deking4, deking4@asu.edu;
//		  Mary Crowe,  mecrowe,	mecrowe@asu.edu;
			
//********************************************************************************************************
public interface Comparable<Student> {//forces programmer to implement compareTo method for the Student class
	public int compareTo(Student student);
}

package p02;
//********************************************************************************************************
//CLASS: Main (Main.java)
//
//DESCRIPTION: this program reads a file of students, puts them in an array, calculates each student tuition and writes an output file of
//students with their calculated tuition.
//COURSE AND PROJECT INFO
//CSE205 Object Oriented Programming and Data Structures, summer 2021
//Project Number: 02
//
//AUTHOR: Thomas Zeller, tjzeller, tjzeller@asu.edu;
//		  Michael Zeller, mrzeller, mrzeller@asu.edu;
//		  Daniel King, deking4, deking4@asu.edu;
//		  Mary Crowe,  mecrowe,	mecrowe@asu.edu;
			
//********************************************************************************************************
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Main test1 = new Main();
		test1.run();//runs program

	}
	/**
	 * This method calculates each tuition in an arrayList of students by calling the students calcTuition method
	 * @param pStudentList
	 */
	private void calcTuition(ArrayList<Student> pStudentList) {
		for (Student currentStudent : pStudentList) {
			currentStudent.calcTuition();
		}
	}
	/**
	 * This method reads an input file and determines if the student is an online or on campus student.
	 * Then it calls the readOnCampus or read readOnlineStudent methods and adds each student to an ArrayList.
	 * @return an ArrayList of Students
	 */
	private ArrayList<Student> readFile() throws FileNotFoundException{
		ArrayList<Student> listOfStudents = new ArrayList<>();
		File fileIn = new File("p02-students.txt");//file in
		Scanner fileInRead = new Scanner(fileIn);
		while(fileInRead.hasNextLine()) {
			if (fileInRead.next().equals("C")) {//if it is an on campus student
				OnCampusStudent newStudent = readOnCampusStudent(fileInRead);//read the student calling readOnCampusStudent
				listOfStudents.add(newStudent);//Add the Student to the ArrayList
				fileInRead.nextLine();//Goes to the next line of the input file to read the next student.
			} else {
				OnlineStudent newStudent = readOnlineStudent(fileInRead);//read the student calling readOnlinetudent
				listOfStudents.add(newStudent);//Add the Student to the ArrayList
				fileInRead.nextLine();//Goes to the next line of the input file to read the next student.
			}				
		}
		fileInRead.close();
		return listOfStudents;
	}
	/**
	 * Reads all of the on campus students from the input file. An sets their attributes 
	 * @param pIn
	 * @return newStudent
	 */
	private OnCampusStudent readOnCampusStudent(Scanner pIn) {
		String fileId = "";//variables for the attributes
		String fileFirstName = "";
		String fileLastName = "";
		String fileResidency = "";
		double fileProgramFee = 0;
		int fileCredits = 0;
		fileId = pIn.next();
		fileLastName = pIn.next();//reads the attributes
		fileFirstName = pIn.next();
		fileResidency = pIn.next();
		fileProgramFee = pIn.nextInt();
		fileCredits = pIn.nextInt();
		OnCampusStudent newStudent = new OnCampusStudent(fileId, fileFirstName, fileLastName);//constructs new OnCampusStudent and sets Id FirstName and LastName
		if (fileResidency.equals("R")) {//Checks if student is a resident and sets Residency accordingly
			newStudent.setResidency(OnCampusStudent.RESIDENT);
		} else {
			newStudent.setResidency(OnCampusStudent.NON_RESIDENT);
		}
		newStudent.setProgramFee(fileProgramFee);// sets ProgramFee
		newStudent.setCredits(fileCredits);// sets Credits
		return newStudent;//returns student
	}
	private OnlineStudent readOnlineStudent(Scanner pIn) {
		String fileId = "";//variables for the attributes
		String fileFirstName = "";
		String fileLastName = "";
		String fileTech = "";
		int fileCredits = 0;
		fileId = pIn.next();//reads the attributes
		fileLastName = pIn.next();
		fileFirstName = pIn.next();
		fileTech = pIn.next();
		fileCredits = pIn.nextInt();
		OnlineStudent newStudent = new OnlineStudent(fileId, fileFirstName, fileLastName);//constructs new OnlineStudent and sets Id FirstName and LastName
		if (fileTech.equals("T")) {//checks if the student has a technology fee
			newStudent.setTechFee(true);//if they do set to true
		} else {
			newStudent.setTechFee(false);//if they don't set to false
		}
		newStudent.setCredits(fileCredits);//sets Credits

		return newStudent;//returns Student
	} 
	/**
	 * runs the program by reading the file, calculates the tuition of every student on the file, and writing a file
	 */
	private void run() {
		try {
			ArrayList<Student> inputList = readFile();
			calcTuition(inputList);
			writeFile(inputList); 
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(-100);
		}
	}
	/**
	 * writes a file using the Student list that we created and formats it by Id, last name, first name, and the students tuition 
	 * @param pStudentList
	 */
	private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
		try {
			File outputFile = new File("p02-tuition.txt");//file we are writing to
			PrintWriter output = new PrintWriter(outputFile);
			Sorter sort = new Sorter();
			sort.insertionSort(pStudentList, 0);//Sorts the students by ID in an increasing order
			for (Student currentStudent : pStudentList) {
				output.printf("%-16s%-20s%-15s%8.2f", currentStudent.getId(), currentStudent.getLastName(), currentStudent.getFirstName(), currentStudent.getTuition());
				output.println();// formats by Id, last name, first name, the students tuition, and goes to the next line
			}
			output.close();//closes the file
		} catch(IOException e) {
			System.out.println("There was an IOException");
			System.exit(-200);
		}
	}
}

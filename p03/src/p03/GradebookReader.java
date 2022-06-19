/*
 * A brief description of what the method does.
 */
//*********************************************************************************************
// CLASS: classname (GradebookReader.java)
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * GradebookReader() reads the gradebook info from the file whose
 * name is passed to the ctor. Once the input file has been read, it
 * will return a Roster object containing the list of Students in the
 * course.
 */
public class GradebookReader {

    /**
     * mIn is used to read from the input file.
     */
    private Scanner mIn;

    /**
     * Attempts to open the gradebook file for reading. If
     * successful, mIn will be used to read from the file. If the
     * file cannot be opened, a FileNotFoundException will be thrown.
     *
     * Note that this method does not actually read the information
     * from the file. That is done lated when readRoster() is called
     * from Main.run().
     *
     * @throws FileNotFoundException
     *
     * @param pFname The name of the file to be opened for reading.
     * For this project it will be "gradebook.dat"
     */
    public GradebookReader(String pFname) throws FileNotFoundException {
        mIn = new Scanner(new File(pFname));
    }

    /**
     * Reads the exam scores for a Student.
     *
     * The number of exams is retrieved by calling the static
     * getNumExams() method in Main.
     *
     * @param pStudent The student for whom we are going to read the
     * exam scores from the input file.
     */
    private void readExam(Student pStudent) {
        for (int n = 0; n < Main.getNumExams(); ++n) {
            pStudent.addExam(mIn.nextInt());
        }
    }

    /**
     * Called to read the gradebook information. Calls readRoster()
     * to read the student records and then sorts the roster by last
     * name.
     *
     * Called from Main.run().
     *
     * @return The roster of students that was read from the input
     * file.
     */
    public Roster readGradebook() {
        Roster roster = readRoster();
        roster.sortRoster();
        return roster;
    }

    /**
     * Reads the homework scores for a Student.
     *
     * The number of homework assignments is retrieved by calling the
     * static getNumHomeworks() method in Main.
     *
     * @param pStudent The student for whom we are going to read the
     * homework scores from the input file.
     */
    private void readHomework(Student pStudent) {
        for (int n = 0; n < Main.getNumHomeworks(); ++n) {
            pStudent.addHomework(mIn.nextInt());
        }
    }

    /**
     * Reads the student information for each student in the input
     * file, adding each student to the roster.
     *
     * Called from readGradebook().
     *
     * @return The roster of students that was read from the input
     * file.
     */
    private Roster readRoster() {
        Roster roster = new Roster();
        while (mIn.hasNext()) {
            // See §2 Background for the format of each Student record in the input file.
            String lastName = mIn.next();
            String firstName = mIn.next();
            Student student = new Student(firstName, lastName);
            readExam(student);
            readHomework(student);
            roster.addStudent(student);
        }
        return roster;
    }
}

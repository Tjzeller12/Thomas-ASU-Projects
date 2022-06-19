/**
 * A brief description of what the method does.
 */
//*********************************************************************************************
// CLASS: classname (View.java)
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI. It is a subclass of JFrame and
 * implements the ActionListener interface so that we can respond to
 * user-initiated GUI events.
 */
public class View extends JFrame implements ActionListener {

    /**
     * The width and height of the View frame.
     */
    private static final int FRAME_WIDTH = 525;
    private static final int FRAME_HEIGHT = 225;

    /**
     * When the View() ctor is called from Main.run() to create the
     * View, run() passes a reference to the Main object as the
     * argument to View(). We save that reference into mMain and then
     * later we can use mMain to communicate with the Main class.
     * mMain is made accessible within this class via
     * accessor/mutator methods getMain() and setMain(). It shall not
     * be directly accessed.
     */
    private Main mMain;

    /**
     * Declare GUI related instance variables for the buttons and
     * text fields.
     */
    private JButton mClearButton;
    private JTextField[] mExamText;
    private JButton mExitButton;
    private JTextField[] mHomeworkText;
    private JButton saveButton;
    private JButton mSearchButton;
    private JTextField mStudentName;

    /**
     * View()
     *
     * The View constructor creates the GUI interface and makes the
     * frame visible at the end.
     *
     * @param pMain is an instance of the Main class. This links the
     * View to the Main class so they may communicate with each
     * other.
     */
    public View(Main pMain) {

        /**
         * Save a reference to the Main object pMain into instance
         * var mMain by calling setMain().
         */
        setMain(pMain);

        /**
         * panelSearch FlowLayout, Add a JLabel "Student Name: " to
         * panelSearch Create mStudentName and make the field 25 cols
         * wide Add mStudentName to the panel
         */
        JPanel panelSearch = new JPanel();
        JLabel studentName = new JLabel("Student Name: ");
        panelSearch.add(studentName);
        mStudentName = new JTextField(25);
        panelSearch.add(mStudentName);
        /**
         * Create mSearchButton with the label "Search" Make this
         * View the action listener for the button Add the button to
         * the panel
         */
        mSearchButton = new JButton("Search");
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);

        /**
         * panelHomework an array of JTextFields, one for each
         * homework assignment For i = 0 to the number of homework
         * assignments Do Create a textfield mHomeworkText[i]
         * displaying 5 cols Add mHomeworkText[i] to the panel End
         * For Note: DO NOT HARDCODE THE NUMBER OF HOMEWORK
         * ASSIGNMENTS
         */
        JPanel panelHomework = new JPanel();
        panelHomework.add(new JLabel("Homework: "));
        mHomeworkText = new JTextField[Main.getNumHomeworks()];
        for (int i = 0; i < Main.getNumHomeworks(); i++) {
            mHomeworkText[i] = new JTextField(Main.getNumHomeworks());
            panelHomework.add(mHomeworkText[i]);
        }

        /**
         * Create the exam panel which contains the "Exam: " label
         * and the two exam text fields. The pseudocode is omitted
         * because this code is very similar to the code that creates
         * the panelHomework panel above. Note: DO NOT HARDCODE THE
         * NUMBER OF EXAMS
         */
        JPanel panelExam = new JPanel();
        panelExam.add(new JLabel("Exam: "));
        mExamText = new JTextField[Main.getNumExams()];
        for (int i = 0; i < Main.getNumExams(); i++) {
            mExamText[i] = new JTextField(Main.getNumExams());
            panelExam.add(mExamText[i]);
        }

        /**
         * Create a JPanel named panelButtons using FlowLayout JPanel
         * panelButtons = new JPanel(); Create the Clear button
         * mClearButton labeled "Clear" Make this View the action
         * listener for mClearButton Add the Clear button to the
         * panel
         */
        JPanel panelButtons = new JPanel();
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);
        // Repeat the three above statements for the Save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        panelButtons.add(saveButton);
        // Repeat the three above statements for the Exit button
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);

        // Create a JPanel named panelMain using a vertical BoxLayout
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain
        // Add panelExam to panelMain
        // Add panelButtons to panelMain
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);
        // Set the title of the View to whatever you want by calling setTitle()
        setTitle("Gradebook");

        // Set the size of the View to FRAME_WIDTH x FRAME_HEIGHT
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // Make the View non-resizable
        setResizable(false);
        /**
         * Set the default close operation to
         * JFrame.DO_NOTHING_ON_CLOSE. This disables the X close
         * button in the title bar of the View so now the only way to
         * exit the program is by click- ing the Exit button. This
         * ensures that Main.exit() will be called so it will write
         * the student records back out to the gradebook database.
         */
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Add panelMain to the View.
        add(panelMain);

        // If you are a Mac user, you may need to call the pack() method which is inherited from
        // java.awt.Window() now to pack the View before displaying it. Windows and Linux users do
        // not need to do this, although if you do, it will not cause any problems.
        // ???
        // Now display the View by calling setVisible().
        setVisible(true);
    }

    /**
     * actionPerformed Called when one of the JButtons is clicked.
     * Detects which button was clicked and handles it. If the source
     * of the event was the Search button Then Clear the numbers in
     * the homework and exam fields lastName = retrieve the text from
     * the mStudentName text field If lastName is the empty string
     * Then Call messageBox() to display "Please enter the student's
     * last name."
     */
    @Override   // Prevent accidental overload
    public void actionPerformed(ActionEvent pEvent) {
        if (pEvent.getActionCommand().equals("Search")) {
            clearNumbers();
            String lastName = mStudentName.getText();
            if (lastName.isEmpty()) {
                this.messageBox("Please enter the student's last name.");

                /**
                 * Else -- Main contains a method named search()
                 * which given the last name of a student -- will
                 * search the Roster for the student. search() either
                 * returns the Student -- object if found, or if
                 * there is no student with that last name in the
                 * Roster, -- then search() returns null. Call
                 * getMain().search(lastName) and pass the return
                 * value to Student.setCurrStudent() If the curr
                 * student object saved in the Student class is null
                 * Then Call messageBox() to display "Student not
                 * found. Try again." Else Retrieve the curr student
                 * from the Student class and pass it to
                 * displayStudent() End if End If
                 */
            } else {
                Student.setCurrStudent(getMain().search(lastName));
                if (Student.getCurrStudent() == null) {
                    this.messageBox("Student not found. Try again.");
                } else {
                    displayStudent(Student.getCurrStudent());
                }
            }

            /**
             * Else if the source of the event was the Save button
             * Then If Student.getCurrStudent() is not null Then Call
             * saveStudent(Student.getCurrStudent())
             */
        } else if (pEvent.getActionCommand().equals("Save")) {
            if (Student.getCurrStudent() != null) {
                saveStudent(Student.getCurrStudent());
            }
            /**
             * Else if the source of the event was the Clear button
             * Then Call clear()
             */
        } else if (pEvent.getActionCommand().equals("Clear")) {
            clear();
            /**
             * Else if the source of the event was the Exit button
             * Then If Student.getCurrStudent() is not null Then Call
             * saveStudent(Student.getCurrStudent()) Call
             * getMain().exit() to terminate the application End If
             * end actionPerformed
             */
        } else if (pEvent.getActionCommand().equals("Exit")) {
            if (Student.getCurrStudent() != null) {
                saveStudent(Student.getCurrStudent());
                System.exit(-100);
            } else {
                System.exit(-200);
            }
        }
    }

    /**
     * clear Called when the Clear button is clicked. Clears all of
     * the text fields by setting the contents of each to the empty
     * string.
     *
     * After clear() returns, no student information is being edited
     * or displayed and mStudent has been set to null.
     */
    private void clear() {
        mStudentName.setText("");
        clearNumbers();
        Student.setCurrStudent(null);
    }

    /**
     * clearNumbers Clears the homework and exam fields.
     */
    private void clearNumbers() {
        for (int i = 0; i < Main.getNumHomeworks(); i++) {
            mHomeworkText[i].setText("");
        }
        for (int i = 0; i < Main.getNumExams(); i++) {
            mExamText[i].setText("");
        }
    }

    /**
     * displayStudent
     *
     * Displays the homework and exam scores for a student in the
     * mHomeworkText and mExamText text fields.
     *
     * @param pStudent is the Student who's scores we are going to
     * use to populate the text fields.
     *
     * PSEUDOCODE: method displayStudent(pStudent : Student) : void
     * For i = 0 to Main.getNumHomeworks - 1 Do int hw =
     * pStudent.getHomework(i) String hwstr = convert hw to a String
     * (Hint: Integer.toString()) mHomeworkText[i].setText(hwstr) End
     * For Write a similar for loop to place the student's exams
     * scores into the text fields end displayStudent
     */
    private void displayStudent(Student pStudent) {
    	mStudentName.setText(pStudent.getFullName());
        for (int i = 0; i < Main.getNumHomeworks(); i++) {
            Integer hwork = pStudent.getHomework(i);
            String hwStr = hwork.toString();
            mHomeworkText[i].setText(hwStr);
        }
        for (int i = 0; i < Main.getNumExams(); i++) {
            Integer exam = pStudent.getExam(i);
            String exStr = exam.toString();
            mExamText[i].setText(exStr);
        }
    }

    /**
     * Accessor method for mMain.
     */
    private Main getMain() {
        return mMain;
    }

    /**
     * messageBox Displays a message box containing some text. Note:
     * read the Java 8 API page for JOptionPane to see what the
     * constructor arguments are to showMessageDialog(). You want to
     * pass the appropriate "thing" for the first argument so your
     * message dialog window will be centered in the middle of the
     * View frame. If your View frame is centered in the middle of
     * your screen then you did not pass the right "thing".
     *
     * PSEUDOCODE: method messageBox(pMessage : String) : void Call
     * JOptionPane.showMessageDialog() to display pMessage. end
     * messageBox
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * saveStudent
     *
     * Retrieves the homework and exam scores for pStudent from the
     * text fields and writes the results to the Student record in
     * the Roster.
     *
     * PSEUDOCODE: method saveStudent(pStudent : Student) : void For
     * i = 0 to Main.getNumHomeworks - 1 Do String hwstr =
     * mHomeworkText[i].getText() int hw = convert hwstr to an int
     * (Hint: Integer.parseInt()) Call pStudent.setHomework(i, hw)
     * End For Write a similar for loop to save the exam scores in
     * pStudent end method saveStudent
     *
     * DO NOT HARDCODE THE NUMBER OF HOMEWORKS AND EXAMS
     */
    private void saveStudent(Student pStudent) {
        for (int i = 0; i < Main.getNumHomeworks(); i++) {
            String hwstr = mHomeworkText[i].getText();
            Integer hw = Integer.parseInt(hwstr);
            pStudent.setHomework(i, hw);
        }
        for (int i = 0; i < Main.getNumExams(); i++) {
            String exstr = mExamText[i].getText();
            Integer ex = Integer.parseInt(exstr);
            pStudent.setExam(i, ex);
        }
    }

    /**
     * Mutator method for mMain.
     */
    private void setMain(Main pMain) {
        mMain = pMain;
    }

}

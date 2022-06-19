/**
 * Class View. implements the GUI for performing calculations
 * provided by user.  Will close upon request.  Non-arithmetic
 * functions entered will prompt an error message.
 */
//*******************************************************************
// CLASS: SubOperator.java
//
// COURSE AND PROJECT INFO:
// CSE205 Object Oriented Programming and Data Structures, summer 2021
// Project Number: 04
//
// AUTHOR: Thomas Zeller,   tjzeller,   tjzeller@asu.edu;
//		   Michael Zeller,  mrzeller,   mrzeller@asu.edu;
//		   Daniel King,     deking4,    deking4@asu.edu;
//		   Mary Crowe,      mecrowe,    mecrowe@asu.edu;
//*******************************************************************
package p04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI.
 */
public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 180;

    // Declare instance variables
    private JButton mClearButton;
    private JButton mEvalButton;
    private JTextField mInputText;
    private JButton mExitButton;
    private Main mMain;
    private JLabel mResultLabel;

    /**
     * @param pMain sets mMain, The View constructor, to create the
     * GUI interface and makes the frame visible at the end.
     */
    public View(Main pMain) {
        // Save a reference to the Main object pMain in mMain.
        mMain = pMain;

        // PSEUDOCODE:
        // Declare and create a JPanel named panelLabel using the default FlowLayout layout manager.
        // Create mResultLabel as a JLabel initialized to the empty string ""
        // Add mResultLabel to panelLabel
        JPanel panelLabel = new JPanel();
        mResultLabel = new JLabel("");
        panelLabel.add(mResultLabel);

        // PSEUDOCODE:
        // Declare and create a JPanel named panelInput using the default FlowLayout layout manager.
        // Create mInputText as a JTextField initialized to 40 columns wide
        // Add mInputText to panelInput
        JPanel panelInput = new JPanel();
        mInputText = new JTextField(40);
        panelInput.add(mInputText);

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout.
        // Create the Clear button mClearButton.
        // Make this View the action listener for mClearButton.
        // Add the  Clear button to the panel.
        // Repeat the three above statements for the Evalute button.
        // Repeat the three above statements for the Exit button.
        JPanel panelButtons = new JPanel();
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);

        mEvalButton = new JButton("Evaluate");
        mEvalButton.addActionListener(this);
        panelButtons.add(mEvalButton);

        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);

        // PSEUDOCODE
        // Create a JPanel named panelMain using a vertical BoxLayout.
        // Add some vertical glue to panelMain
        // Add panelLabel to panelMain.
        // Add panelInput to panelMain.
        // Add panelButtons to panelMain.
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(Box.createVerticalGlue());
        panelMain.add(panelLabel);
        panelMain.add(panelInput);
        panelMain.add(panelButtons);
        setTitle("Kalkutron-9001");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelMain);
        setVisible(true);
    }

    /**
     * actionPerformed()
     *
     * Called when one of the JButtons is clicked. Detects which
     * button was clicked and handles it.
     *
     * @param pEvent If the source of the event was mClearbutton Then
     * Call clear() ElseIf the source of the event was mEvalButton
     * Then Call evaluate() ElseIf the source of the event was
     * mExitButton Then Call exit() on mMain. End If
     */
    @Override
    public void actionPerformed(ActionEvent pEvent) {
        try {
            if (pEvent.getActionCommand().equals("Clear")) {
                clear();
            } else if (pEvent.getActionCommand().equals("Evaluate")) {
                evaluate();
            } else if (pEvent.getActionCommand().equals("Exit")) {
                mMain.exit();
            }
        } catch (Exception e) {
            this.messageBox("Please enter a valid Math expression to be evaluated.");
        }
    }

    /**
     * clear() is called when the Clear button is clicked. Set the
     * text in mInputText and mResultLabel to the empty strings "".
     */
    private void clear() {
        mInputText.setText("");
        mResultLabel.setText("");
    }

    /**
     * evaluate() is called when the Evaluate button is clicked.
     *
     * PSEUDOCODE: Retrieve the text string from mInputText Declare
     * and create an Expression object named expr passing the text
     * string to the ctor Call expr.evaluate() and assign the return
     * value a Double object named result Display result in
     * mResultLabel (call toString on result)
     */
    private void evaluate() {
        String exprStr = mInputText.getText();
        Expression expr = new Expression(exprStr);
        Double result = expr.evaluate();
        mResultLabel.setText(result.toString());
    }

    /**
     * messageBox()
     *
     * @param pMessage set desired message in message box. Note that
     * passing 'this' as the first arg causes the View to be the
     * parent of the message dialog window, so the dialog will be
     * centered in the middle of the View. If we pass 'null' as the
     * argument, then the dialog does not have a parent frame and
     * will be centered in the middle of the display.
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

}

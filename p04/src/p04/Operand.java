/**
 * Class Operand. An operand is a numeric value represented as a Double.
 */
//*******************************************************************
// CLASS: Operand.java
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

/**
 * An operand is a numeric value represented as a Double.
 */
public class Operand extends Token {

    private Double mValue;

    /**
     * @param pValue takes Double value as arg; sets mValue.
     */
    public Operand(Double pValue) {
        setValue(pValue);
    }

    // Public accessor method for mValue.
    public Double getValue() {
        return mValue;
    }

    // Public mutator method for mValue.
    public void setValue(Double pValue) {
        mValue = pValue;
    }
}

/**
 * Class Operator. is the superclass of all binary and unary operators.
 */
//*******************************************************************
// CLASS: Operator.java
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
 * Operator is the superclass of all binary and unary operators.
 */
public abstract class Operator extends Token {

    public Operator() {
    }

    public abstract boolean isBinaryOperator();

    public abstract int precedence();

    public abstract int stackPrecedence();

    @Override
    public abstract String toString();
}

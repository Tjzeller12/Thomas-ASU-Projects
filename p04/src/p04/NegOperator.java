/**
 * Class NegOperator.  Represents the negation operator which is a
 * specific type of unary operator.
 */
//*******************************************************************
// CLASS: NegOperator.java
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
 * Represents the negation operator which is a specific type of unary
 * operator.
 */
public class NegOperator extends UnaryOperator {

    /*
   * <ctor> Initializes a NegOperator in memory with null value.
     */
    public NegOperator() {
    }

    /*
   * Takes in an Operand (Number) argument and returns that number with a negative sign.
     */
    @Override
    public Operand evaluate(Operand pOperand) {
        return new Operand(pOperand.getValue() * -1);
    }

    /**
     * @return the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 4;
    }

    /**
     * @return the precedence level of this operator when on it is on
     * the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 4;
    }

    @Override
    public String toString() {
        return " - ";
    }

}

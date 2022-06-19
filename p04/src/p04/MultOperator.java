/**
 * Class MultOperator.  Represents the multiplication operator which
 * is a specific type of binary operator.
 */
//*******************************************************************
// CLASS: MultOperator.java
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
 * Represents the multiplication operator which is a specific type of
 * binary operator.
 */
public class MultOperator extends BinaryOperator {

    /**
     * <ctor> Creates an Operand object set to null.
     */
    public MultOperator() {
    }

    /**
     * @param pLhsOperand Evaluates left and
     * @param pRhsOperand right operand to product expression
     * @return a Double.
     */
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() * pRhsOperand.getValue());
    }

    /**
     * @return the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 3;
    }

    /**
     * @return the precedence level of this operator when on it is on
     * the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 3;
    }

    @Override
    public String toString() {
        return " * ";
    }

}

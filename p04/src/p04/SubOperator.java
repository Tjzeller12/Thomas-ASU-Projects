/**
 * Class SubOperator. Represents the subtraction operator which is a
 * specific type of binary operator.
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

/**
 * Represents the subtraction operator which is a specific type of
 * binary operator.
 */
public class SubOperator extends BinaryOperator {

    /**
     * <ctor> Creates an Operand object set to null.
     */
    public SubOperator() {
    }

    /**
     * @param pLhsOperand Evaluates left and
     * @param pRhsOperand right operand to subtraction expression
     * @return a Double.
     */
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() - pRhsOperand.getValue());
    }

    /**
     * @return the mathematical precedence for this operator.
     */
    @Override
    public int precedence() {
        return 2;
    }

    /**
     * @return the STACK precedence for this operator.
     */
    @Override
    public int stackPrecedence() {
        return 2;
    }

    @Override
    public String toString() {
        return " - ";
    }

}

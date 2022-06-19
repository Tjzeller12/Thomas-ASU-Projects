/**
 *  Class AddOperator.  Represents the addition operator which is a
 * specific type of binary operator.
 *
 * Added toString Override to resolve abstract conflict with
 * Operator class.
 */
//*******************************************************************
// CLASS: AddOperator.java
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
// CLASS: AddOperator
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// http://www.devlang.com
//*******************************************************************
package p04;

/**
 * Represents the addition operator which is a specific type of
 * binary operator.
 */
public class AddOperator extends BinaryOperator {

    /**
     * <ctor> Creates an Operand object set to null.
     */
    public AddOperator() {
    }

    /**
     * @return the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 2;
    }

    /**
     * @return the precedence level of this operator when on it is on
     * the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 2;
    }

    @Override
    public String toString() {
        return " + ";
    }

	/**
	 * @param pLhsOperand Evaluates left and
	 * @param pRhsOperand right operand to addition expression
	 * @return a Double.
	 */
	@Override
	public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
	    return new Operand(pLhsOperand.getValue() + pRhsOperand.getValue());
	}

}

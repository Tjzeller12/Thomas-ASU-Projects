//**************************************************************************************************************
// CLASS: BinaryOperator
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// http://www.devlang.com
//**************************************************************************************************************
package p04;

/**
 * BinaryOperator is the superclass of all binary operators.
 */
public abstract class BinaryOperator extends Operator {

    public BinaryOperator() {
    }

    /**
     * @param pLhsOperand and
     * @param pRhsOperand Called to evaluate and
     * @return the operator.
     */
    public abstract Operand evaluate(Operand pLhsOperand, Operand pRhsOperand);

    /**
     * @return true since all subclasses of BinaryOperator are binary
     * operators.
     */
    @Override
    public boolean isBinaryOperator() {
        return true;
    }
}

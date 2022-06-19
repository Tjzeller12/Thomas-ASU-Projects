//**************************************************************************************************************
// CLASS: UnaryOperator
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
 * UnaryOperator is the superclass of all unary operators.
 */
public abstract class UnaryOperator extends Operator {

    public UnaryOperator() {
    }

    /**
     * @param pOperand Called to evaluate and
     * @return the operator.
     */
    public abstract Operand evaluate(Operand pOperand);

    /**
     * @param ()
     * @return false since all subclasses of UnaryOperator are unary
     * operators.
     */
    @Override
    public boolean isBinaryOperator() {
        return false;
    }

}

//**************************************************************************************************************
// CLASS: RightParen
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
 * Represents a right parenthesis in the expression.
 */
public class RightParen extends Parenthesis {

    public RightParen() {
    }

    /**
     * Right parentheses really don't have precedence since they are
     * not pushed on the operator stack, but we have to override
     * precedence() so we assign the lowest precedence level to
     * RightParen.
     *
     * @return the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 1;
    }

    /**
     * @return the precedence level of this operator when on it is on
     * the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 1;
    }

    @Override
    public String toString() {
        return ")";
    }

}

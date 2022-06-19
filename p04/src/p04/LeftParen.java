//**************************************************************************************************************
// CLASS: LeftParen
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
 * Represents a left parenthesis in the expression.
 */
public class LeftParen extends Parenthesis {

    public LeftParen() {
    }

    /**
     * @return the normal precedence level of this operator.
     */
    @Override
    public int precedence() {
        return 5;
    }

    /**
     * @return the precedence level of this operator when on it is on
     * the operator stack.
     */
    @Override
    public int stackPrecedence() {
        return 0;
    }

    @Override
    public String toString() {
        return "(";
    }

}

package org.application.NonTerminalExpression;

import org.application.Context;
import org.application.NumericExp;

public class DivisionExp implements NumericExp {
    private final NumericExp left;
    private final NumericExp right;
    public DivisionExp(NumericExp left, NumericExp right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public double evaluate(Context context) {
        if(right.evaluate(context) == 0)
            throw new ArithmeticException("Division by zero");
        return left.evaluate(context) / right.evaluate(context);
    }


}

package org.application.NonTerminalExpression;

import org.application.Context;
import org.application.NumericExp;

public class SubstractionExp implements NumericExp {
    private final NumericExp left;
    private final NumericExp right;
    public SubstractionExp(NumericExp left, NumericExp right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public double evaluate(Context context) {
        return left.evaluate(context) - right.evaluate(context);
    }


}

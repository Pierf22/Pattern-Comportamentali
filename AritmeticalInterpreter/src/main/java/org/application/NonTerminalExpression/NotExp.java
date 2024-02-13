package org.application.NonTerminalExpression;

import org.application.Context;
import org.application.NumericExp;

public class NotExp implements NumericExp {
    private final NumericExp numericExp;
    public NotExp(NumericExp numericExp){
        this.numericExp = numericExp;
    }

    @Override
    public double evaluate(Context context) {
        return -numericExp.evaluate(context);
    }


}

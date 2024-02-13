package org.application.TerminalExpression;

import org.application.Context;
import org.application.NumericExp;

public class VariableExp implements NumericExp {
    private final char name;
    public VariableExp(char name) {
        this.name = name;
    }
    @Override
    public double evaluate(Context context) {
        return context.lookup(name);
    }


}

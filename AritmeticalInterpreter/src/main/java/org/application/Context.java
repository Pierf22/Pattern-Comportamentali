package org.application;

import org.application.TerminalExpression.VariableExp;

import java.util.HashMap;

public class Context {
    HashMap<Character, Double> map = new HashMap<Character, Double>();
    public double lookup(char name){
        if(!map.containsKey(name))
            throw new IllegalArgumentException("Undefined Variable: ");
        return map.get(name);
    }
    void assign(char c, double value) {

        map.put(c, value);
    }
}

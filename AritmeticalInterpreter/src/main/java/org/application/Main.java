package org.application;

import org.application.NonTerminalExpression.DivisionExp;
import org.application.NonTerminalExpression.MultiplicationExp;
import org.application.NonTerminalExpression.SubstractionExp;
import org.application.NonTerminalExpression.SumExp;
import org.application.NonTerminalExpression.NotExp;
import org.application.TerminalExpression.VariableExp;

public class Main {
    public static void main(String[] args) {
        //espressione aritmetica rappresentata: (a+(-b))*(c-d)+ e/f +(c-d)
        NumericExp numericExp;
        Context context=new Context();


        VariableExp a=new VariableExp('a');
        VariableExp b=new VariableExp('b');
        VariableExp c=new VariableExp('c');
        VariableExp d=new VariableExp('d');
        VariableExp e=new VariableExp('e');
        VariableExp f=new VariableExp('f');
        context.assign('a', 10.4);
        context.assign('b', 55);
        context.assign('c', 11.45);
        context.assign('d', 25.7);
        context.assign('e', 42.123);
        context.assign('f', 20);

        SubstractionExp sub=new SubstractionExp(c,d);
        numericExp= new SumExp(new SumExp(new MultiplicationExp(new SumExp(a, new NotExp(b)), sub), new DivisionExp(e,f)), sub);

        double result=numericExp.evaluate(context);

        System.out.println("Il risultato è "+ result);

        /* test senza il pattern
        double aa = 10.4;
        double bb = 55;
        double cc = 11.45;
        double dd = 25.7;
        double ee = 42.123;
        double ff = 20;

        // Calcolo dell'espressione
        double result2 = (aa + (-bb)) * (cc - dd) + ee / ff + (cc - dd);

        // Stampa il risultato
        System.out.println("Il risultato è " + result2);  */





    }
}
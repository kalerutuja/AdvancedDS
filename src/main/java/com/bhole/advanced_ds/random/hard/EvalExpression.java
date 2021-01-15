package com.bhole.advanced_ds.random.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvalExpression {
    public int calculate(String exp) {
        Stack<String> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<exp.length(); i++) {
            Character c =  exp.charAt(i);
            if ( Character.isDigit(c)) {
                sb.append(c);
            } else
            if (c == ')') {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                String tmp = stack.pop();
                Stack<String> subExp = new Stack();
                while (!"(".equals(tmp)) {
                    subExp.push(tmp);
                    if(isOp(stack.peek())) {
                        subExp.push(stack.pop());
                        subExp.push(stack.pop());
                    }
                    tmp = stack.pop();
                }
                if (!subExp.isEmpty()) {
                   stack.push(evalSubExp(subExp));
                }
            } else {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                if(c != ' ') {
                    stack.push(String.valueOf(c));
                }

            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }
        if (stack.isEmpty()) {
            return 0;
        }
        Stack<String> rev = new Stack();
        while (!stack.isEmpty()) {
            rev.push(stack.pop());
        }
        return Integer.parseInt(evalSubExp(rev));
    }
    private String evalSubExp(Stack<String> subExp) {
        String tmp = subExp.pop();
        while (!subExp.isEmpty()) {
            if (isOp(subExp.peek())) {
                String op = subExp.pop();
                String operand = subExp.pop();
                subExp.push(compute(tmp, operand, op));
            }
            if(!subExp.isEmpty()) {
                if(isOp(tmp)) {
                    tmp = tmp+subExp.pop();
                } else {
                    tmp = subExp.pop();
                }
            }
        }
        return tmp;
    }

    private String compute(String operand1, String operand2, String op) {
        if ("+".equals(op)) {
            return (cal(operand1, operand2, '+'));
        } else {
            return (cal(operand1, operand2, '-'));
        }
    }
    private boolean isOp(String c) {
        return "+".equals(c) || "-".equals(c);
    }
    private String cal(String a,String b, char op) {
        if (op=='+') {
           return String.valueOf((Integer.parseInt(a)+Integer.parseInt(b)));
        }
        return String.valueOf((Integer.parseInt(a)-Integer.parseInt(b)));
    }
    public static void main(String args[]) {
        EvalExpression evalExpression = new EvalExpression();
        System.out.println(evalExpression.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(evalExpression.calculate(" 2-1 + 2 "));
        System.out.println(evalExpression.calculate("12345 "));
        System.out.println(evalExpression.calculate("1 + 1"));
        System.out.println(evalExpression.calculate("-2+ 1"));
    }
}

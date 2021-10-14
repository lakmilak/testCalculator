package com.example.testcalculator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class CalculatorBrains {
    private static Stack<String> stack;
    private static LinkedList<String> list = new LinkedList<>();

    public static String calculate(String inputLine){
        LinkedList<String> resultAfterStackMachine = stackMachine(MakeRequest.prepareLine(inputLine));
        String result = sortStation(resultAfterStackMachine);
        return result;
    }

    private static LinkedList<String> stackMachine(Collection<String> collection){
        stack = new Stack<>();
        LinkedList<String> postFix = new LinkedList<>();
        for(String s : collection){
            switch(operPriority(s)){
                case -2 -> postFix.add(s);
                case -1 -> {
                                while (!stack.isEmpty() && !stack.peek().equals(")"))
                                    if(!stack.peek().equals("("))
                                        postFix.add(stack.pop());
                                    else {
                                        stack.pop();
                                        break;
                                    }
                           }
                case 0 -> stack.push(s);
                case 1,2,3 -> {
                                while(!stack.isEmpty() && operPriority(s)<operPriority(stack.peek())){
                                    postFix.add(stack.pop());
                                }
                                stack.push(s);
                              }
                }
            }
        while (!stack.isEmpty())
            postFix.add(stack.pop());

        return postFix;
    }

    private static String sortStation(LinkedList<String> postFix){
        stack = new Stack<>();
        try{
            for(String s : postFix){
                if(operPriority(s) == -2)
                    stack.push(s);
                else{
                    if(stack.isEmpty()) throw new NullPointerException();
                    String rightNumber = stack.pop();
                    String leftNumber = null;
                    if(!stack.isEmpty())
                        leftNumber = stack.pop();
                    stack.push(operations(s,leftNumber,rightNumber));
                }
            }
        } catch (NullPointerException e){
            return "ERROR";
        }
        return stack.pop();
    }

    private static int operPriority(String oper){
        switch (oper){
            case("^") : return 3;
            case("*"),("/") : return 2;
            case("+"),("-") : return 1;
            case("(") : return 0;
            case(")") : return -1;
            default: return -2;
        }
    }

    private static String operations(String oper, String leftNumber, String rightNumber) throws NullPointerException{
        if(operPriority(oper) >= 2 && leftNumber == null) throw new NullPointerException();
        if(leftNumber == null) leftNumber = "0";
        double left = Double.parseDouble(leftNumber);
        double right = Double.parseDouble(rightNumber);
        double result = 0;
        switch (oper){
            case("+") -> result = left+right;
            case("-") -> result = left-right;
            case("*") -> result = left*right;
            case("/") -> result = left/right;
            case("^") -> result = Math.pow(left,right);
        }
        double temp = result*10000;
        temp = Math.round(temp);
        temp /= 10000;

        int wholePart = (int) result;
        if(temp - wholePart < 0.00001)
            return Integer.toString(wholePart);
        else
            return Double.toString(temp);
    }

}

package org.practice;

import java.util.ArrayDeque;

public class BalancedBrackets {

    public static boolean isValid(String s) {
        // Solution to be implemented
        ArrayDeque<String> deQ = new ArrayDeque<>();
        String[] strArr = s.split("");
        for(String str: strArr) {
            if(str.equals("{") || str.equals("[") || str.equals("(")) {
                deQ.add(str);
            }
            if(str.equals("}") || str.equals("]") || str.equals(")")) {
                String val = "";
                if(!deQ.isEmpty()) {
                    val = deQ.peekLast();
                }
                if(val.equals("{") && str.equals("}")){
                    deQ.removeLast();
                } else if(val.equals("[") && str.equals("]")){
                    deQ.removeLast();
                } else if(val.equals("(") && str.equals(")")){
                    deQ.removeLast();
                } else {
                    return false;
                }
            }
        }
        return deQ.size()==0;
    }

    public static void main(String[] args) {
        String expression = "{[()]}";
        System.out.println(isValid(expression));  // Expected Output: true
    }
}

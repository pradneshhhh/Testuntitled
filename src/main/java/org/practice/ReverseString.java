package org.practice;

public class ReverseString {

    public static void main(String[] args) {
        String str = "Hello, world!";
        String[] strArr = str.split("");
        StringBuilder strBldr = new StringBuilder();
        for(int i=strArr.length-1;i>=0;i--) {
            strBldr.append(strArr[i]);
        }
        System.out.println(strBldr);
    }
}

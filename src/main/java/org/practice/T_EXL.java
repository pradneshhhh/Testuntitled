package org.practice;

/**
 * Remove leading zeros from a given string.
 * Input: 000054686, Output: 54686
 * Input: 00034700980, Output: 34700980
 */
public class T_EXL {

    public static void main(String[] args) {
//        System.out.println(removeLeadingZeros("000054686"));
//        System.out.println(removeLeadingZeros("00034700980"));

        System.out.println(findLengthOfLastWord("Hello world"));
        System.out.println(findLengthOfLastWord(" fly me      to     the moon"));
        System.out.println(findLengthOfLastWord("Spring is most popular Java framework"));
    }

    public static String removeLeadingZeros(String str) {
        for(String s: str.split("")) {
            if(!s.equals("0")) {
                return str.substring(str.indexOf(s), str.length());
            }
        }
        return str;
    }

    public static int findLengthOfLastWord(String str) {
        String[] strArr = str.strip().split(" ");
        return strArr[strArr.length-1].length();
    }
}

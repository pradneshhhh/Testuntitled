package org.practice;

public class LongestCommonPrefix {

    private static String findCommonPrefix(String str1, String str2) {
        StringBuilder bldr = new StringBuilder();
        int length = Math.min(str1.length(), str2.length());
        for(int i=0;i<length;i++) {
            if(str1.charAt(i)==str2.charAt(i)) {
                bldr.append(str1.charAt(i));
            }
        }
        return bldr.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        if(strings.length==2) {
            System.out.println(findCommonPrefix(strings[0], strings[1]));
        } else {
            String starterPrefix = strings[0];
            for(int i=1;i<strings.length;i++) {
                starterPrefix = findCommonPrefix(starterPrefix, strings[i]);
            }
            System.out.println(starterPrefix);
        }
    }
}

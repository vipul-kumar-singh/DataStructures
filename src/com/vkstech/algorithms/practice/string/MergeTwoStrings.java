package com.vkstech.algorithms.practice.string;

/**
 * Given two strings S1 and S2 as input, the task is to merge them alternatively
 * i.e. the first character of S1 then the first character of S2 and so on till the strings end.
 */
public class MergeTwoStrings {

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Bye";

        System.out.println(mergeString(s1, s2));
    }

    private static String mergeString(String s1, String s2) {
        StringBuilder mergedString = new StringBuilder();
        int i = 0;
        while( i < s1.length() && i < s2.length()){
            mergedString.append(s1.charAt(i));
            mergedString.append(s2.charAt(i));
            i++;
        }

        if(i< s1.length()){
            mergedString.append(s1, i, s1.length());
        }

        if (i< s2.length()){
            mergedString.append(s2, i, s2.length());
        }

        return mergedString.toString();
    }
}

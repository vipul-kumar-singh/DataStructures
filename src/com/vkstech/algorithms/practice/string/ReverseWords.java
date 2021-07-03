package com.vkstech.algorithms.practice.string;

import java.util.StringJoiner;

/**
 * Reverse words in a given string
 * Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
 * Input: S = i.like.this.program.very.much
 * Output: much.very.program.this.like.i
 */
public class ReverseWords {

    public static void main(String[] args) {
        String input = "i.like.this.program.very.much";
        System.out.println(reverseWords(input));
    }

    private static String reverseWords(String str) {
        String[] strArr = str.split("\\.");
        StringJoiner stringJoiner = new StringJoiner(".");
        for (int i = strArr.length - 1; i>= 0; i--){
            stringJoiner.add(strArr[i]);
        }
        return stringJoiner.toString();
    }
}

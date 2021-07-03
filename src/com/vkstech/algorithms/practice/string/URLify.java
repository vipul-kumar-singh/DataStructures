package com.vkstech.algorithms.practice.string;

/**
 * URLify a given string
 * Write a method to replace all the spaces in a string with ‘%20’.
 * You may assume that the string has sufficient space at the end to hold the additional characters
 * and that you are given the “true” length of the string.
 * Input: "Mr John Smith    ", 13
 * Output: Mr%20John%20Smith
 */
public class URLify {

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println(getUrl(input));
    }

    private static String getUrl(String str) {
        char[] ch = str.toCharArray();
        int i = ch.length - 1;
        int trailingSpace = 0;

        while (ch[i] == ' ') {
            trailingSpace++;
            i--;
        }

        for (; i >= 0; i--) {
            if (ch[i] == ' ') {
                ch[i + trailingSpace--] = '0';
                ch[i + trailingSpace--] = '2';
                ch[i + trailingSpace] = '%';
            } else if (trailingSpace > 0) {
                ch[i + trailingSpace] = ch[i];
                ch[i] = ' ';
            }
        }

        return String.valueOf(ch);
    }
}

package com.vkstech.algorithms.practice3.string;

// https://www.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/1?page=1&difficulty
public class MinPalindromeLength {

    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(getMinElementsNeeded(s1));

        String s2 = "roorsp";
        System.out.println(getMinElementsNeeded(s2));

        String s3 = "aaaotcaakr";
        System.out.println(getMinElementsNeeded(s3));

        String s4 = "aacocaaakr";
        System.out.println(getMinElementsNeeded(s4));
    }

    private static int getMinElementsNeeded(String str) {
        String revStr = new StringBuilder(str).reverse().toString();
        String s = str + '#' + revStr;
        int n = s.length();

        int[] lps = new int[n];

        int pre = 0;
        int suf = 1;


        while (suf < n) {
            if (s.charAt(pre) == s.charAt(suf)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            } else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }

        return str.length() - lps[n - 1];
    }
}

package com.vkstech.algorithms.practice3.string;

import java.util.Arrays;

public class CircularStringMatching {

    public static void main(String[] args) {
        String s1 = "cdeabroab";
        String s2 = "abcde";
        System.out.println(isPatternExist(s1, s2));
    }

    private static boolean isPatternExist(String str1, String str2) {
        String str = str2 + str1 + str1;
        int n = str.length();

        int[] lps = new int[n];

        int pre = 0;
        int suf = 1;

        while (suf < n) {
            if (str.charAt(pre) == str.charAt(suf)) {
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

        return Arrays.stream(lps).anyMatch(num -> num == str2.length());
    }
}

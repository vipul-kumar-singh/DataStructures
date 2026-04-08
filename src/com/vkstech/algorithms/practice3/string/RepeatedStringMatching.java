package com.vkstech.algorithms.practice3.string;

import java.util.Arrays;

public class RepeatedStringMatching {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdabcdab";
        System.out.println(getRepeatCount(s1, s2));

        String s3 = "abc";
        String s4 = "wxyzwxyz";
        System.out.println(getRepeatCount(s3, s4));
    }

    private static int getRepeatCount(String str1, String str2) {
        if (str1.equals(str2))
            return 1;

        int repeat = 1;
        String temp = str1;

        while (temp.length() < str2.length()) {
            temp += str1;
            repeat++;
        }

        if (isLps(temp, str2))
            return repeat;

        if (isLps(temp + str1, str2))
            return repeat + 1;

        return -1;
    }

    private static boolean isLps(String str1, String str2) {
        String str = str2 + "#" + str1;
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
